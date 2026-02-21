package com.exception.checked;

public class SQLExceptionCheck {

	public static void main(String[] args) {
		try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "user", "pass");
            Statement stmt = con.createStatement();
            stmt.executeQuery("INVALID SQL"); // Throws SQLException
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e);
        }


	}

}
