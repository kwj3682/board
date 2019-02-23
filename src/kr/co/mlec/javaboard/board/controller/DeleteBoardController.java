package kr.co.mlec.javaboard.board.controller;

import kr.co.mlec.javaboard.board.dao.BoardDAO;
import kr.co.mlec.javaboard.board.vo.Board;

public class DeleteBoardController extends Controllers {
	private BoardDAO boardDAO;
	public DeleteBoardController(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
		
	public void service() throws Exception {
		int no = Integer.parseInt(input("삭제할 글번호를 입력하세요 : "));
		// 해당 게시물 번호가 있는지 체크한다.
		Board board = boardDAO.selectBoardByNo(no);
		if (board == null) {
			System.out.println("입력된 번호는 존재하지 않습니다.");
			return;
		}
		boardDAO.deleteBoard(no);
		System.out.println("게시물이 삭제되었습니다.");
	}
}
