package kr.ac.yeonsung.demo.repository;

import kr.ac.yeonsung.demo.domain.NoticeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeBoardRepository extends JpaRepository<NoticeBoard,Long> {

}
