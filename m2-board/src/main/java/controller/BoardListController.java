package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.IBoardService;

@WebServlet("/boardList")	///WEB-INF/view/boardList.jsp랑 이름 통일시키기
public class BoardListController extends HttpServlet {
	private IBoardService boardService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Controller의 역할
		// 1) 요청을 받아서 분석
		int rowPerPage = 10;	//기본값은 10이지만
		if(request.getParameter("rowPerPage") != null) {	//전송받을 수 있는 값이 있다면	
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));	//전송받은 값으로 설정
		}
		int currentPage = 1;	//기본값은 1이지만
		if(request.getParameter("currentPage") != null) {	//전송받을 수 있는 값이 있다면	
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	//전송받은 값으로 설정
		}
		// 2) 서비스 레이어를 요청(메서드 호출) -> 모델값(자료구조) 구하기 위함
		// new
		boardService = new BoardService();
		Map<String, Object>  map = boardService.getBoardList(rowPerPage, currentPage);
		//분해할 수 있는 값은 분해해서 넘겨주기
		request.setAttribute("lastPage", map.get("lastPage"));
		request.setAttribute("currentPage", currentPage );
		request.setAttribute("list", map.get("list"));
		
		//3) view forwarding
		request.getRequestDispatcher("/WEB-INF/view/boardList.jsp").forward(request, response);
	}
}
