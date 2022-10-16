package Employee;

import java.util.*;

/*
 * 
 * OOD: Design an employee object and it has date of join, salary, address...etc
You have to come up with a method to random generate an amount of employees and their DOJ, Zipcode are also randomly generated.
Another method to search employee that are just randomly generated based on their zipcode/salary.
 */

class Employee {
    private Date dateOfJoin;
    private Integer salary;
    private String address;
    private Integer zipcode;

    public Employee(Date dateOfJoin, Integer salary, String address, Integer zipcode) {
        this.dateOfJoin = dateOfJoin;
        this.salary = salary;
        this.address = address;
        this.zipcode = zipcode;
    }

    public Date getDate() {
        return this.dateOfJoin;
    }

    public Integer getSalary() {
        return this.salary;
    }

    public String getAddress() {
        return this.address;
    }

    public Integer getZipcode() {
        return this.zipcode;
    }

}

class SearchQuery {
    String queryType;
    Integer queryArgument;
}

public class EmployeeSystem {
    List<Employee> employees;

    public EmployeeSystem() {
        this.employees = new ArrayList<>();
    }

    private String getRandomEmployeeId() {
        return UUID.randomUUID().toString();
    }

    private Integer getRandomSalary() {
        return 100000 + new Random().nextInt(900000) + 1;
    }

    private Integer getRandomZipCode() {
        return 10000 + new Random().nextInt(90000) + 1;
    }

    public Employee generateRandomEmployee() {
        Date date = new Date();
        Employee employee = new Employee(date, getRandomSalary(), getRandomEmployeeId(), getRandomZipCode());
        
        return employee;
    }

    public void setEmployees(Integer count) {
        for(int i=0;i<count;i+=1){
            this.employees.add(generateRandomEmployee());
        }
    }

    public Employee searchEmployees(SearchQuery search) {
        switch(search.queryType) {
            case "Salary" : 
                for(Employee emp : employees) {
                    if(emp.getSalary() == search.queryArgument)
                        return emp;
                }
                break;
            case "Zipcode" :
                for(Employee emp : employees) {
                    if(emp.getZipcode() == search.queryArgument)
                        return emp;
                }
                break;
            default:
                return null;
        }
        return null;
    }
}
