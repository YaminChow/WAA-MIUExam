package miu.edu.exams.jun23.service;

import miu.edu.exams.jun23.entity.Coordinator;
import miu.edu.exams.jun23.entity.Task;
import miu.edu.exams.jun23.entity.dto.ResEventDto;
import miu.edu.exams.jun23.entity.dto.input.CoordinatorDTO;

import java.util.List;

public interface CoordinatorService {
    List<Coordinator> findAll();

    Coordinator findById(Long id);

    Coordinator save(CoordinatorDTO co);
    Coordinator save1(Coordinator co);

    void update(CoordinatorDTO co);

    void delete(Long id);

    List<ResEventDto>  getEventByCoordinatorId(Long coId);

    List<Task> getTaskByCoordinatorId(Long coId);

    List<Coordinator> getCoordinatorOutOfState();

    List<Coordinator> getCoordinatorByNameContainingAndGender(String name, String gender);
}
