This project highlights the basic CRUD operations from a table in a database using JDBC. I have used Oracle as the database for my application of Employee Management.
In this small project, I have implemented the various ways by which 1 can cloase the Connection object after finishing the required task by doing it either manually within finally or by implementing the 'try-with resource' concept that enhances scalability of the project and saves time.
I have used AI to generate the comments for automation of tasks as well as to understand the difference b/w executeQuery() and exceuteUpdate() methods, when to use whom and how to use them. Likewise, I have implemented them in the project.
I have used Gemini as usual for debugging how can I implement try with resource without catch as well as with catch.

The following r the snippets of the console while the application is running :-

View of the Console :-
<img width="965" height="367" alt="Screenshot 2025-10-30 192641" src="https://github.com/user-attachments/assets/0d3d5f9e-1321-4f3d-ab21-e319a73dbca3" />


Adding an employee :-
<img width="912" height="461" alt="Screenshot 2025-10-30 192657" src="https://github.com/user-attachments/assets/b7537492-9e18-4c08-b62b-8ff392302479" />


Finding an employee with wrong ID :-
<img width="964" height="370" alt="Screenshot 2025-10-30 193046" src="https://github.com/user-attachments/assets/f3ea02cb-b04c-4aa1-a74b-d742b79a8969" />


Giving an Invalid Choice :-
<img width="872" height="304" alt="Screenshot 2025-10-30 193110" src="https://github.com/user-attachments/assets/947a0ca8-beca-429d-b71b-76a3eb71e519" />


Employee with particular Id :-
<img width="1283" height="355" alt="Screenshot 2025-10-30 193130" src="https://github.com/user-attachments/assets/11c598d7-0214-4881-914a-5803466dd332" />


Updating an Employee that doesn't exist :-
<img width="963" height="449" alt="Screenshot 2025-10-30 193222" src="https://github.com/user-attachments/assets/b3569a35-c197-4499-b2ab-2cd65c2b6b40" />


Updating an Employee successfully :-
<img width="925" height="446" alt="Screenshot 2025-10-30 193330" src="https://github.com/user-attachments/assets/18e1138c-d1f4-4403-9d2d-1fe69969c393" />


Deleting an existing employee :-
<img width="925" height="342" alt="Screenshot 2025-10-30 194618" src="https://github.com/user-attachments/assets/781a88cf-c0b4-4497-86d0-70fc069c8746" />


Viewing all the existing employees :-
<img width="1323" height="422" alt="image" src="https://github.com/user-attachments/assets/7213f77b-d534-44a4-8b87-cdf15072657b" />


Exiting the application :-
<img width="931" height="329" alt="Screenshot 2025-10-30 194633" src="https://github.com/user-attachments/assets/29fb8aff-91be-4adb-a7c2-207034261e74" />


Table Description :-
<img width="1149" height="237" alt="Screenshot 2025-10-30 195522" src="https://github.com/user-attachments/assets/1ae2e513-afb6-41f4-8aba-0c5c019217b0" />


All employees before updating the salary of Ritwik :-
<img width="679" height="265" alt="Screenshot 2025-10-30 195555" src="https://github.com/user-attachments/assets/87396f83-cf11-4317-9909-d6f41a7289ae" />


All the existing employees from DB after updating :-
<img width="678" height="250" alt="Screenshot 2025-10-30 195541" src="https://github.com/user-attachments/assets/85e2109f-28fd-4976-908c-ba5ee02ae31c" />
