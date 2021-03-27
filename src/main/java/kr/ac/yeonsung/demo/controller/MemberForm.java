package kr.ac.yeonsung.demo.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다.") // 값이 비어있으면 메세지와 오류를 띄움
    private String name;

    private String classNumber;
    private String department;
    private String location;
}