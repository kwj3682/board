package kr.co.mlec.javaboard.board.controller;

import kr.co.mlec.javaboard.board.dao.BoardDAO;
import kr.co.mlec.javaboard.board.vo.Board;

public class UpdateBoardController extends Controllers {
	private BoardDAO boardDAO;
	public UpdateBoardController(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
		
	public void service() throws Exception {
		int no = Integer.parseInt(input("수정할 글번호를 입력하세요 : "));
		// 해당 게시물 번호가 있는지 체크한다.
		Board board = boardDAO.selectBoardByNo(no);
		if (board == null) {
			System.out.println("입력된 번호는 존재하지 않습니다.");
			return;
		}
		
		// 만약, 존재하면 사용자에게 수정할 내용을 입력받는다.
		Board param = new Board();
		param.setNo(no);
		param.setTitle(input("제목을 입력하세요 : "));
		param.setContent(input("내용을 입력하세요 : "));

		// DAO에게 사용자에게 입력받은 내용을 넘겨서 처리를 부탁한다.
		boardDAO.updateBoard(param);
		
		System.out.println();
		System.out.println("게시물이 수정되었습니다.");
	}
}
