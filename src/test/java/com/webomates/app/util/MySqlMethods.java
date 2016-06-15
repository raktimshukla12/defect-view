package com.webomates.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MySqlMethods 
{
	public static Connection createConnection() throws SQLException {
		Connection connection = null;
		try {
			String drivers = "com.mysql.jdbc.Driver";
			String connectionURL = "jdbc:mysql://localhost:3306/defectview";
			String username = "root";
			String password = "root";
			Class.forName(drivers);
			connection = DriverManager.getConnection(connectionURL, username, password);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
//		System.out.println("connection.isClosed();" + connection.isValid(1));
		return connection;		
	}

	public static List<List<String>> getDBTableData(String query, Connection connection) throws SQLException{
		List<List<String>> dbList =  new LinkedList<List<String>>();
		Statement stmt = connection.createStatement();
		ResultSet rset = stmt.executeQuery(query);
        
 
        while(rset.next()){
        	List<String> values = new ArrayList<String>();
        	String bug_id = rset.getString(1);
            String bug_severity = rset.getString(2);
            String bug_status = rset.getString(3);
            String bug_op_sys = rset.getString(4);
            String bug_priority = rset.getString(5);
            values.add(bug_id);
            values.add(bug_severity);
            values.add(bug_status);
            values.add(bug_op_sys);
            values.add(bug_priority);
            dbList.add(values);
          /*  System.out.println(bug_id + "\t" + bug_severity +
                    "\t" + bug_status + "\t" + bug_op_sys +
                    "\t" + bug_priority); */            
        } 
       
        return dbList; 
    }
}
