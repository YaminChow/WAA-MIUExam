package miu.edu.exams.jun23.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long co_id;
    private String name;
    private String gender;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    //@BatchSize(size = 2)
    @JoinTable(name="Coordinators_Events",
            joinColumns = {@JoinColumn(name = "co_id")},
            inverseJoinColumns = {@JoinColumn(name="event_id")})
    @JsonManagedReference
    private List<Event> eventList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="address_id")
    @JsonManagedReference
    private Address address;

    public Coordinator(String name, String gender, List<Event> eventList,Address address){
        this.name = name;
        this.gender = gender;
        this.eventList = eventList;
        this.address = address;

    }

}
