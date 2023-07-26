package mpetok.todo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("taskitems")
public class TaskItem {

    private String id;
    private String taskDescription;
    private String taskOwner;
    private Date creationDate;

    public TaskItem(String id, String taskDescription, String taskOwner, Date creationDate) {
        this.id = id;
        this.taskDescription = taskDescription;
        this.taskOwner = taskOwner;
        this.creationDate = creationDate;
    }
}
