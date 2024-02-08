package com.tenco.blog.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tenco.blog.dto.BoardDTO;
import com.tenco.blog.dto.PageDTO;
import com.tenco.blog.handler.exception.CustomException;
import com.tenco.blog.handler.exception.ValidException;
import com.tenco.blog.repository.entity.BoardEntity;
import com.tenco.blog.service.BoardService;

@Controller
public class BoardController {
	// Service
	@Autowired
	public BoardService boardService;

	// Repository

//	@GetMapping("/")
//	public String index(Model model) {
//		List<BoardEntity> boardList = boardService.findAll();
//
//		if (boardList.isEmpty()) {
//			model.addAttribute("boardList", null);
//		} else {
//			model.addAttribute("boardList", boardList);
//		}
//		return "index";
//	}

	// 글쓰기 화면 보여주는 메소드
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}

	// 게시판 글 수정 화면 보여주는 메소드
	@GetMapping("/board/{id}/updateForm")
	public String update(@PathVariable("id") int id, Model model) {
		BoardEntity reBoard = boardService.findById(id);
		model.addAttribute("reBoard", reBoard);
		return "board/updateForm";
	}

	/**
	 * @Method Name : save
	 * @작성일 : 2024. 2. 8.
	 * @작성자 : 최장호
	 * @변경이력 :
	 * @Method 설명 : 글쓰기 완료 시 제목, 내용의 validation 처리 및 db 저장하는 메소드
	 * @param saveFormDTO
	 * @return
	 */
	// 저장
	@PostMapping("/board/save")
	public String save(BoardDTO saveFormDTO) {
		// dto값 null 체크
		if (saveFormDTO.getAuthor() == null || saveFormDTO.getAuthor().isEmpty()) {
			throw new CustomException("작성자가 입력되지 않았습니다.", HttpStatus.BAD_REQUEST);
		}
		if (saveFormDTO.getContent() == null || saveFormDTO.getAuthor().isEmpty()) {
			throw new CustomException("내용이 입력되지 않았습니다.", HttpStatus.BAD_REQUEST);
		}
		if (saveFormDTO.getTitle() == null || saveFormDTO.getAuthor().isEmpty()) {
			throw new CustomException("제목이 입력되지 않았습니다.", HttpStatus.BAD_REQUEST);
		}

		// 제목, 내용 <= 20자
		if (saveFormDTO.getContent().length() > 20) {
			throw new ValidException("내용은 20자를 넘을수 없습니다.", HttpStatus.BAD_REQUEST);
		}
		if (saveFormDTO.getTitle().length() > 20) {
			throw new ValidException("제목은 20자를 넘을수 없습니다.", HttpStatus.BAD_REQUEST);
		}

		// Board db에 저장
		int result = boardService.insertBoard(saveFormDTO);
		if (result != 1) {
			throw new ValidException("정상처리 되지 않았습니다.", HttpStatus.BAD_REQUEST);
		}

		return "redirect:/";
	}

	// 수정
	@PostMapping("/board/{id}/update")
	public String update(@PathVariable("id") int id, BoardDTO boardDTO) {
		int result = boardService.updateById(boardDTO);
		return "redirect:/";
	}

	// 삭제
	@PostMapping("/board/{id}/delete")
	public String delete(@PathVariable("id") int id) {
		int result = boardService.deleteById(id);
		if (result != 1) {
			throw new ValidException("정상처리 되지 않았습니다.", HttpStatus.BAD_REQUEST);
		}
		return "redirect:/";
	}

	// 페이징 처리
	@GetMapping("/")
	public String list(@RequestParam(required = false, value="pageNo" ,defaultValue = "1") int pageNo, Model model) {
		int boardCount = boardService.getBoardCount();
		PageDTO page = new PageDTO(pageNo, 5, boardCount);
		
		Map<String, Integer> map = new HashMap<>();
		map.put("startNo", page.getStartNo());
		map.put("endNo", page.getEndNo());
		List<BoardEntity> list = boardService.getPageList(map);

		model.addAttribute("page", page);
		model.addAttribute("list", list);

		return "index";
	}
}
