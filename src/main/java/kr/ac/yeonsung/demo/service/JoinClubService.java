package kr.ac.yeonsung.demo.service;

import kr.ac.yeonsung.demo.domain.Join;
import kr.ac.yeonsung.demo.domain.JoinClub;
import kr.ac.yeonsung.demo.domain.JoinStatus;
import kr.ac.yeonsung.demo.domain.Member;
import kr.ac.yeonsung.demo.domain.club.Club;
import kr.ac.yeonsung.demo.repository.ClubRepository;
import kr.ac.yeonsung.demo.repository.JoinClubRepository;
import kr.ac.yeonsung.demo.repository.JoinRepository;
import kr.ac.yeonsung.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class JoinClubService {

    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private JoinRepository joinRepository;
    @Autowired
    private JoinClubRepository joinClubRepository;

    @Transactional
    public JoinClub findOne(Long clubId){  return joinClubRepository.findOne(clubId);}
    public void deleteOne(JoinClub joinClub){ joinClubRepository.deleteOne(joinClub);}

    @Transactional
    public void chageStatus(Club club){
        Long clubid = club.getId();
        log.info("갑이야갑ㄱ박박바갑갑가박ㅂ가"+clubid);
        JoinClub joinClub = joinClubRepository.findOne(clubid);
        log.info("나와라요~~~"+ joinClub);
        Join joinClubJoin = joinClub.getJoin();
        Member member = joinClubJoin.getMember();
        member.setStatus(JoinStatus.cancel);
    }
}
