package miu.edu.exams.jun23.repo;

import miu.edu.exams.jun23.entity.Coordinator;
import miu.edu.exams.jun23.entity.Event;
import miu.edu.exams.jun23.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoordinatorRepo extends JpaRepository<Coordinator,Long> {
    @Query(value ="Select c From Coordinator c join fetch c.eventList e join fetch c.address join e.tasks where c.co_id = :id")
    Optional<Coordinator> findById(Long id);

    @Query(value ="Select c.eventList From Coordinator c join c.eventList e where c.co_id = :coId")
    List<Event> getEventByCoordinatorId(Long coId);
    @Query(value ="Select t From Coordinator c join c.eventList e join e.tasks t where c.co_id = :coId")
    List<Task> getTasksByCoordinatorId(Long coId);

    @Query (value ="select c from Coordinator c join c.eventList e join c.address a where e.state <> a.state")
    List<Coordinator> getCoordinatorByOutOfState();

    List<Coordinator> findCoordinatorByNameContainingAndGender(String name, String gender);
    List<Coordinator> findCoordinatorByGender(String gender);

    List<Coordinator> findCoordinatorByNameContaining(String name);

    @Query(value = "select c.eventList from Coordinator c join c.eventList e where e.title like %:title% and e.state = :state ")
    List<Event> getEventByTitleAndState(@Param("title") String title, @Param("state") String state);
}

