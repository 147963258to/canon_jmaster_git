package p01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SampleServlet01
 */
@WebServlet("/pageA")
public class PageA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//
		HttpSession session = request.getSession(true);
		
		session.setAttribute("NAME","山田太郎");
		
		//アプリケーションオブジェクトを取得
		ServletContext application = getServletContext();
		
		
		
		application.getAttribute("AGE",20);
		
		request.setAttribute();
		
		//Webブラウザへのお知らせ情報の設定
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>カウンタ</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>カウンタ</h1>");
		out.println("<hr>");
		out.println("<a href= 'pageB'>ページBへ</a><br>");
		out.println("</body>");
		out.println("</html>");
	}

}
