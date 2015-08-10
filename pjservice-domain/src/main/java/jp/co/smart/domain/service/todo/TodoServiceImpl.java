package jp.co.smart.domain.service.todo;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.terasoluna.gfw.common.date.jodatime.JodaTimeDateFactory;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import jp.co.smart.domain.model.Todo;
import jp.co.smart.domain.repository.todo.TodoRepository;
import jp.co.smart.domain.repository.todo.TodoRepositoryImpl;

@Service
public class TodoServiceImpl implements TodoService {

	private static final long MAX_UNFINISHED_COUNT = 5;

	@Inject
	JodaTimeDateFactory dateFactory;

	TodoRepository todoRepository = new TodoRepositoryImpl();

	@Override
	public Collection<Todo> findAll() {
		return todoRepository.findAll();
	}

	@Override
	public Todo create(Todo todo) {
		long unfinishedCount = todoRepository.countByFinished(false);
		if (unfinishedCount >= MAX_UNFINISHED_COUNT) {
			ResultMessages messages = ResultMessages.error();
            messages.add(ResultMessage
                    .fromText("[E001] The count of un-finished Todo must not be over "
                            + MAX_UNFINISHED_COUNT + "."));
            throw new BusinessException(messages);
		}

		String todoId = UUID.randomUUID().toString();

		Date createdAt = dateFactory.newDate();
		todo.setTodoId(todoId);
		todo.setCreatedAt(createdAt);
		todo.setFinished(false);

		todoRepository.create(todo);

		return todo;
	}

	@Override
	public Todo finish(String todoId) {
		Todo todo = findOne(todoId);
		if (todo.isFinished()) {
			ResultMessages messages = ResultMessages.error();
			messages.add(ResultMessage
                    .fromText("[E002] The requested Todo is already finished. (id=" + todoId + ")"));
            throw new BusinessException(messages);
		}

		todo.setFinished(true);
		todoRepository.update(todo);

		return todo;
	}

	@Override
	public void delete(String todoId) {
		todoRepository.delete(todoId);
	}

	@Override
	public Todo findOne(String todoId) {
		Todo todo = todoRepository.findOne(todoId);
		if (todo == null) {
			ResultMessages messages = ResultMessages.error();
			messages.add(ResultMessage.fromText("[E404] The requested Todo is not found. (id=" + todoId + ")"));
			throw new BusinessException(messages);
		}
		return todo;
	}

}
