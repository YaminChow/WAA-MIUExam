package miu.edu.exams.jun23.controller;

import miu.edu.exams.jun23.aspect.annotation.Confirm;
import miu.edu.exams.jun23.entity.Coordinator;
import miu.edu.exams.jun23.entity.Task;
import miu.edu.exams.jun23.entity.dto.ResEventDto;
import miu.edu.exams.jun23.entity.dto.input.CoordinatorDTO;
import miu.edu.exams.jun23.repo.CoordinatorRepo;
import miu.edu.exams.jun23.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CoordinatorController {
    @Autowired
    CoordinatorService coordinatorService;
    @Autowired
    CoordinatorRepo coordinatorRepo;

    @GetMapping
    public List<Coordinator> findAll(){
        return coordinatorService.findAll();
    }
    @Confirm
    @GetMapping("/{id}")
    public Coordinator findById(@PathVariable Long id){
        return coordinatorService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody CoordinatorDTO co){
        System.out.println("<<<save>>>>");
        coordinatorService.save(co);
    }
    
    @Confirm
    @PutMapping
    public void update(@RequestBody CoordinatorDTO co){
        System.out.println("<<<update>>>>");

        coordinatorService.update(co);
    }

    @Confirm
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        coordinatorService.delete(id);
    }

    @GetMapping("/coordinator/{co_id}/events")
    public List<ResEventDto>  getEventByCoordinatorId(@PathVariable Long co_id){
        return coordinatorService.getEventByCoordinatorId(co_id);
    }

    @GetMapping("/coordinator/{co_id}/tasks")
    public List<Task>  getTaskByCoordinatorId(@PathVariable Long co_id){
        //return coordinatorRepo.getTasksByCoordinatorId(co_id);
        return coordinatorService.getTaskByCoordinatorId(co_id);
    }

    @GetMapping("/coordinatoroutofstate")
    public List<Coordinator>  getCoordinatorOutOfState(){
        //return coordinatorRepo.getTasksByCoordinatorId(co_id);
        return coordinatorService.getCoordinatorOutOfState();
    }

    @GetMapping("/coordinator/filter")
    public List<Coordinator>  getCoordinatorByNameContainingAndGender(
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "name",required = false) String name)
    {
        if (gender != null && name != null){
            return coordinatorRepo.findCoordinatorByNameContainingAndGender(name, gender);
        }
        if(gender != null){
            return coordinatorRepo.findCoordinatorByGender(gender);
        }

        //return coordinatorRepo.getTasksByCoordinatorId(co_id);
        return coordinatorService.getCoordinatorByNameContainingAndGender(name, gender);
    }
}
