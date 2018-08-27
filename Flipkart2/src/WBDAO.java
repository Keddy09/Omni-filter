import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.WBBean;

public class WBDAO {
public ArrayList<WBBean> getChart(String brand) {
		
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		ResultSet rs;
		ArrayList<WBBean> pl = new ArrayList<WBBean>();
		
		try {
		PreparedStatement st = con.prepareStatement("select * from wbsizechart where brand = ?");
		st.setString(1, brand);
		rs = st.executeQuery();
		while(rs.next()) {
			WBBean pb = new WBBean(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
			System.out.println(rs.getString(1)+ rs.getString(2)+ rs.getInt(3)+ rs.getInt(4)+ rs.getInt(5));
			
		    pl.add(pb);
		    System.out.println(pb);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pl;
	}

}
