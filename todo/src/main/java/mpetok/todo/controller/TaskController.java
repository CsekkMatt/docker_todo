package mpetok.todo.controller;

import mpetok.todo.domain.TaskItem;
import mpetok.todo.kafka.KafkaProducer;
import mpetok.todo.model.Task;
import mpetok.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/tasks")
    public ResponseEntity<?> getAllTasks() {
        return new ResponseEntity<>(List.of("task1", "task2", "task3"), HttpStatus.OK);
    }

    @PostMapping("/task")
    public ResponseEntity<?> createTask(Task task) {
        taskRepository.save(new TaskItem(UUID.randomUUID().toString(),
                task.getTaskDescription(), task.getTaskOwner(), task.getCreationDate()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/message")
    public ResponseEntity<?> postMessage(@RequestBody
                                         String message) {
        Objects.requireNonNull(message, "Message should not be null");
        System.out.println("Posting message on mytopic" + message);
        kafkaProducer.sendMessage("mytopic", message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
