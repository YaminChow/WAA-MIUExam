package miu.edu.exams.jun23.entity.dto.input;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class AddressDto {

    private Long address_id;
    private String country;
    private String city;
    private String state;
    private String zipcode;
    private CoordinatorDTO coordinator;




}
