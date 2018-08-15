import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CustomerBean;
import beans.OmniBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
	    String pwd = request.getParameter("pwd");
	  
		CustomerBean cb = new CustomerBean();
		cb.setEmail(email);
		cb.setPwd(pwd);
		CustomerDAO cd = new CustomerDAO();
		if (cd.isValid(cb)){
			  HttpSession session = request.getSession();
			  session.setAttribute("email",email);
			  session.setAttribute("pwd", pwd);
			  
			  System.out.println("Valid User");	
			  ArrayList<OmniBean> ol = new ArrayList<OmniBean>();
			  OmniDAO od = new OmniDAO();
			  ol = od.getFilters(email);
			  request.setAttribute("fList", ol);
			  for(OmniBean ob : ol)
			  System.out.println(ob.getName());
			  request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}else{
			response.sendRedirect("index.html");
		}
	}

}

