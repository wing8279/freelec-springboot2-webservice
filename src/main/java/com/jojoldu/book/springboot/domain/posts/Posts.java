package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//롬복의 어노테이션
@Getter
//기본생성자 자동 추가
//public Post(){}와 같은 효과
@NoArgsConstructor
//JPA의 어노테이션
//테이블과 링크될 클래스임을 나태냅니다.
//기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭합니다.
//SalesManager.java -> sales_manager table
@Entity
public class Posts {
    //ID : 해당 테이블의 PK 필드를 나타냅니다.
    @Id
    //GeneratedValue : PK의 생성 규칙을 나타냅니다.
    //스프링 부트 2.0 에서는 GenerationTypen.IDENTITY 옵션을 추가해야만 auto_increment가 됩니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //테이블 칼럼을 나태내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됩니다.
    //사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용합니다.
    //문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex:tile)
    // 타입을 TEXT로 변경하고 싶거나(ex: content) 등의 경우에 사용됩니다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //해당 클래스의 빌더 패턴 클래스를 생성
    //생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
