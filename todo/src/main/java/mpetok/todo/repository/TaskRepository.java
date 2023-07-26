package mpetok.todo.repository;

import mpetok.todo.domain.TaskItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<TaskItem, String> {

    TaskItem findItemByTaskOwner(String taskOwner);


}
