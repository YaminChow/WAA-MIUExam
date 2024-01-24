package miu.edu.exams.jun23.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.exams.jun23.entity.dto.input.CoordinatorDTO;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;
    private String country;
    private String city;
    private String state;
    private String zipcode;
    @OneToOne(mappedBy = "address", fetch = FetchType.EAGER)
    @JsonBackReference
    private Coordinator coordinator;

    public Address(String country, String city, String state,String zipcode){
        this.country = country;
        this.city = city;
        this.zipcode =zipcode;
        this.state = state;
    }
}
