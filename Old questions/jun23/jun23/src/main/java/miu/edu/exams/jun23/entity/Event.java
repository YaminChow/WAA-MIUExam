package miu.edu.exams.jun23.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long event_id;
    private String title;
    private String state;
    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)

    List<Task> tasks;

    @ManyToMany(mappedBy = "eventList")
    @JsonBackReference
    List <Coordinator> coordinatorList;

    public Event(String title,String state, List<Task> tasks){
        this.state = state;
        this.title = title;
        this.tasks = tasks;
    }


}
