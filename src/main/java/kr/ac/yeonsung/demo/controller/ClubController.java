package kr.ac.yeonsung.demo.controller;


import kr.ac.yeonsung.demo.domain.EventBoard;
import kr.ac.yeonsung.demo.domain.NoticeBoard;
import kr.ac.yeonsung.demo.domain.club.Book;
import kr.ac.yeonsung.demo.domain.club.Club;
import kr.ac.yeonsung.demo.service.ClubService;
import kr.ac.yeonsung.demo.service.JoinClubService;
import kr.ac.yeonsung.demo.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClubController {
    private final ClubService clubService;
    private final JoinClubService joinClubService;


    @GetMapping("/clubs/new")
    public String createForm(Model model) {
        model.addAttribute("form", new BookForm());
        return "clubs/createClubForm";
    }

    @PostMapping("/clubs/new")
    public String create(BookForm form) {
        Book book = new Book();
        book.setName(form.getName());
        book.setTotalNumber(form.getTotalNumber());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        clubService.saveClub(book);

        return "redirect:/clubs";
    }

    // 페이징
    @GetMapping("/clubs")
    public String list(@PageableDefault Pageable pageable, Model model){
        Page<Club> clubList = clubService.findAll(pageable);
        model.addAttribute("clubList", clubList);

        List<Club> getClubList = clubList.getContent();
        model.addAttribute("getClubList",getClubList);//list size가져옴, list size확인용
        return "/clubs/clubList";
    }

    @PostMapping("clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long clubId){
        Club club = clubService.findOne(clubId);
        joinClubService.chageStatus(club);
        clubService.deleteClub(clubId);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}/change")
    public String changeForm(Model model,@PathVariable("clubId") Long clubId){
        Club club = clubService.findOne(clubId);
        model.addAttribute("form",club);
        return "clubs/clubInfoChange";
    }

    @PostMapping("/clubs/{clubId}/change")
    public String change(BookForm form,@PathVariable("clubId") Long clubId){
        clubService.updateClub(clubId,form.getName(),form.getTotalNumber(),
                form.getAuthor(),form.getIsbn());
        return "redirect:/clubs";
    }


}
