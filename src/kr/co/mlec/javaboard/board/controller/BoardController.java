package kr.co.mlec.javaboard.board.controller;

import java.util.Scanner;

import kr.co.mlec.javaboard.board.dao.BoardDAO;

/**
 * 게시판의 기능을 처리하는 진입 클래스
 * 
 * @author 지나가는이
 */
public class BoardController {
	
	private BoardDAO boardDAO;
	
	public Scanner sc = new Scanner(System.in);  // 사용자 입력..

	public BoardController() {
		boardDAO = new BoardDAO();
	}
	
	/**
	 * 게시판 시스템을 종료 
	 */
	private void exit() {
		System.out.println("공부게시판 시스템을 종료합니다.");
		// 프로세스 중단.
		System.exit(0);
	}
	
	private int choiceMenu() {
		System.out.println("-----------------");
		System.out.println("1. 전체 게시물 조회");
		System.out.println("2. 글번호 조회");
		System.out.println("3. 글등록");
		System.out.println("4. 글수정");
		System.out.println("5. 글삭제");
		System.out.println("0. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public void service() {
		try {
			System.out.println("공부게시판");
			System.out.println("-----------------");
			while (true) {
				Controller ctrl = null;
				switch (choiceMenu()) {
				case 1:  // 전체 게시물 조회
					ctrl = new ListBoardController(boardDAO);
					break;
				case 2:  // 상세조회
					ctrl = new DetailBoardController(boardDAO);
					break;
				case 3:  // 등록
					ctrl = new WriteBoardController(boardDAO);
					break;
				case 4:  // 글수정
					ctrl = new UpdateBoardController(boardDAO);
					break;
				case 5:  // 삭제
					ctrl = new DeleteBoardController(boardDAO);
					break;
				case 0:
					exit();
				default:
					System.out.println("잘못된 메뉴번호 입니다.");
					System.out.println("다시 선택해 주세요.");
				}
				
				if (ctrl != null) {
					ctrl.service();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










