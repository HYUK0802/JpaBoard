package com.hyuk.jpaboardcrud.repository;

import com.hyuk.jpaboardcrud.dto.BoardListResponseDto;
import com.hyuk.jpaboardcrud.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
// JpaRepository 상속받고, 사용할 entity는 Board로, 타입은 Long으로
public interface BoardRepository extends JpaRepository<Board, Long> {
    //BoardListResponseDto가 쓸 시간 내림차순 정렬 기능 추가 (List< BoardListResponseDto > findAllByOrderByModifiedAtDesc();)
    List<BoardListResponseDto> findAllByOrderByModifiedAtDesc();
}
