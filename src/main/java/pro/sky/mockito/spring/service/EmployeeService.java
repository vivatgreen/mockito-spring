package pro.sky.mockito.spring.service;

import pro.sky.mockito.spring.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    String removeEmployeeFromBook(String firstName, String lastName, int department, double salary);

    Employee findEmployeeInBook(String firstName, String lastName, int department, double salary);

    String addEmployeeToBook(String firstName, String lastName, int department, double salary);

    int sizeEmployeeBook();

    List getEmployeeBook();

    Employee searchEmployeeDepartmentMinSalary(int department);

    Employee searchEmployeeDepartmentMaxSalary(int department);

    List getAllEmployeesOfDepartment(int department);

    Map getEmployeesByDepartments();

    String checkingInputTextData(String text);
}
