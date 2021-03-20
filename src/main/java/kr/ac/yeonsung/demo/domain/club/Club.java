package kr.ac.yeonsung.demo.domain.club;

import kr.ac.yeonsung.demo.domain.CategoryClub;
import kr.ac.yeonsung.demo.domain.JoinClub;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Club {

    @Id
    @GeneratedValue
    @Column(name="club_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "club" ,cascade = CascadeType.ALL)
    private List<CategoryClub> categoryClubs = new ArrayList<>();

}
