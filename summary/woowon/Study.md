# Project 하면서 배워가는 것

# JPA/SpringFramework
##### @NotEmpty
+ null과 ""을 허용하지 않게 하지만 " "은 허용이 된다.
````java
    public class NoticeBoardForm {
    @NotEmpty(message = "이름은 필수입니다.")
    private String name;
    }
````
##### @Column(columnDefinition="")
+ Column의 기본값을 설정한다.
+ @Column(columnDefinition = "크기 default 'default값'")
+ 테이블이 생성될때 정해둔 default 값이 들어가게 된다.
````java
public class NoticeBoard {
  @Column(columnDefinition = "varchar(100) default '관리자'")
    private String name;
}
````
##### @DynamicInsert
+ insert시 null인 값이 sql문에 포함되지 않는다.
+ @DynamicInsert를 사용하면 name에 값을 세팅하지않고 쿼리를 날리면 default로 설정된 값이 들어가게 된다.
````java
@Entity
@Getter @Setter @DynamicInsert
public class NoticeBoard {
    @Column(columnDefinition = "varchar(10) default '이름'")
    private String name;
}
````
# thymeleaf
##### th:href
+ th:href="@{'경로'}" 으로 페이지를 이동시킬수 있다.
+ th:href="@{'경로'+${보낼 값}}" 으로 페이지를 이동시킬때 값을 전달 할 수 있다.
````html
<a th:href="@{'경로'+${보낼 값}}" />
````

# 페이징
+ https://github.com/Leewoowon980522/Jpa_PagingTest/blob/master/sumarry/Paging.md

