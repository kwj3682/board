/**
 *   DAO : Data Access Object
 *   
 *   데이터에 대한 처리 클래스
 *   
 *   일반적으로 4가지 일 처리를 진행함..
 *   
 *   조회 : select~
 *   등록 : insert~
 *   수정 : update~
 *   삭제 : delete~
 */
package kr.co.mlec.javaboard.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.javaboard.board.vo.Board;

public class BoardDAO {
	
	private final SqlSession session = MyAppSqlConfig.getSqlSession();
	private final static String NS = 
			"kr.co.mlec.javaboard.board.dao.BoardDAO.";
	
	/**
	 * 전체 게시글 조회
	 */
	public List<Board> selectBoard() throws Exception {
		return session.selectList(NS + "selectBoard");
	}
	
	/**
	 * 글번호 조회
	 * 
	 * Board - null 이 넘어가는 경우 : 
	 *         사용자가 요청한 번호에 해당하는 게시물이 없는 경우
	 */
	public Board selectBoardByNo(int no) throws Exception {
		return session.selectOne(NS + "selectBoardByNo", no);
	}
	
	/**
	 * 글등록
	 */
	public void insertBoard(Board board) throws Exception {
		session.insert(NS + "insertBoard", board);
	}

	/**
	 * 글수정
	 */
	public void updateBoard(Board board) throws Exception {
		session.update(NS + "updateBoard", board);
	}
	
	/**
	 * 글삭제
	 */
	public void deleteBoard(int no) throws Exception {
		session.delete(NS + "deleteBoard", no);
	}
	
}











