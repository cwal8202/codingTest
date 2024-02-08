package com.tenco.blog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.blog.dto.BoardDTO;
import com.tenco.blog.repository.entity.BoardEntity;
import com.tenco.blog.repository.interfaces.BoardRepository;

/**
  * @FileName : BoardService.java
  * @Project : springboard-evaluation_test
  * @Date : 2024. 2. 8. 
  * @작성자 : 최장호
  * @변경이력 :
  * @프로그램 설명 : 게시판 서비스
  */
@Service
public class BoardService {
	
	// Repository
	@Autowired
	public BoardRepository boardRepository;
	
	
	/**
	  * @Method Name : insertBoard
	  * @작성일 : 2024. 2. 8.
	  * @작성자 : 최장호
	  * @변경이력 : 
	  * @Method 설명 : Board 테이블에 insert하는 메소드
	  * @param boardEntity
	  * @return
	  */
	@Transactional
	public int insertBoard (BoardDTO saveFormDTO) {
		BoardEntity boardEntity = new BoardEntity().builder()
				.author(saveFormDTO.getAuthor())
				.content(saveFormDTO.getContent())
				.title(saveFormDTO.getTitle())
				.build();
		return boardRepository.insertBoard(boardEntity);
	}
	
	// 게시판 조회
	public BoardEntity findById(Integer id) {
		BoardEntity BoardEntity = boardRepository.findById(id);
		
		return BoardEntity;
	};
	// 게시판 전체 조회
	public List<BoardEntity> findAll() {
		List<BoardEntity> BoardEntityList = boardRepository.findAll();
		return BoardEntityList;
	};
	// 게시판 수정
	@Transactional
	public int updateById(BoardDTO boardDTO) {
		BoardEntity boardEntity = new BoardEntity().builder()
				.id(boardDTO.getId())
				.title(boardDTO.getTitle())
				.content(boardDTO.getContent())
				.author(boardDTO.getAuthor())
				.build();
		return boardRepository.updateById(boardEntity);
	}; 
	// 게시판 삭제
	@Transactional
	public int deleteById(Integer id) {
		return boardRepository.deleteById(id);
	};
	
	
	/**
	  * @Method Name : getPageCount
	  * @작성일 : 2024. 2. 8.
	  * @작성자 : 최장호
	  * @변경이력 : 
	  * @Method 설명 : 전체 게시글을 개수를 가져온다. 
	  * @return
	  */
	public int getBoardCount() {
		return boardRepository.getCount();
	}
	
	
	/**
	  * @Method Name : getPageList
	  * @작성일 : 2024. 2. 8.
	  * @작성자 : 최장호
	  * @변경이력 : 
	  * @Method 설명 : map 매개변수에 입력된 startNo, endNo 값으로 board between을 해주는 메소드
	  * @param map
	  * @return
	  */
	public List<BoardEntity> getPageList(Map<String, Integer> map) {
		return boardRepository.getPageList(map);
	}
}
