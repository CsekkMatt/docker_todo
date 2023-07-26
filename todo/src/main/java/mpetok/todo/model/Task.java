package mpetok.todo.model;


import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Data
@Builder
public class Task {
    private String taskDescription;
    private String taskOwner;
    private Date creationDate;
}
