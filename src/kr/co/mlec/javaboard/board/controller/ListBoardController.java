package kr.co.mlec.javaboard.board.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import kr.co.mlec.javaboard.board.dao.BoardDAO;
import kr.co.mlec.javaboard.board.vo.Board;

public class ListBoardController extends Controllers {
	private BoardDAO boardDAO;
	public ListBoardController(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	/**
	 *  전체 게시물의 목록을 표시한다.
	 *  목록은 최신글 순으로 표시된다.
	 */
	public void service() throws Exception {
		
		List<Board> list = boardDAO.selectBoard();
		
		System.out.printf("전체 %d개%n", list.size());
		System.out.println("-------------------------------");
		System.out.println("번호 글쓴이 제목  작성일");
		System.out.println("-------------------------------");
		
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy.MM.dd"
		);
		
		for (Board b : list) {
			System.out.printf(
				"%d %s %s %s%n", 
				b.getNo(), b.getWriter(), b.getTitle(), 
				sdf.format(b.getRegDate())
			);
		}
			
		// 게시물이 없는 경우
		if (list.isEmpty()) {
			System.out.println("게시물이 존재하지 않습니다.");
		}
		
		System.out.println("-------------------------------");		
	}
}
