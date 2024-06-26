package kadai20;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BbsServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	//List<String> list = new ArrayList<String>();

	//String action = "write";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		@SuppressWarnings("unchecked")
		ArrayList<String> list = (ArrayList<String>) session.getAttribute("sessionList");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");

		//送信データを取得

		out.println("<head>");
		out.println("<title>掲示板</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"/canon_jmaster_git/BbsServlet2\" method=\"post\">");
		out.println("名前：<br>");
		out.println("<input type=\"text\" name=\"NAME\">");
		out.println("<br>");
		out.println("メッセージ：<br>");
		out.println("<textarea name=\"MESSAGE\" cols=\"30\" rows=\"5\"></textarea>");
		out.println("<br>");
		out.println("<input type=\"submit\" value=\"書き込み\">");
		out.println("</form>");
		out.println("<hr>");
		for (String l : list) {
			out.println(l);
			out.println("<hr>");
		}

		out.println("</html>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
