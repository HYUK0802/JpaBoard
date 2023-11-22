package com.hyuk.jpaboardcrud.dto;

import com.hyuk.jpaboardcrud.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

// 게시판 전체 목록 조회시 넘겨줄 Response

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardListResponseDto {

    private String title;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    // Entity -> dto
    public BoardListResponseDto(Board board) {
        this.title = board.getTitle();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }

    public BoardListResponseDto(Optional<Board> board) {
        this.title = board.get().getTitle();
        this.createdAt = board.get().getCreatedAt();
        this.modifiedAt = board.get().getModifiedAt();
    }
}
