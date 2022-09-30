package com.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.dto.EmployeeStatsDto;
import com.main.model.Employee;

public class EmployeeDB {
	
	private Connection con; 
	
	public void dbConnect() {
		//connect to the DB
		
		String url="jdbc:mysql://localhost:3306/mydb_77777";
		String username= "root";
		String password="";//Password123
		String driver="com.mysql.cj.jdbc.Driver";
		
		/* Load the Driver */
		try {
			Class.forName(driver);
			//System.out.println("driver loaded..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		/* Establish the Connection */
		try {
			con = DriverManager.getConnection(url, username, password);
			//System.out.println("connection established..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose() {
		//close the connection 
		try {
			con.close();
			//System.out.println("connection closed..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> getAllEmployees() {
		dbConnect();
		//logic for fetching the employees
		String sql="select * from employee";
		List<Employee> list = new ArrayList<>();
		try {
			/* To execute sql, prepare the statement */
			PreparedStatement pstmt =  con.prepareStatement(sql);
			
			/* Use statement and fire SQL on DB*/
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) { //stay in the loop as long as there is a row to read in the resultset
				//read the row from the result set
				Employee e = new Employee(); //100X 200X 300X
				e.setId(rst.getInt("id"));
				e.setName(rst.getString("name"));
				e.setSalary(rst.getDouble("salary"));
				e.setBranch(rst.getString("branch"));
				
				list.add(e); //100X(HP), 200X(RW), 300X(HG)
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}

	public void insertEmployee(Employee e) {
		dbConnect();
		//logic for Inserting an employee
		String sql="insert into employee(name,salary,branch) values (?,?,?)"; //SQL Injection prevention
		/* To execute sql, prepare the statement */
		try {
			PreparedStatement pstmt =  con.prepareStatement(sql);
			pstmt.setString(1, e.getName());
			pstmt.setDouble(2, e.getSalary());
			pstmt.setString(3, e.getBranch());
			
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		dbClose();
		
	}

	public void deleteEmployeeById(int id) {
		dbConnect();
		String sql="delete from employee where id=?";
		try {
			PreparedStatement pstmt =  con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		
	}

	public List<EmployeeStatsDto> fetchStats() {
		dbConnect();
		String sql="select branch, COUNT(id) as number_of_employees from employee group by branch";
		List<EmployeeStatsDto> list = new ArrayList<>();
		try {
			PreparedStatement pstmt =  con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				EmployeeStatsDto dto = new EmployeeStatsDto();
				dto.setBranch(rst.getString("branch"));
				dto.setNum(rst.getInt("number_of_employees")); 
				list.add(dto);
			}
			
		} catch (SQLException e) {
			 
		}
		dbClose();
		return list;
	}
}
/* 
 fetch(select) : executeQuery()
 insert/delete/update: executeUpdate()
 */







