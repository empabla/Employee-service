package pl.kurs.employeeservice.domain;

import java.util.Objects;

public class Employee {

    private String name;
    private String surname;
    private String pesel;
    private double salary;
    private String position;
    private String city;

    public Employee(String name, String surname, String pesel, double salary, String position, String city) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.salary = salary;
        this.position = position;
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(pesel, employee.pesel) && Objects.equals(position, employee.position) && Objects.equals(city, employee.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, pesel, salary, position, city);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
