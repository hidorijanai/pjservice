package jp.co.smart.domain.repository.todo;

import java.util.Collection;

import jp.co.smart.domain.model.Todo;
import jp.co.smart.domain.repository.BaseRepository;

public interface TodoRepository extends BaseRepository<Todo, String> {

	Todo findOne(String todoId);

	Collection<Todo> findAll();

	void create(Todo todo);

	void update(Todo todo);

	void delete(String todoId);

	long countByFinished(boolean finished);
}
