package miu.edu.exams.jun23.repo;

import miu.edu.exams.jun23.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event,Long> {
}
