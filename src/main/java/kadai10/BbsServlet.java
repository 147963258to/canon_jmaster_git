package kadai10;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BbsServlet
 */
@WebServlet("/BbsServlet")
public class BbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BbsServlet() {
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

		//request.getRequestURI();
		String removeNum = request.getParameter("removeNum");
		String action = request.getParameter("ACTION");

		System.out.println(action);
		System.out.println(removeNum);

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");

		if (action.equals("remove")) {

			//削除処理
			System.out.print("削除");
			list.remove(Integer.parseInt(removeNum));

		} else if (action.equals("write")) {

			//送信データを取得
			String name = request.getParameter("NAME");
			String message = request.getParameter("MESSAGE");

			// 現在日時を取得
			LocalDateTime date1 = LocalDateTime.now();

			// 表示形式を指定
			DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

			String fdate1 = dtformat.format(date1); //表示形式+Stringに変換

			//リストに入れる
			list.add(fdate1 + " " + name + ":" + message);
		} else {
			out.println("操作error");
			out.println("<a href=\"/canon_jmaster_git/kadai10/bbs.html\">戻る</a>");
			out.println("</html>");
			return;
		}

		out.println("<head>");
		out.println("<title>掲示板</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"/canon_jmaster_git/BbsServlet\" method=\"post\">");
		out.println("<input type=\"hidden\" name=\"ACTION\" value=\"write\">");
		out.println("名前：<br>");
		out.println("<input type=\"text\" name=\"NAME\">");
		out.println("<br>");
		out.println("メッセージ：<br>");
		out.println("<textarea name=\"MESSAGE\" cols=\"30\" rows=\"5\"></textarea>");
		out.println("<br>");
		out.println("<input type=\"submit\" value=\"書き込み\">");
		out.println("</form>");
		out.println("<hr>");

		int i = 0;
		//action = "remove";

		for (String l : list) {
			out.println(l);
			String removeParam = "removeNum=" + i;

			out.println("<a href=\"/canon_jmaster_git/BbsServlet?ACTION=remove&" + removeParam + "\">削除</a>");
			out.println("<hr>");
			i++;

		}

		out.println("</html>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

}
