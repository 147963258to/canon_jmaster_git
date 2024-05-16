package kadai10;

import java.io.IOException;
import java.io.PrintWriter;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		
		//送信データを取得
		//String emp = request.getParameter("EMP");
		String message = request.getParameter("message");
		
		//Webブラウザへのお知らせ情報の設定
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("Bbs/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>データ受信</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>データ受信</h1>");
		out.println("<hr>");
		out.println("名前：" + message + "<br>");
		out.println("</body>");
		out.println("</html>");

	}

}
