package jp.co.smart.domain.repository.todo;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import jp.co.smart.domain.model.Todo;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

	private static final Map<String, Todo> TODO_MAP = new ConcurrentHashMap<String, Todo>();

	@Override
	public <S extends Todo> S save(S paramS) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public <S extends Todo> Collection<S> save(Collection<S> paramIterable) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean exists(String paramID) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public List<Todo> findAll(Collection<String> paramIterable) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public long count() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void delete(Collection<? extends Todo> paramIterable) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteAll() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public Collection<Todo> findAll(Sort paramSort) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Page<Todo> findAll(Pageable paramPageable) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Todo findOne(String todoId) {
		// TODO 自動生成されたメソッド・スタブ
		return TODO_MAP.get(todoId);
	}

	@Override
	public Collection<Todo> findAll() {
		// TODO 自動生成されたメソッド・スタブ
		return TODO_MAP.values();
	}

	@Override
	public void create(Todo todo) {
		// TODO 自動生成されたメソッド・スタブ
		TODO_MAP.put(todo.getTodoId(), todo);
	}

	@Override
	public void update(Todo todo) {
		// TODO 自動生成されたメソッド・スタブ
		TODO_MAP.put(todo.getTodoId(), todo);
	}

	@Override
	public void delete(String todoId) {
		// TODO 自動生成されたメソッド・スタブ
		TODO_MAP.remove(todoId);
	}

	@Override
	public long countByFinished(boolean finished) {
		long count = 0;
		for(Todo todo : TODO_MAP.values()) {
			if (finished == todo.isFinished()) {
				count++;
			}
		}
		return count;
	}

	@Override
	public void delete(Todo paramT) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
