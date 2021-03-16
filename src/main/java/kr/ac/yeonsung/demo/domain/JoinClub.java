package kr.ac.yeonsung.demo.domain;

import kr.ac.yeonsung.demo.domain.club.Club;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class JoinClub {

    @Id
    @GeneratedValue
    @Column(name = "join_club_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "join_id")
    private Join join;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    private int totalNumber;    // 총인원

    private int currentNumber;  // 현재인원

}
