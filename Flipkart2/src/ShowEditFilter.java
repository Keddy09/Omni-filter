

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.OmniBean;

/**
 * Servlet implementation class ShowEditFilter
 */
@WebServlet("/ShowEditFilter")
public class ShowEditFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEditFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fid = Integer.parseInt(request.getParameter("fid"));
		OmniDAO od = new OmniDAO();
		OmniBean ob = od.getFilter(fid);
		request.setAttribute("ob", ob);
		request.getRequestDispatcher("EditFilter.jsp").include(request, response);
	}

}
