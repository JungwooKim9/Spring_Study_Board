package com.example.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.board.dto.BoardDTO;
import com.example.board.entity.BoardEntity;
import com.example.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

// DTO -> Entity 변환 (Entity Class에서)
// Entity -> DTO 변환 (DTO Class에서)
@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;

	public void save(BoardDTO boardDTO) {
		BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
		boardRepository.save(boardEntity);
	}

	public List<BoardDTO> findAll() {
		List<BoardEntity> boardEntityList = boardRepository.findAll();
		List<BoardDTO> boardDTOList = new ArrayList<>();
		for (BoardEntity boardEntity : boardEntityList) {
			boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
		}
		return boardDTOList;
	}

	@Transactional	// jpa가 아닌 외부 메소드 사용시 붙임
	public void updateHits(Long id) {
		boardRepository.updateHits(id);
	}

	public BoardDTO findById(Long id) {
		Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
		if (optionalBoardEntity.isPresent()) {
			BoardEntity boardEntity = optionalBoardEntity.get();
			BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
			return boardDTO;
		}else {
			return null;
		}
	}
	
}
