package pro.sky.mockito.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pro.sky.mockito.spring.InvalidInputData;
import pro.sky.mockito.spring.Employee;
import pro.sky.mockito.spring.EmployeeBook;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeBook employeeBook = new EmployeeBook();

    @Override
    public String addEmployeeToBook(String firstName, String lastName, int department, double salary) {
        firstName = checkingInputTextData(firstName);
        lastName = checkingInputTextData(lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        return (employeeBook.addEmployee(employee).toString());
    }
    @Override
    public int sizeEmployeeBook() {
        return employeeBook.sizeEmployees();
    }
    @Override
    public List getEmployeeBook() {
        return employeeBook.getEmployees();
    }
    @Override
    public String removeEmployeeFromBook(String firstName, String lastName, int department, double salary) {
        firstName = checkingInputTextData(firstName);
        lastName = checkingInputTextData(lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        return (employeeBook.removeEmployee(employee).toString());
    }
    @Override
    public Employee findEmployeeInBook(String firstName, String lastName, int department, double salary) {
        firstName = checkingInputTextData(firstName);
        lastName = checkingInputTextData(lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        return employeeBook.findEmployee(employee);
    }
    @Override
    public Employee searchEmployeeDepartmentMaxSalary(int department) {
        return employeeBook.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Value is null"));
    }
    @Override
    public Employee searchEmployeeDepartmentMinSalary(int department) {
        return employeeBook.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Value is null"));
    }
    @Override
    public List getAllEmployeesOfDepartment(int department) {
        return employeeBook.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    @Override
    public Map getEmployeesByDepartments() {
        Map<Integer, List<Employee>> map = employeeBook.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return map;
    }
    //Проверка вводимого текста (наличие только букв) и установка заглавной первой буквы
    @Override
    public String checkingInputTextData(String text) {
        if (!StringUtils.isEmpty(text)) {
            throw new InvalidInputData();
        } else text = StringUtils.capitalize(text);
        return text;
    }
}
