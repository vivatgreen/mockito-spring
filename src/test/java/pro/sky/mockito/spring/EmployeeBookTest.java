package pro.sky.mockito.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pro.sky.mockito.spring.constants.EmployeeBookConstants.*;

public class EmployeeBookTest {

        private EmployeeBook out = new EmployeeBook();
        private List<Employee> testList;

    @BeforeEach
    public void startSetupEmployeeBook() {
        Employee employee1 = new Employee("Иван", "Ivanov", 2, 20000);
        Employee employee2 = new Employee("Semen", "Semyonov", 2, 80000);
        Employee employee3 = new Employee("Petr", "Petrov", 1, 70000);
        Employee employee4 = new Employee("Mihail", "Mihajlov", 1, 50000);
        Employee employee5 = new Employee("Stepan", "Sidorov", 3, 60000);
        Employee employee6 = new Employee("Anton", "Smirnov", 3, 40000);
        out.addEmployee(employee1);
        out.addEmployee(employee2);
        out.addEmployee(employee3);
        out.addEmployee(employee4);
        out.addEmployee(employee5);
        out.addEmployee(employee6);
        testList = new ArrayList<Employee>
                (Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6));
    }
@Test
    public void shouldAddEmployeeWhenItNotExists() {
        Employee result = out.addEmployee(EMPLOYEE_WHO_IS_NOT_EXIST);
        Assertions.assertEquals(EMPLOYEE_WHO_IS_ADDED_TO_BOOK, result);
    }
    @Test
    public void shouldThrowEmployeeExistExceptionWhenAddEmployeeThatAlreadyExists() {
        Assertions.assertThrows(EmployeeExistException.class,
                () -> out.addEmployee(EMPLOYEE_WHO_IS_ALREADY_EXIST));
    }
    @Test
    public void shouldRemoveEmployeeWhenItExists() {
        Employee result = out.removeEmployee(EMPLOYEE_WHO_IS_ALREADY_EXIST);
        Assertions.assertEquals(EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK, result);
    }
    @Test
    public void shouldThrowEmployeeNotExistExceptionWhenRemoveEmployeeThatNotExists() {
        Assertions.assertThrows(EmployeeNotExistException.class,
                () -> out.removeEmployee(EMPLOYEE_WHO_IS_NOT_EXIST));
    }
    @Test
    public void shouldFindEmployeeWhenItExists() {
        Employee result = out.findEmployee(EMPLOYEE_WHO_IS_ALREADY_EXIST);
        Assertions.assertEquals(EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK, result);
    }
    @Test
    public void shouldThrowEmployeeNotExistExceptionWhenFindEmployeeThatNotExists() {
        Assertions.assertThrows(EmployeeNotExistException.class,
                () -> out.findEmployee(EMPLOYEE_WHO_IS_NOT_EXIST));
    }
    @Test
    public void shouldReturnEmployeeBook() {
        List result = out.getEmployees();
        Assertions.assertEquals(testList, result);
    }
    @Test
    public void shouldBeNumberOfEmployeesInBook() {
        int result = out.sizeEmployees();
        Assertions.assertEquals(NUMBER_OF_EMPLOYEES_IN_BOOK, result);
    }
}
