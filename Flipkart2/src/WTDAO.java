import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.ProductBean;
import beans.WTBean;

public class WTDAO {

	public ArrayList<WTBean> getChart(String brand) {
		
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		ResultSet rs;
		ArrayList<WTBean> pl = new ArrayList<WTBean>();
		
		try {
		PreparedStatement st = con.prepareStatement("select * from wtsizechart where brand = ?");
		st.setString(1, brand);
		rs = st.executeQuery();
		while(rs.next()) {
			WTBean pb = new WTBean(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
			System.out.println(rs.getString(1)+ rs.getString(2)+ rs.getInt(3)+ rs.getInt(4)+ rs.getInt(5)+ rs.getInt(6));
		    pl.add(pb);
		    System.out.println(pb);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pl;
	}

}
