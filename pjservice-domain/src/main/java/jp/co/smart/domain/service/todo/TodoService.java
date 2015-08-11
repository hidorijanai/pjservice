package jp.co.smart.domain.service.todo;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.smart.domain.model.Todo;
import jp.co.smart.domain.model.TodoExample;

public interface TodoService {

	Todo findOne(String todoId);

	Collection<Todo> findAll();

	Todo create(Todo todo);

	Todo finish(String todoId);

	void delete(String todoId);

	Page<Todo> findPage(TodoExample example, Pageable pageable);
}
