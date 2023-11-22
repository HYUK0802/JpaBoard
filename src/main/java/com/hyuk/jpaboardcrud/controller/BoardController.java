package com.hyuk.jpaboardcrud.controller;

import com.hyuk.jpaboardcrud.dto.BoardListResponseDto;
import com.hyuk.jpaboardcrud.dto.BoardRequestDto;
import com.hyuk.jpaboardcrud.dto.BoardResponseDto;
import com.hyuk.jpaboardcrud.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 글 등록
    @PostMapping("/boards")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        BoardResponseDto board = boardService.createBoard(requestDto);
        return board;
    }

    // 전체 목록 조회
    @GetMapping("/boards")
    public List<BoardListResponseDto> getAllBoards() {
        return boardService.findAllBoard();
    }

    // 글 하나 조회
    @GetMapping("/boards/{id}")
    public BoardResponseDto getOneBoard(@PathVariable Long id) {
        return boardService.findOneBoard(id);
    }

    // 글수정
    @PutMapping("/boards/{id}")
    public Long updateBoard(@PathVariable Long id,
                            @RequestBody BoardRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

    // 글 삭제
    @DeleteMapping("/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        return boardService.delete(id);
    }

//    // 비밀번호 확인
//    @GetMapping("/boards/check/{id}/{inputPassword}")
//    public boolean checkPassword(@PathVariable Long id,@PathVariable String inputPassword) {
//        return boardService.checkPassword(id, inputPassword);
//    }
}
