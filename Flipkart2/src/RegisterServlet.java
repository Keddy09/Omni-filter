

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CustomerBean;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
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
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		out.println(email);
		
		CustomerBean cb = new CustomerBean();
		cb.setEmail(email);
		cb.setFname(fname);
		cb.setLname(lname);
		cb.setPhone(phone);
		cb.setPwd(pwd);
		CustomerDAO cd = new CustomerDAO();
		
		if (cd.exists(cb)){			
			//response.sendRedirect("ProjectTeam.jsp");
			System.out.println("Already exists");			
		}else{
			System.out.println("Unique email");
			if(cd.register(cb)) 
				response.sendRedirect("index.html");
			else
				System.out.println("Could not register");
		}
	}
	
}

