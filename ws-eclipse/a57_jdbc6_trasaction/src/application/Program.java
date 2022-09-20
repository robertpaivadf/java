package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import db.DB;
import db.DBException;

public class Program {

	public static void main(String[] args) throws ParseException {
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			
				st = conn.createStatement();
				int rows1 = st.executeUpdate("update seller set basesalary=2090 where departmentid=1");
				
				int x =3;
				if (x <2) {
					throw new SQLException("Fake Error");
				}
				
				int rows2 = st.executeUpdate("update seller set basesalary=3090 where departmentid=2");
			
			conn.commit();
			System.out.println("rows1 " + rows1);
			System.out.println("rows2 " + rows2);
								
							
						
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DBException("Transaction rolled back " + e.getMessage());
			} catch (SQLException e1) {
				throw new DBException("Error trying to rolled back " + e.getMessage());
			}
		} finally {			
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
