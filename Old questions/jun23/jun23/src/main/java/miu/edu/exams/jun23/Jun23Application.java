package miu.edu.exams.jun23;


import miu.edu.exams.jun23.entity.Address;
import miu.edu.exams.jun23.entity.Coordinator;
import miu.edu.exams.jun23.entity.Event;
import miu.edu.exams.jun23.entity.Task;
import miu.edu.exams.jun23.service.CoordinatorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Jun23Application {


	public static void main(String[] args) {
		SpringApplication.run(Jun23Application.class, args);
	}
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
	@Bean
	public CommandLineRunner loadData(CoordinatorService coordinatorService) {
		List<Event> eventList = new ArrayList<>();
		List<Coordinator> coordinatorList = new ArrayList<>();
		List<Task> taskList = new ArrayList<>();
		Task task1 = new Task("Prepare room setup");
		Task task2 = new Task("Confirm with participants");
		taskList.add(task1);
		taskList.add(task2);
		Event event1 = new Event("Conference","IA",taskList);
		eventList.add(event1);

		List<Task> taskList2 = new ArrayList<>();
		Task task4 = new Task("Purchase refreshments ");
		Task task6 = new Task("Send invitations");
		taskList2.add(task4);
		taskList2.add(task6);
		Event event2 = new Event("Faculty meeting","IA",taskList2);

		List<Task> taskList3 = new ArrayList<>();
		Task task5 = new Task("Prepare roster");
		taskList3.add (task5);
		Event event3 = new Event("Technical workshop","FL",taskList3);
		List<Event> eventList1 = new ArrayList<>();
		eventList1.add(event2);
		eventList1.add(event3);

		Address address1 = new Address("United States","Orlando","FL","14565");
		Address address2 = new Address("United States","FairField","IA","52557");
		Address address3 = new Address("United States","Orlando","FL","33333");
		Address address4 = new Address("United States","Dallas","TX","11111");
		Coordinator co = new Coordinator("Dean","male",eventList,address3);
		Coordinator co1 = new Coordinator("Yasmeen","female",eventList1,address2);

		return args -> {
			coordinatorService.save1(co);
			coordinatorService.save1(co1);

		};

	}
}
