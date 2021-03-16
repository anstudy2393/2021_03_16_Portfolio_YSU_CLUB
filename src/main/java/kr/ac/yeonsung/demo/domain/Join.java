package kr.ac.yeonsung.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.transaction.spi.JoinStatus;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "joins")
@Getter @Setter
public class Join {

    @Id @GeneratedValue
    @Column(name = "join_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "join",cascade = CascadeType.ALL)
    private List<JoinClub> joinClubs = new ArrayList<>();

    private LocalDateTime joinDateAt;   // 신청한 날짜

    @Enumerated(EnumType.STRING)
    private JoinStatus status; //신청상태 apply , CANCEL

}
