package kr.co.mlec.javaboard.board.controller;

import java.text.SimpleDateFormat;

import kr.co.mlec.javaboard.board.dao.BoardDAO;
import kr.co.mlec.javaboard.board.vo.Board;

public class DetailBoardController extends Controllers {
	private BoardDAO boardDAO;
	public DetailBoardController(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
		
	public void service() throws Exception  {
		int no = Integer.parseInt(input("조회할 글번호를 입력하세요 : "));
		Board board = boardDAO.selectBoardByNo(no);
		if (board == null) {
			System.out.println("입력된 번호는 존재하지 않습니다.");
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy.MM.dd HH:mm:ss"
		);
		System.out.println("--------------------------------");
		System.out.println("번호 : " + board.getNo());
		System.out.println("글쓴이 : " + board.getWriter());
		System.out.println("제목 : " + board.getTitle());
		System.out.println("내용 : " + board.getContent());
		System.out.println(
			"작성일 : " + sdf.format(board.getRegDate())
		);
		System.out.println("--------------------------------");
	}
}
