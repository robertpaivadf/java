package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) throws ParseException {
		Connection conn = null;
		PreparedStatement st = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"insert into coursejdbc.seller "
					+"(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+"values "
					+"(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, "Carl Purple");
			st.setString(2, "carl@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/05/2000").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected>0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id="+id);
				}				
			}else {
				System.out.println("No row affected!");
			}
			
			st = conn.prepareStatement(
					"insert into coursejdbc.seller "
					+"(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+"values "
					+"('Mary Popy','mary@gmail.com','1999-05-16',2500, 3)");
			
			rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rowns affected: " + rowsAffected);
			
			
			st = conn.prepareStatement(
					"insert into department "
					+"(Name) "
					+"values "
					+"('D1'), ('D2')", Statement.RETURN_GENERATED_KEYS);
			
			rowsAffected = st.executeUpdate();
			
			if(rowsAffected>0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id="+id);
				}				
			}else {
				System.out.println("No row affected!");
			}			
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			//DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
