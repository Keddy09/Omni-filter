

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.OmniBean;

/**
 * Servlet implementation class SaveOmni
 */
@WebServlet("/SaveOmniServlet")
public class SaveOmniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveOmniServlet() {
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
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		OmniBean ob = new OmniBean();
		PrintWriter out = response.getWriter();
		ob.setEmail(email);
		ob.setGender("F");
		ob.setName(request.getParameter("name"));
		ob.setShoulder(Integer.parseInt(request.getParameter("shoulder")));
		ob.setBust(Integer.parseInt(request.getParameter("bust")));
		ob.setWaist(Integer.parseInt(request.getParameter("waist")));
		ob.setHip(Integer.parseInt(request.getParameter("hip")));
		ob.setShoe(Float.parseFloat(request.getParameter("shoe")));
		
		OmniDAO od = new OmniDAO();
		if(od.saveFilter(ob)) {
			//request.getRequestDispatcher("");
			request.getRequestDispatcher("index.jsp");
			ArrayList<OmniBean> ol = new ArrayList<OmniBean>();
			  ol = od.getFilters(email);
			  request.setAttribute("fList", ol);
			  for(OmniBean ob1 : ol)
			  System.out.println(ob1.getName());
			  request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
			out.println("Couldnt add");
		
		
	}

}
