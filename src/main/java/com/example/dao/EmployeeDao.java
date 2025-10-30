package com.example.dao;

import com.example.entity.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Data Access Object (DAO) interface for Employee operations.
 * This interface defines the standard operations to be performed
 * on Employee objects, abstracting the persistence (database) logic.
 */

public interface EmployeeDao {

    /**
     * Adds a new Employee to the database.
     *
     * @param employee The Employee object to be added.
     * @return true if the employee was added successfully, false otherwise.
     */
    boolean addEmployee(Employee employee);

    /**
     * Retrieves an Employee from the database by their ID.
     *
     * @param id The unique ID of the employee to retrieve.
     * @return The Employee object if found, or null if no employee exists with that ID.
     */
    Employee getEmployeeById(int id);

    /**
     * Retrieves a list of all Employees from the database.
     *
     * @return A List containing all Employee objects. The list will be empty if no employees are found.
     */
    List<Employee> getAllEmployees();

    /**
     * Updates an existing Employee's details in the database.
     * The Employee object should contain the ID of the employee to be updated.
     *
     * @param employee The Employee object with updated information.
     * @return true if the employee was updated successfully, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    boolean updateEmployee(Employee employee) throws SQLException;

    /**
     * Deletes an Employee from the database by their ID.
     *
     * @param id The unique ID of the employee to be deleted.
     * @return true if the employee was deleted successfully, false otherwise (e.g., if the ID was not found).
     * @throws SQLException If a database access error occurs.
     */
    boolean deleteEmployee(int id) throws SQLException;
}
