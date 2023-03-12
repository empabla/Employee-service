package pl.kurs.employeeservice.domain;

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
