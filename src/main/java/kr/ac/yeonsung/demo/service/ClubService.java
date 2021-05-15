package kr.ac.yeonsung.demo.service;

import kr.ac.yeonsung.demo.domain.NoticeBoard;
import kr.ac.yeonsung.demo.domain.club.Book;
import kr.ac.yeonsung.demo.domain.club.Club;
import kr.ac.yeonsung.demo.repository.ClubRepository;
import kr.ac.yeonsung.demo.repository.JoinClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClubService {
    private  final ClubRepository clubRepository;
    private final JoinClubRepository joinClubRepository;

    @Transactional
    public void saveClub(Club club){
        clubRepository.save(club);
    }

    public List<Club> findClub(){
        return  clubRepository.findAll();
    }

    public Club findOne(Long clubId){
        return clubRepository.findById(clubId).orElse(null);
    }
    @Transactional
    public void deleteClub(Long clubId){
        Club club1 = clubRepository.findById(clubId).orElse(null);
        clubRepository.delete(club1);
    }

    public Page<Club> findAll(Pageable pageable){
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
        pageable = PageRequest.of(page, 10, Sort.Direction.DESC,"id");
        return clubRepository.findAll(pageable);
    }

    @Transactional
    public void updateClub(Long clubId, String name, int totalNumber, String author, String isbn) {
        Book book = (Book)findOne(clubId);
        book.setName(name);
        book.setTotalNumber(totalNumber);
        book.setAuthor(author);
        book.setIsbn(isbn);
    }
}
