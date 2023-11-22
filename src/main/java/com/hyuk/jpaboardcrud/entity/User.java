package com.hyuk.jpaboardcrud.entity;

import com.hyuk.jpaboardcrud.dto.UserRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "`user`")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 50, unique = true)
    private String username;

    @Column(length = 100)
    private String password;

    public User(UserRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
    }

}
