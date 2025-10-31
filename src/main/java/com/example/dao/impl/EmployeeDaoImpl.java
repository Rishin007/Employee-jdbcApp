package com.example.dao.impl;

import com.example.config.DBConfig;
import com.example.dao.EmployeeDao;
import com.example.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public boolean addEmployee(Employee employee) {
        Connection con=null;
        String sql = "INSERT INTO employee (empno, ename, job, sal) VALUES (?, ?, ?, ?)";
        try{
            con= DBConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, employee.getEmpno());
            ps.setString(2, employee.getEname());
            ps.setString(3, employee.getJob());
            ps.setDouble(4, employee.getSal());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            IO.println(e.getMessage());
        }
        finally {
            try{
                if(con!=null)                      // Here we can see, as we haven't used try-with resource , we need to manually close the Connection object for it's every instance.
                    con.close();                    // Hence from the following method we will be using try with resource to implement Auto-Closeable which closes the connection,PreparedStatement object once the try blk finishes.
            }
            catch (SQLException e){
                IO.println(e.getMessage());
            }
        }
        return false;
    }

    @Override
    public Employee getEmployeeById(int empno) {
        String sql = "SELECT * FROM employee WHERE empno=?";
        try ( Connection con = DBConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setInt(1, empno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getDouble("sal"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try (Connection con = DBConfig.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql) )
        {
            while (rs.next()) {
                // A demo display of the list of employees present
//                IO.println("The Employee with id : " + rs.getInt("empno")+
//                        " stands for "+rs.getString("ename")+" is a "+rs.getString("job")
//                        +" and earns "+rs.getDouble("sal"));

                // In this case I chose to add the column index from the table in DB which would map 1=Empno, 2=Ename and so on.....
                list.add(new Employee(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        // SQL statement to update an existing employee record.
        // The '?' placeholders prevent SQL Injection and are replaced by parameters below.
        // The WHERE clause is crucial to ensure only the specified employee is updated.
        String sql = "UPDATE employee SET ename=?, job=?, sal=? WHERE empno=?";

        // Use try-with-resources to automatically close the Connection (con) and
        // PreparedStatement (ps) even if an exception occurs.
        try (Connection con = DBConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql) )

        {   // Set the parameters in the prepared statement, binding the new values to the SQL placeholders.
            // Parameter index 1 corresponds to ename
            ps.setString(1, employee.getEname());

            // Parameter index 2 corresponds to job
            ps.setString(2, employee.getJob());

            // Parameter index 3 corresponds to sal
            ps.setDouble(3, employee.getSal());

            // Parameter index 4 corresponds to empno, used in the WHERE clause to identify the row.
            ps.setInt(4, employee.getEmpno());

            // Execute the update statement. executeUpdate() returns the number of rows affected.
            // Return true if one or more rows were updated (meaning the employee ID was found), otherwise false.
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteEmployee(int empno) throws SQLException {
        // SQL statement to delete an employee record.
        // The WHERE clause with the empno parameter ensures only the specified employee is deleted.
        String sql = "DELETE FROM employee WHERE empno=?";

        // Use try-with-resources to automatically close the Connection (con) and
        // PreparedStatement (ps) when the try block finishes.
        try (Connection con = DBConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql) )
        {
            // Set the parameter for the prepared statement.
            // Parameter index 1 corresponds to empno, used in the WHERE clause.
            ps.setInt(1, empno);

            // Execute the delete statement. executeUpdate() returns the number of rows affected.
            // Return true if one or more rows were deleted (meaning the employee ID was found), otherwise false.
            return ps.executeUpdate() > 0;
        }
    }
}
