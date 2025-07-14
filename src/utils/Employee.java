package utils;

import java.util.Objects;

public class Employee {

    private long id;
    private String name;
    private double salary;

    public Employee(long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public long getID() {
        return id;
    }

    public void setID(long ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Employee)) return false;
        Employee employee=(Employee) o;
        return id == employee.getID() && Objects.equals(name,employee.getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,name);
    }
}
