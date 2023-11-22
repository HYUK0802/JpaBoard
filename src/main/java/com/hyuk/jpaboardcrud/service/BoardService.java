package com.hyuk.jpaboardcrud.service;

import com.hyuk.jpaboardcrud.dto.BoardListResponseDto;
import com.hyuk.jpaboardcrud.dto.BoardRequestDto;
import com.hyuk.jpaboardcrud.dto.BoardResponseDto;
import com.hyuk.jpaboardcrud.entity.Board;
import com.hyuk.jpaboardcrud.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    // 글생성
    public BoardResponseDto createBoard(BoardRequestDto requestDto) { // requestDto를 매개변수로 받기
        Board board = new Board(requestDto); //받은 매개변수를 이용해 새 Board 객체를 생성함
        boardRepository.save(board); // repository에 생성한 객체 저장함(save)
        return new BoardResponseDto(board); // 만든 board객체를 이용해서, responseDto객체도 새로 생성해서 리턴해줌
    }
    // 모든 글 가져오기
    public List<BoardListResponseDto> findAllBoard() { //ResponseDto의 list로 리턴타입 지정

        try {
            List<Board> boardList = boardRepository.findAll(); // repository에서 findAll로 찾은 것을 리스트에 넣기
            List<BoardListResponseDto> responseDtoList = new ArrayList<>(); //값을 담을 새 배열 만들기 (responseDto이용)
            // for ( 타입 인덱스 : 가져올 리스트 ) { 실행할 내용 }
            for (Board board : boardList) { //foreach문으로 board의 값 하나씩 ResponsDto를 이용해 새 객체 만들기
                responseDtoList.add(
                        new BoardListResponseDto(board)
                );
            }
            return responseDtoList;
        } catch (Exception e) {

        }
        return null;
    }

    // 글 하나 가져오기
    public BoardResponseDto findOneBoard(Long id) { //responseDto로 리턴타입 설정
        //매개변수로 id값 받기
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("조회 실패")
        ); //repository에서 id를 기준으로 찾고, elseThrow로 예외처리
        return new BoardResponseDto(board); //찾은 값을 이용해 새로운 responseDto 객체로 리턴
    }

    // 글 수정
    @Transactional
    public Long update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    };

    // 삭제
    @Transactional
    public Long delete(Long id) {
        boardRepository.deleteById(id);
        return id;
    }
}
