package kadai20;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BbsServlet
 */
@WebServlet("/BbsServlet2")
public class BbsServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BbsServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	List<String> list = new ArrayList<String>();

	//String action = "write";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		//Webブラウザへのお知らせ情報の設定
		response.setContentType("text/html; charset=UTF-8");

		//		PrintWriter out = response.getWriter();

		//		out.println("<!DOCTYPE html>");
		//		out.println("<html>");

		//送信データを取得
		String name = request.getParameter("NAME");
		String message = request.getParameter("MESSAGE");

		//リストに入れる
		list.add(name + ":" + message);

		//		out.println("<head>");
		//		out.println("<title>掲示板</title>");
		//		out.println("</head>");
		//		out.println("<body>");
		//		out.println("<form action=\"/canon_jmaster_git/BbsServlet2\" method=\"post\">");
		//		out.println("名前：<br>");
		//		out.println("<input type=\"text\" name=\"NAME\">");
		//		out.println("<br>");
		//		out.println("メッセージ：<br>");
		//		out.println("<textarea name=\"MESSAGE\" cols=\"30\" rows=\"5\"></textarea>");
		//		out.println("<br>");
		//		out.println("<input type=\"submit\" value=\"書き込み\">");
		//		out.println("</form>");
		//		out.println("<hr>");

		HttpSession session = request.getSession();
		session.setAttribute("sessionList", list);

		RequestDispatcher rd = request.getRequestDispatcher("/ShowServlet");

		//フォワード処理を実行（リクエスト転送処理の実行）
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

}
