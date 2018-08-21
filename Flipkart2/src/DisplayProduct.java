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
import beans.ProductBean;

/**
 * Servlet implementation class DisplayProduct
 */
@WebServlet("/DisplayProduct")
public class DisplayProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String pro = request.getParameter("pro");
        String cat;
        String fil;
        int val; 
        String db;
        OmniBean ob = (OmniBean)session.getAttribute("omni");
        
        if(pro.equals("wtop"))
        	cat = "Top";
        else if(pro.equals("wfoo"))
        	cat = "Foot";
        else
        	cat = "Bottom";
        ArrayList<ProductBean> pl = new ArrayList<ProductBean>();
        ProductDAO pd = new ProductDAO();

        if (session.getAttribute("omni") == null || session.getAttribute("omni").equals("")) {	                                                   
        	System.out.println("Before calling f");
            pl = pd.getProduct(cat);
            System.out.println("After calling f");
            System.out.println(pl);
        }else {
        	if (cat.equals("Top")) {
        		fil = "bust"; 
        		val = ob.getBust();
        		db = "wtsizechart";
        		pl = pd.getOmniProducts(cat, fil, db, val);
        	}
        	else if (cat.equals("Bottom")) {
        		fil = "waist";
        		val = ob.getWaist();
        		db = "wbsizechart";
        		pl = pd.getOmniProducts(cat, fil, db, val);
        	}
        	
        	 if(cat.equals("Foot")) {
        		fil = "length";
        		Float val2 = ob.getShoe();
        		db = "wssizechart";
        		pl = pd.getOmniShoeProducts(cat, fil, db, val2);
        	}
        	
            
        }
        		
        	
        
       request.setAttribute("plist" , pl);
       request.getRequestDispatcher("product.jsp").forward(request, response);
		
		
	}

}
