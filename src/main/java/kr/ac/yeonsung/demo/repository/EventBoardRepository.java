package kr.ac.yeonsung.demo.repository;

import kr.ac.yeonsung.demo.domain.EventBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventBoardRepository extends JpaRepository<EventBoard, Long> {
}
