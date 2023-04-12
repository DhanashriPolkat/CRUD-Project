package com_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com_bo.login_bo;
import com_bo.stud_add_bo;

public class student_dao 
{
	public static Connection connect()
	{
		Connection cn=null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/project?useSSL=false&allowPublicKeyRetrieval=true";
			String un="root";
			String pss="Pass@123";
			
			cn=DriverManager.getConnection(url, un, pss);
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return cn;
	}
	
	
	public static int sign_up(login_bo lb)
	{
		int status=0;
		
		try
		{
			Connection cn=student_dao.connect();
			
			String query="insert into signup(name,email,password,phone_no) values (?,?,?,?)";
			
			PreparedStatement ps=cn.prepareStatement(query);
			
			ps.setString(1, lb.getName());
			ps.setString(2, lb.getEmail());
			ps.setInt(3, lb.getPassword());
			ps.setString(4, lb.getPhoneNo());
			
			status= ps.executeUpdate();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
		
	}
	
	public static boolean login(String name,String pass)
	{
		 boolean status=false;
		   
	     try {
			
	    	Connection con=student_dao.connect();
	    	
	    	String sql="select *from signup where name=? And password=?"; 
	    	
	    	PreparedStatement ps=con.prepareStatement(sql);
	    	
	    	ps.setString(1, name);
	    	ps.setString(2, pass);
	    	
	    	ResultSet rs=ps.executeQuery();
	    	status=rs.next();
	    	 
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
	
	     return status;
	}
	
	
	public static int add_data(stud_add_bo ab)
	{
		int status=0;
		
		try
		{
			Connection cn=student_dao.connect();
			
			String query="insert into employee(id,name,email,phone,doj,eoj,adhar) values (?,?,?,?,?,?,?)";
			
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setString(1, ab.getId());
			ps.setString(2, ab.getName());
			ps.setString(3, ab.getEmail());
			ps.setString(4, ab.getPhone());
			ps.setString(5, ab.getDoj());
			ps.setString(6, ab.getEoj());
			ps.setString(7, ab.getAdhar());
			
			status= ps.executeUpdate();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
	}
	
	public static List getAllEmployee( ) {
		   
        List<stud_add_bo> list= new ArrayList<stud_add_bo>();
  try {
	    Connection con=student_dao.connect();
        PreparedStatement ps=con.prepareStatement("select * from employee");
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()) {
        	stud_add_bo eb=new stud_add_bo();
        	
        	eb.setId(rs.getString(1));
        	eb.setName(rs.getString(2));
        	eb.setEmail(rs.getString(3));
        	eb.setPhone(rs.getString(4));
        	eb.setDoj(rs.getString(5));
        	eb.setEoj(rs.getString(6));
        	eb.setAdhar(rs.getString(7));
        	
            list.add(eb);
        	
        }
	  
} catch (Exception e) {
	System.out.println(e);
}
   
   return list;
   
}
	
public static int delete_data(String id) {
		
		int status=0;
		  try {
		
			  Connection con=student_dao.connect();
			  
			  String query="delete from employee where id=?";
			  
			  PreparedStatement ps=con.prepareStatement(query);
			  
			  ps.setString(1, id);
			  
			  status=ps.executeUpdate();
			  
		} catch (Exception e) {
		
			   System.out.println(e);
		}
		
		return status;
		
	}

public static stud_add_bo getEmployeeById(String id) {
	 
	 stud_add_bo eb=new stud_add_bo();
	 
	 try
	 {
		 Connection cn=student_dao.connect();
		 
		 String query="select * from employee where id=?";
		 
		 PreparedStatement ps=cn.prepareStatement(query);
		 
		 ps.setString(1, id);
		 
		 ResultSet rs=ps.executeQuery();
		 
		 if(rs.next())
		 {
			 	eb.setId(rs.getString(1));
	        	eb.setName(rs.getString(2));
	        	eb.setEmail(rs.getString(3));
	        	eb.setPhone(rs.getString(4));
	        	eb.setDoj(rs.getString(5));
	        	eb.setEoj(rs.getString(6));
	        	eb.setAdhar(rs.getString(7));
		 }
	 }
	 
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
		   
		   
	return eb;	   
	
}




public static int Update(stud_add_bo eb) {
	 int status=0;
	 
	 try {
		
		 Connection con=student_dao.connect();
		 
		 String query="update employee set name=?,email=?,phone=?, doj=?,eoj=?,adhar=? where id=?";
		 PreparedStatement ps=con.prepareStatement(query);
		 
		 ps.setString(1, eb.getName());
		 ps.setString(2, eb.getEmail());
        ps.setString(3, eb.getPhone());
        ps.setString(4, eb.getDoj());
        ps.setString(5, eb.getEoj());
        ps.setString(6, eb.getAdhar());
        ps.setString(7, eb.getId());
		 
        status=ps.executeUpdate();
        
        
        
	} catch (Exception e) {
		
		System.out.println(e);
		
	}
	 
	 
	 return status;
}

}
