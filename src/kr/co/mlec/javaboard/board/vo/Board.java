// vo : ValueObject
package kr.co.mlec.javaboard.board.vo;

import java.util.Date;

public class Board {
	// 접근제한자
	// public -> 어느 위치(패키지)에서나 접근해서 사용이 가능하다.
	private int no;  // 글번호 : 고유번호 생성..
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
	private Date regDate;
	 
	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public Date getRegDate() {
		return regDate;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public String getTitle() {
		return title;
	}
	
	// get + 변수이름(첫글자 대문자로)
	public int getNo() {
		return no;
	}
	
	public Board setRegDate(Date r) {
		regDate = r;
		return this;
	}
	
	public Board setContent(String c) {
		content = c;
		return this;
	}
	
	public Board setWriter(String w) {
		writer = w;
		return this;
	}
	
	public Board setTitle(String t) {
		title = t;
		return this;
	}
	
	// 설정 : set + 변수(첫글자를 대문자)
	public void setNo(int n) {
		no = n;
	}
}












