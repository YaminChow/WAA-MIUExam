package miu.edu.exams.jun23.entity.dto.input;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.List;

@Data
public class CoordinatorDTO {

    private Long co_id;
    private String name;
    private String gender;
    private List<EventDto> eventList;
    private AddressDto address;

}
