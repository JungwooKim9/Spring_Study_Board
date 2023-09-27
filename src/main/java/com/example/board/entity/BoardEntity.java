package com.example.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.board.dto.BoardDTO;

import lombok.Getter;
import lombok.Setter;

// Entity: DB의 테이블 역할을 하는 클래스 (Service, Repository에서만 사용)

@Entity
@Getter
@Setter
@Table(name = "board_table")
public class BoardEntity extends BaseEntity {
	@Id	// pk 컬럼 지정. 필수
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// auto_increment
	private Long id;

	@Column(length = 20, nullable = false)	// 크기 20, not null
	private String boardWriter;

	@Column	// 크기 255, null 가능
	private String boardPass;

	@Column
	private String boardTitle;

	@Column(length = 500)
	private String boardContents;

	@Column
	private int boardHits;

	public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
		BoardEntity boardEntity = new BoardEntity();
		boardEntity.setBoardWriter(boardDTO.getBoardWriter());
		boardEntity.setBoardPass(boardDTO.getBoardPass());
		boardEntity.setBoardTitle(boardDTO.getBoardTitle());
		boardEntity.setBoardContents(boardDTO.getBoardContents());
		boardEntity.setBoardHits(0);
		return boardEntity;
	}

	public static BoardEntity toUpdateEntity(BoardDTO boardDTO) {
		BoardEntity boardEntity = new BoardEntity();
		boardEntity.setId(boardDTO.getId());
		boardEntity.setBoardWriter(boardDTO.getBoardWriter());
		boardEntity.setBoardPass(boardDTO.getBoardPass());
		boardEntity.setBoardTitle(boardDTO.getBoardTitle());
		boardEntity.setBoardContents(boardDTO.getBoardContents());
		boardEntity.setBoardHits(boardDTO.getBoardHits());
		return boardEntity;
	}
}

