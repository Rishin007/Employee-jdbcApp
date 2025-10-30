package com.example.dao;

import com.example.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    boolean addEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    boolean updateEmployee(Employee employee) throws SQLException;
    boolean deleteEmployee(int id) throws SQLException;
}
