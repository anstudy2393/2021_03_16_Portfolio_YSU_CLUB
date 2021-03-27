package kr.ac.yeonsung.demo.controller;

import kr.ac.yeonsung.demo.domain.Address;
import kr.ac.yeonsung.demo.domain.Member;
import kr.ac.yeonsung.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm"; // members의 createMemberForm.html을 반환
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {

        if (result.hasErrors()) { // BindingResult로 에러를 받아서 member/createMember로 다시 반환
            return "members/createMemberForm";
        }

        Address address = new Address(form.getClassNumber(), form.getDepartment(), form.getLocation());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress((address));

        memberService.join(member);
        return "redirect:/"; // 첫 번째 페이지로 넘어가게함
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList"; // members의 memberList.html를 반환
    }
}
