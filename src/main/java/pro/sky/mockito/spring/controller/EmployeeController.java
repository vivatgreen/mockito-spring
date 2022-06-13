package pro.sky.mockito.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.mockito.spring.Employee;
import pro.sky.mockito.spring.service.EmployeeService;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName,
                      @RequestParam int department, @RequestParam double salary) {
        return ("В книге <Сотрудники> создан сотрудник: "
                + employeeService.addEmployeeToBook(firstName, lastName, department, salary) + ".");
    }
    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName,
                         @RequestParam int department, @RequestParam double salary) {
        return ("В книге <Сотрудники> удален сотрудник: "
                + employeeService.removeEmployeeFromBook(firstName, lastName, department, salary));
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName,
                         @RequestParam int department, @RequestParam double salary) {
        return employeeService.findEmployeeInBook(firstName, lastName, department, salary);
    }
    @GetMapping("/size")
    public String size() {
        return ("Количество записей в книге <Сотрудники>: "
                + employeeService.sizeEmployeeBook());
    }
    @GetMapping("/print")
    public List print() {
        return (employeeService.getEmployeeBook());
    }

    @GetMapping("/departments/min-salary")
    public Employee findEmployeeMinSalary(@RequestParam int department) {
        return (employeeService.searchEmployeeDepartmentMinSalary(department));
    }
    @GetMapping("/departments/max-salary")
    public Employee findEmployeeMaxSalary(@RequestParam int department) {
        return (employeeService.searchEmployeeDepartmentMaxSalary(department));
    }
    @GetMapping("/departments/all")
    public List allEmployeesOfDepartment(@RequestParam int department) {
        return (employeeService.getAllEmployeesOfDepartment(department));
    }
    @GetMapping("/departments/all-departments")
    public Map employeesByDepartments() {
        return (employeeService.getEmployeesByDepartments());
    }
}
