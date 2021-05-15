package kr.ac.yeonsung.demo.service;

import kr.ac.yeonsung.demo.controller.NoticeBoardForm;
import kr.ac.yeonsung.demo.domain.NoticeBoard;
import kr.ac.yeonsung.demo.repository.NoticeBoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import static org.junit.Assert.*;


@SpringBootTest
@Transactional
public class NoticeBoardServiceTest {

    @Autowired
    private NoticeBoardRepository noticeBoardRepository;
    @Autowired
    private NoticeBoardService noticeBoardService;
    @Autowired
    private EntityManager em;

    @Test
    public void 게시글작성_성공() throws Exception{
        NoticeBoardForm noticeBoard = new NoticeBoardForm();
        noticeBoard.setTitle("제목");
        noticeBoard.setContent("내용");

        noticeBoardService.write(noticeBoard);
        em.flush();
        NoticeBoard getNotice = noticeBoardService.findOne(new Long(1));
        assertEquals(noticeBoard.getTitle(),getNotice.getTitle());//값 등록여부확인
        assertEquals(noticeBoard.getContent(),getNotice.getContent());//값 등록여부확인
    }

    @Test
    public void 게시글삭제_성공() throws Exception{
        NoticeBoardForm noticeBoard = new NoticeBoardForm();

        noticeBoard.setTitle("제목2");
        noticeBoard.setContent("내용2");
        noticeBoardService.write(noticeBoard);


        em.flush();

        noticeBoardService.delete(new Long(1));

        NoticeBoard notice = noticeBoardService.findOne(new Long(1));
        assertNull(notice);//Null인지 확인,삭제확인
    }

    @Test
    public void 게시글수정_성공() throws Exception{
        //값 저장
        NoticeBoardForm noticeBoard = new NoticeBoardForm();
        noticeBoard.setTitle("제목");
        noticeBoard.setContent("내용");

        noticeBoardService.write(noticeBoard);
        em.flush();

        //값 변경
        NoticeBoard getNotice = noticeBoardService.findOne(new Long(1));
        NoticeBoardForm noticeForm = new NoticeBoardForm();
        noticeForm.setTitle("변경");
        noticeForm.setContent("변경2");

        noticeBoardService.update(getNotice.getId(),noticeForm);

        //변경된 값 가져오기
        NoticeBoard changeNotice = noticeBoardService.findOne(getNotice.getId());

        //값 변경 확인
        assertEquals(changeNotice.getTitle(),"변경");
        assertEquals(changeNotice.getContent(),"변경2");
    }
}