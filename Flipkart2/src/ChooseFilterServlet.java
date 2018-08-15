

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.OmniBean;

/**
 * Servlet implementation class ChooseFilterServlet
 */
@WebServlet("/ChooseFilterServlet")
public class ChooseFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseFilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("In Post");
		String a = request.getParameter("fid");
		int fid = Integer.parseInt(a);
		
		
		OmniBean ob = new OmniBean();
		OmniDAO od = new OmniDAO();
		ob = od.getFilter(fid);
		session.setAttribute("omni", ob);
		System.out.println((OmniBean)session.getAttribute("omni"));
		System.out.println("Finish");
		
		ArrayList<OmniBean> ol = new ArrayList<OmniBean>();
		String st = (String)session.getAttribute("email");  
		ol = od.getFilters(st);
		  request.setAttribute("fList", ol);
		  request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		

	}

}
