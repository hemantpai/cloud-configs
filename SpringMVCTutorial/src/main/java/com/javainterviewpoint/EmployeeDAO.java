package com.javainterviewpoint;

import java.util.List;
public interface EmployeeDAO
{
    public void saveEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(int id);
    public List<Employee> getAllEmployees();
    public List<Employee> getAllEmployees(EmployeeRowMapper rowMapper);
    public String getEmployeeNameById(int id);
    //public Employee get
}
