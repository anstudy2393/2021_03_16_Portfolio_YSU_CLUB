package kr.ac.yeonsung.demo.controller;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;


@Getter @Setter
public class NoticeBoardForm {

    private Long id;

    @NotEmpty(message = "게시글 제목은 필수입니다.") // 값이 비어있으면 메세지와 오류를 띄움
    private String title;//제목

    @NotEmpty(message = "게시글 내용은 필수입니다.")
    private String content;//내용

    private String writeDate;//작성날짜
    private String updateDate;//수정날짜
}
