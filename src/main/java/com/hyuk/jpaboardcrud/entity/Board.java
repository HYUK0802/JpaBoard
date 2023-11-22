package com.hyuk.jpaboardcrud.entity;

import com.hyuk.jpaboardcrud.dto.BoardRequestDto;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter // get 함수를 일괄적으로 만들어줌
@Setter // set 함수를 일괄적으로 만들어줌
@NoArgsConstructor // 기본 생성자를 만들어 줍니다.
@Entity(name = "users") // DB 테이블 역활을 합니다// .
public class Board extends Timestamped{

    // 글 고유 아이디
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 글제목
    @Column(nullable = false)
    private String title;

    // 글내용
    @Column(nullable = false)
    private String content;

    // 비밀번호
    @Column(nullable = false)
    private String password;



    // requestDto 정보를 가져와서 entity 만들 때 사용
    public Board(BoardRequestDto requestDto) {

        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }

    // 업데이트 메소드
    public void update(BoardRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }
}
