package pro.sky.mockito.spring.constants;

import pro.sky.mockito.spring.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeBookConstants {
    public static final Employee EMPLOYEE_WHO_IS_NOT_EXIST =
            new Employee("Vladimir", "Shatrov", 2, 30000);
    public static final String FIRST_NAME_NOT_EXIST = "Vladimir";
    public static final String FIRST_NAME_NOT_EXIST_WITH_LOWER_CASE = "vladimir";
    public static final String FIRST_NAME_NOT_EXIST_WITH_ILLEGAL_CHARACTERS = "Vladimir123";
    public static final String LAST_NAME_NOT_EXIST = "Shatrov";
    public static final String LAST_NAME_NOT_EXIST_WITH_LOWER_CASE = "shatrov";
    public static final String LAST_NAME_NOT_EXIST_WITH_ILLEGAL_CHARACTERS = "Shatrov456";
    public static final int DEPARTMENT_NOT_EXISTS = 2;
    public static final int SALARY_NOT_EXISTS = 30000;
    public static final Employee EMPLOYEE_WHO_IS_ALREADY_EXIST =
            new Employee("Ivan", "Ivanov", 2, 20000);
    public static final String FIRST_NAME_ALREADY_EXIST = "Ivan";
    public static final String FIRST_NAME_ALREADY_EXIST_WITH_LOWER_CASE = "ivan";
    public static final String FIRST_NAME_ALREADY_EXIST_WITH_ILLEGAL_CHARACTERS = "Ivan5";
    public static final String LAST_NAME_ALREADY_EXIST = "Ivanov";
    public static final String LAST_NAME_ALREADY_EXIST_WITH_LOWER_CASE = "ivanov";
    public static final String LAST_NAME_ALREADY_EXIST_WITH_ILLEGAL_CHARACTERS = "Ivanov7";
    public static final int DEPARTMENT_ALREADY_EXISTS = 2;
    public static final int SALARY_ALREADY_EXISTS = 20000;
    public static final Employee EMPLOYEE_WHO_IS_ADDED_TO_BOOK =
            new Employee("Vladimir", "Shatrov", 2, 30000);
    public static final Employee EMPLOYEE_WHO_IS_FOUND_OR_REMOVE_IN_BOOK =
            new Employee("Ivan", "Ivanov", 2, 20000);
    public static final int NUMBER_OF_EMPLOYEES_IN_BOOK = 6;
    public static final List<Employee> TEST_LIST = new ArrayList<Employee>
            (Arrays.asList(EMPLOYEE_WHO_IS_NOT_EXIST, EMPLOYEE_WHO_IS_ALREADY_EXIST));
    public static final Employee EMPLOYEE_WITH_MAX_SALARY =
            new Employee("Ivan", "Ivanov", 2, 90000);
    public static final Employee EMPLOYEE_WITH_MIN_SALARY =
            new Employee("Ivan", "Ivanov", 2, 20000);
    public static final List<Employee> TEST_LIST_FOR_METHODS_WITH_DEPARTMENTS = new ArrayList<Employee>
            (Arrays.asList(EMPLOYEE_WITH_MAX_SALARY, EMPLOYEE_WITH_MIN_SALARY));
    public static final int DEPARTMENT_FOR_METHODS_WITH_DEPARTMENTS = 2;
    public static final Map<Integer, List<Employee>> MAP_TEST = TEST_LIST_FOR_METHODS_WITH_DEPARTMENTS.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

}
