package pro.sky.mockito.spring;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBook {

    List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        if (employees.contains(employee)) {
            throw new EmployeeExistException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        } else
            throw new EmployeeNotExistException();
    }
    public Employee findEmployee(Employee employee) {
        if (employees.contains(employee)) {
            return employee;
        } else
            throw new EmployeeNotExistException();
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public int sizeEmployees() {
        return employees.size();
    }
}

