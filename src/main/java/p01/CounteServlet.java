package p01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SampleServlet01
 */
@WebServlet("/Counter")
public class CounteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//
		HttpSession session = request.getSession(true);
		
		session.setMaxInactiveInterval(10);
		
		Integer count = (Integer)session.getAttribute("COUNT");
		
		if(count == null) {
			count = 0;
		}
	
		count++;
		
//		if(count > 10) {
//			count = 0;
//		}
		
		
		session.setAttribute("COUNT",count);
		
		if(count >= 10) {
			//session.removeAttribute("COUNT");
			session.invalidate();//センクションオブジェクトを消滅する
		}
//		}
		
		
		//送信データを取得
		String emp = request.getParameter("EMP");
		
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
		out.println("カウント値"+count+"<br>");
		out.println("<a href= 'Counter'>カウントアップ</a><br>");
		out.println("</body>");
		out.println("</html>");
	}

}
