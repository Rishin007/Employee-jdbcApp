package com.example.dao.impl;

import com.example.config.DBConfig;
import com.example.dao.EmployeeDao;
import com.example.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private static Connection con;

    @Override
    public boolean addEmployee(Employee employee) {
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
        try (Connection con = DBConfig.getConnection();
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
        String sql = "UPDATE employee SET ename=?, job=?, sal=? WHERE empno=?";

        try (Connection con = DBConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql) )

        {
            ps.setString(1, employee.getEname());
            ps.setString(2, employee.getJob());
            ps.setDouble(3, employee.getSal());
            ps.setInt(4, employee.getEmpno());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteEmployee(int empno) throws SQLException {
        String sql = "DELETE FROM employee WHERE empno=?";

        try (Connection con = DBConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql) )
        {
            ps.setInt(1, empno);
            return ps.executeUpdate() > 0;
        }
    }
}
