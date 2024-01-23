package miu.edu.exams.jun23.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    public Task(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", description='" + description + '\'' +
                '}';
    }

}
