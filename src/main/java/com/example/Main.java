package com.example;

import com.example.dao.EmployeeDao;
import com.example.dao.impl.EmployeeDaoImpl;
import com.example.entity.Employee;

import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        // Create a Scanner object to read input from the console
        Scanner sc = new Scanner(System.in);
        // Instantiate the EmployeeDao implementation to interact with the database
        EmployeeDao employeeDao = new EmployeeDaoImpl();

       // Start a try block to catch potential exceptions, especially SQLException
        try {
            // Start an infinite loop to keep the application running until the user exits

    while (true) {                // Display the main menu options
        IO.println("=============== Employee Management System with JDBC ================");
        IO.println(" 1. Add an Employee");
        IO.println(" 2. View Employee by ID");
        IO.println(" 3. View All Employees");
        IO.println(" 4. Update an Employee by ID");
        IO.println(" 5. Delete an Employee");
        IO.println(" 6. Exit");
        IO.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            // Case 1: Add a new Employee
            case 1 -> {
                // Prompt for and read all employee details
                IO.print("Enter Employee's ID: ");
                int empno = sc.nextInt();
                IO.print("Enter Employee's Name: ");
                String ename = sc.next();
                IO.print("Enter Employee's Job: ");
                String job = sc.next();
                IO.print("Enter Employee's salary: ");
                double sal = sc.nextDouble();
                // Create a new Employee object and call the DAO to add it
                boolean addedEmployee = employeeDao.addEmployee(new Employee(empno, ename, job, sal));
                // Print a success or failure message based on the DAO's response
                IO.println(addedEmployee ? "An employee has been added!" : "Failed to add the employee.");
            }

            // Case 2: View a specific Employee by their ID
            case 2 -> {
                IO.print("Enter Employee ID to find: ");
                int empno = sc.nextInt();
                // Call the DAO to get the employee and print the result (or "not found" message)
                IO.println(employeeDao.getEmployeeById(empno));
            }

            // Case 3: View all Employees
            case 3 -> employeeDao.getAllEmployees().forEach(IO::println);     // Call the DAO to get all employees, then use a stream to print each one

            // Case 4: Update an existing Employee
            case 4 -> {
                IO.print("Enter Employee Number who is to be updated: ");
                int empno = sc.nextInt();
                IO.print("Enter New Name: ");
                String updatedEname = sc.next();
                IO.print("Enter New Job: ");
                String updatedJob = sc.next();
                IO.print("Enter New Salary: ");
                double updatedSal = sc.nextDouble();

                // Create an Employee object with the new details and call the DAO to update
                boolean updatedEmployee = employeeDao.updateEmployee(new Employee(empno, updatedEname, updatedJob, updatedSal));
                // Print a success or failure message
                IO.println(updatedEmployee ? "Employee has been updated!" : "Sorry! Updatation of the Employee Failed!");
            }

            // Case 5: Delete an Employee by ID
            case 5 -> {
                IO.print("Enter Employee ID to be deleted: ");
                int empno = sc.nextInt();
                // Call the DAO to delete the employee and print a confirmation or "not found" message
                IO.println(employeeDao.deleteEmployee(empno) ? "Employee has been deleted!!" : "Employee not found!");
            }

            // Case 6: Exit the application
            case 6 -> {
                IO.println("Exiting the Employee JDBC Application... Goodbye!!");
                System.exit(0);
            }

            default -> IO.println("Invalid Choice!");
        }
    }
}   catch (SQLException e){
    IO.println(e.getMessage());         // Catch any database-related errors
    }
    catch (Exception e){
       IO.println("Sorry, an error has occurred!"+e.getMessage());         // Catch any other general errors (like input mismatch)
}
    }
}