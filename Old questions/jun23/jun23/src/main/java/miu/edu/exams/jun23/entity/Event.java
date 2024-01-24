package miu.edu.exams.jun23.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
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
    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name ="event_id")
    @JsonManagedReference
    List<Task> tasks = new ArrayList<>();

    @ManyToMany(mappedBy = "eventList", fetch =  FetchType.LAZY)
    @JsonBackReference
    List <Coordinator> coordinatorList;

    public Event(String title,String state, List<Task> tasks){
        this.state = state;
        this.title = title;
        this.tasks = tasks;
    }


}
