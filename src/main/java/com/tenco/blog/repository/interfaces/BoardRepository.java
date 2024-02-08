package com.tenco.blog.repository.interfaces;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.blog.repository.entity.BoardEntity;

/**
  * @FileName : BoardRepository.java
  * @Project : springboard-evaluation_test
  * @Date : 2024. 2. 8. 
  * @작성자 : 최장호
  * @변경이력 :
  * @프로그램 설명 : 게시판의 조회, 저장, 수정, 삭제 인터페이스 입니다.
  */
@Mapper
public interface BoardRepository {
	// 게시판 등록
	public int insertBoard(BoardEntity boardEntity);
	// 게시판 조회
	public BoardEntity findById(Integer id);
	// 게시판 전체 조회
	public List<BoardEntity> findAll();
	// 게시판 수정
	public int updateById(BoardEntity boardEntity); 
	// 게시판 삭제
	public int deleteById(Integer id);
	
	// 페이징 처리 위한 조회
	public List<BoardEntity> getPageList(Map<String, Integer> map);
	// 게시글 전체 카운트
	public int getCount();
}
