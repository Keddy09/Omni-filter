

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.OmniBean;

/**
 * Servlet implementation class EditOmniServlet
 */
@WebServlet("/EditOmniServlet")
public class EditOmniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOmniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fid = Integer.parseInt(request.getParameter("fid"));
		String name = request.getParameter("name");
		int shoulder = Integer.parseInt(request.getParameter("shoulder"));
		int bust = Integer.parseInt(request.getParameter("bust"));
		int waist = Integer.parseInt(request.getParameter("waist"));
		int hip = Integer.parseInt(request.getParameter("hip")); 
		Float shoe = Float.parseFloat(request.getParameter("shoe"));
		OmniBean ob = new OmniBean();
		ob.setBust(bust);
		ob.setFid(fid);
		ob.setHip(hip);
		ob.setName(name);
		ob.setShoe(shoe);
		ob.setShoulder(shoulder);
		ob.setWaist(waist);
		OmniDAO od = new OmniDAO();
		if(od.EditFilter(ob))
			System.out.println("Edited");
		else
			System.out.println("not Edited");
		request.getRequestDispatcher("ShowFilters").include(request, response);
	}

}
