package miu.edu.exams.jun23.entity.dto.input;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
public class EventDto {

    private String title;
    private String state;

    List<TaskDto> tasks;
    List <CoordinatorDTO> coordinatorList;


}
