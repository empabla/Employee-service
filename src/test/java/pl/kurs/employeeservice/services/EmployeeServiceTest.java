package pl.kurs.employeeservice.services;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import pl.kurs.employeeservice.domain.Employee;
import pl.kurs.employeeservice.exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeServiceTest {

    EmployeeService employeeService;
    List<Employee> employeesForTest;

    @Before
    public void init() {
        employeesForTest = new ArrayList<>();
        employeesForTest.add(new Employee("Adam", "Nowak", "12345678999", 10_000.0D, "Programmer", "Warsaw"));
        employeesForTest.add(new Employee("Robert", "Puczyk", "09876543212", 12_000.0D, "Programmer", "Warsaw"));
        employeesForTest.add(new Employee("Anna", "Kwiatkowska", "65748345327", 13_000.0D, "Manager", "Poznan"));
        employeesForTest.add(new Employee("Franciszek", "Lasek", "23456569995", 9_000.0D, "Tester", "Poznan"));
        employeesForTest.add(new Employee("Roman", "Kowalski", "23226569995", 12_000.0D, "Programmer", "Poznan"));
        employeesForTest.add(new Employee("Zbigniew", "Chleb", "23226569995", 8_000.0D, "Tester", "Warsaw"));
        employeesForTest.add(new Employee("Albert", "Kwiat", "23226569995", 12_000.0D, "Programmer", null));
        employeesForTest.add(new Employee("Krzysztof", "Pączek", "23226569995", 12_000.0D, null, "Krakow"));
        employeesForTest.add(null);

        employeeService = new EmployeeService();
    }

    @Test
    public void shouldReturnAnnaKwiatkowska() throws EmployeeNotFoundException {
        //when
        Employee bestPaidEmployee = employeeService.getHighestPaidEmployee(employeesForTest);

        //then
        assertTrue(employeesForTest.get(2) == bestPaidEmployee);
    }

    @Test
    public void shouldReturnWarsawAndPoznan() {
        //given
        List<String> expectedCities = List.of("Poznan", "Warsaw");

        //when
        List<String> citesWithMostEmployees = employeeService.getCitesWithMostEmployees(employeesForTest);

        //then
        Assertions.assertThat(citesWithMostEmployees).containsExactlyInAnyOrderElementsOf(expectedCities);
    }

    @Test
    public void shouldReturnRobertPuczykForBestPaidInWarsaw() throws EmployeeNotFoundException {
        //given
        String cityForTest = "Warsaw";

        //when
        Employee highestPaidEmployeeInWarsaw = employeeService.getHighestPaidEmployeeInCity(employeesForTest, cityForTest);

        //then
        assertSame(employeesForTest.get(1), highestPaidEmployeeInWarsaw);
    }

    @Test
    public void shouldReturnAverageSalary11500ForProgrammerPosition() {
        //given
        String positionForTest = "Programmer";

        //when
        double averageSalaryForProgrammer = employeeService.getAverageSalaryByPosition(employeesForTest, positionForTest);

        //then
        assertEquals(11500, averageSalaryForProgrammer, 0.0);
        //assertTrue(Double.compare(11500, averageSalaryForProgrammer) == 0);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenListIsNull() {
        //given
        List<Employee> employeesForTest = null;

        //when
        Exception e = assertThrows(EmployeeNotFoundException.class, () -> employeeService.getHighestPaidEmployee(employeesForTest));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(EmployeeNotFoundException.class);
        sa.assertThat(e).hasMessage("No employee found");
        sa.assertThat(e).hasNoCause();
        sa.assertAll();
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenListIsEmpty() {
        //given
        List<Employee> employeesForTest = new ArrayList<>();

        //when
        Exception e = assertThrows(EmployeeNotFoundException.class, () -> employeeService.getHighestPaidEmployee(employeesForTest));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(EmployeeNotFoundException.class);
        sa.assertThat(e).hasMessage("No employee found");
        sa.assertThat(e).hasNoCause();
        sa.assertAll();
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenListIsNullSecondMethod() {
        //given
        List<Employee> employeesForTest = null;
        String cityForTest = null;

        //when
        Exception e = assertThrows(EmployeeNotFoundException.class, () -> employeeService.getHighestPaidEmployeeInCity(employeesForTest, cityForTest));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(EmployeeNotFoundException.class);
        sa.assertThat(e).hasMessage("No employee found");
        sa.assertThat(e).hasNoCause();
        sa.assertAll();
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenListIsEmptySecondMethod() {
        //given
        List<Employee> employeesForTest = new ArrayList<>();
        String cityForTest = null;

        //when
        Exception e = assertThrows(EmployeeNotFoundException.class, () -> employeeService.getHighestPaidEmployeeInCity(employeesForTest, cityForTest));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(EmployeeNotFoundException.class);
        sa.assertThat(e).hasMessage("No employee found");
        sa.assertThat(e).hasNoCause();
        sa.assertAll();
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionAsThereIsNoEmployeeFromGdansk() {
        //given
        String cityForTest = "Gdansk";

        //when
        Exception e = assertThrows(EmployeeNotFoundException.class, () -> employeeService.getHighestPaidEmployeeInCity(employeesForTest, cityForTest));

        //then
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(e).isExactlyInstanceOf(EmployeeNotFoundException.class);
        sa.assertThat(e).hasMessage("No employee found");
        sa.assertThat(e).hasNoCause();
        sa.assertAll();
    }

}