package miu.edu.exams.jun23.service.impl;

import jakarta.transaction.Transactional;
import miu.edu.exams.jun23.entity.Address;
import miu.edu.exams.jun23.entity.Coordinator;
import miu.edu.exams.jun23.entity.Event;
import miu.edu.exams.jun23.entity.dto.input.CoordinatorDTO;
import miu.edu.exams.jun23.entity.Task;
import miu.edu.exams.jun23.entity.dto.ResEventDto;
import miu.edu.exams.jun23.entity.dto.input.EventDto;
import miu.edu.exams.jun23.help.ListMapper;
import miu.edu.exams.jun23.repo.AddressRepo;
import miu.edu.exams.jun23.repo.CoordinatorRepo;
import miu.edu.exams.jun23.service.CoordinatorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CoordinatorServiceImpl implements CoordinatorService {
    @Autowired
    CoordinatorRepo coordinatorRepo;
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;

    @Override
    public List<Coordinator> findAll() {
        return coordinatorRepo.findAll();
    }

    @Override
    public Coordinator findById(Long id) {
        return coordinatorRepo.findById(id).get();
    }
    @Transactional
    @Override
    public Coordinator save(CoordinatorDTO co) {
        Address savedAddress = addressRepo.save (modelMapper.map( co.getAddress(),Address.class));
       // List<Event> eventList = listMapper.mapList(co.getEventList(),new Event());
        Coordinator orgCor= modelMapper.map( co,Coordinator.class);
        orgCor.setAddress(savedAddress);
//        System.out.println("<<Before for loop>>");
//        List<Event> reqEventList = new ArrayList<>();
//
//        for(Event e: eventList){
//            System.out.println("reEventsize:"+ reqEventList.size());
//            Task t = new Task();
//            //Task t = modelMapper.map(e.getTasks(),Task.class);
//            t.setEvent(e);
//            //e.getTasks().add(t);
//            reqEventList.add(e);
//            System.out.println("<<out inner loop>>"+ e.getTasks().size());
//
//        }
//        System.out.println("<<After for loop>>");
//
//        orgCor.setEventList(reqEventList);
//        System.out.println("coor's event size"+orgCor.getEventList().size());
        // Save the Coordinator
        return coordinatorRepo.save(orgCor);


    }

    @Override
    @Transactional
    public Coordinator save1(Coordinator co) {
        Address savedAddress = addressRepo.save(co.getAddress());

        co.setAddress(savedAddress);
        Coordinator c= coordinatorRepo.save(co);

        Task task = new Task();
        Event event = new Event();
        event.getTasks().add(task);
        task.setEvent(event);

        // Save the Coordinator
        return c;


    }
    @Transactional
    @Override
    public void update(CoordinatorDTO co) {
        if(coordinatorRepo.findById(co.getCo_id()).isPresent())
        {
            Coordinator orgCor= modelMapper.map( co,Coordinator.class);
            coordinatorRepo.save(orgCor);
        }

    }

    @Override
    public void delete(Long id) {
        if(coordinatorRepo.findById(id).isPresent()){
            coordinatorRepo.deleteById(id);
        }
    }

    @Override
    public List<ResEventDto> getEventByCoordinatorId(Long coId) {
        return (List<ResEventDto>) listMapper.mapList(coordinatorRepo.getEventByCoordinatorId(coId).stream().collect(Collectors.toList()), new ResEventDto());
    }

    @Override
    public List<Task> getTaskByCoordinatorId(Long coId) {
        coordinatorRepo.getTasksByCoordinatorId(coId).stream().forEach(System.out::println);
        return coordinatorRepo.getTasksByCoordinatorId(coId);
        //return (List<ResTaskDto>) listMapper.mapList(coordinatorRepo.getTasksByCoordinatorId(coId),new ResTaskDto());
    }

    @Override
    public List<Coordinator> getCoordinatorOutOfState() {
        return coordinatorRepo.getCoordinatorByOutOfState();
    }

    @Override
    public List<Coordinator> getCoordinatorByNameContainingAndGender(String name, String gender){
        return coordinatorRepo.findCoordinatorByNameContainingAndGender(name,gender);
    }


}
