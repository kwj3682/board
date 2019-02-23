package kr.co.mlec.javaboard.board;

import kr.co.mlec.javaboard.board.controller.BoardController;

public class Test {
	public static void main(String[] args) {
		// 게시판 기능을 수행하는 BoardController 클래스 활용
		BoardController ctrl = new BoardController();
		ctrl.service();
		
//		new BoardController().service();
	}
}











