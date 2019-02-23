package kr.co.mlec.javaboard.board.controller;

import kr.co.mlec.javaboard.board.dao.BoardDAO;
import kr.co.mlec.javaboard.board.vo.Board;

public class WriteBoardController extends Controllers {
	private BoardDAO boardDAO;
	public WriteBoardController(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
		
	public void service() throws Exception  {
		Board b = new Board();
		b.setTitle(input("제목을 입력하세요 : "));
		b.setWriter(input("글쓴이를 입력하세요 : "));
		b.setContent(input("내용을 입력하세요 : "));
		if (b.getTitle().equals("") || b.getWriter().equals("")
				|| b.getContent().equals("")) {
			System.out.println("게시물의 내용을 입력하세요");
			
			return;
		}
		
		boardDAO.insertBoard(b);
		System.out.println("게시글이 등록되었습니다.");
	}
}
