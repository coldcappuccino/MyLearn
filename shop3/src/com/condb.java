package com;
import java.sql.*;

public class condb {
    private Connection conn = null;
    private PreparedStatement prepstmt = null;
    
    //构造方法，连接数据库
    public condb(){
    	String CLASSFORNAME = "com.mysql.jdbc.Driver";
    	String SERVANDDB = "jdbc:mysql://localhost:3306/shop";
    	
    	String USER = "root";
    	String PWD = "root";
    	
    	try
		{
		    	
		   Class.forName(CLASSFORNAME);
			conn = DriverManager.getConnection(SERVANDDB,USER,PWD); 
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	 
    }
    
    public void executeUpdate(String sql) throws SQLException{
	    Statement stmt = conn.createStatement();
	    stmt.execute(sql);
	}
    
    public ResultSet executeQuery(String sql)throws SQLException{
    	  Statement stmt = conn.createStatement();
    	  if (stmt != null) {
				ResultSet rs= stmt.executeQuery(sql);
				return rs;
		  }else
				return null;
    }
    
    //预设sql语句
    public PreparedStatement preparedstatment(String sql)throws SQLException{
    	prepstmt = conn.prepareStatement(sql);
    	return prepstmt;
    }
    
    public void setString(int index,String value)throws SQLException{
    	prepstmt.setString(index, value);
    }
    
    public void setInt(int index, int value) throws SQLException {
		prepstmt.setInt(index, value);
	}

	public void setBoolean(int index, boolean value) throws SQLException {
		prepstmt.setBoolean(index, value);
	}

	public void setDate(int index, Date value) throws SQLException {
		prepstmt.setDate(index, value);
	}

	public void setLong(int index, long value) throws SQLException {
		prepstmt.setLong(index, value);
	}

	public void setFloat(int index, float value) throws SQLException {
		prepstmt.setFloat(index, value);
	}

	public void setBytes(int index, byte[] value) throws SQLException {
		prepstmt.setBytes(index, value);
	}
	
	public void executeUpdate()throws SQLException{
		if (prepstmt != null)
		prepstmt.execute();
	}
	
	public ResultSet executeQuery()throws SQLException{
		ResultSet rs = null; 
		if(prepstmt != null){
			  rs = prepstmt.executeQuery();
			  return rs;
		 }else{
			 return rs;
		 }
	}
}














