package com.javainterviewpoint;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{

    private JdbcTemplate jdbcTemplate;
    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Saving a new Employee
    public void saveEmployee(Employee employee)
    {
        String sql = "insert into Employee values(?,?,?)";
        System.out.println("dao called");
        jdbcTemplate.update(sql, new Object[]
        { employee.getId(), employee.getName(), employee.getAddress()});
    }

    // Getting a particular Employee
   /* public Employee getEmployeeById(int id)
    {
        String sql = "select * from Employee where id=?";
        Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[]
        { id }, new RowMapper<Employee>()
        {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
                Employee employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setAddress(rs.getString(3));
                 return employee;
            }
        });
        return employee;
    }
*/

    
    
    public Employee getEmployeeById(int id)
    {
        String sql = "select * from Employee where id=?";
        Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
        return employee;
    }

  
    
    // Getting all the Employees
    public List<Employee> getAllEmployees()
    {
        String sql = "select * from Employee";

        List<Employee> employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>()
        {
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Employee> list = new ArrayList<Employee>();
                while (rs.next())
                {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt(1));
                    employee.setName(rs.getString(2));
                    employee.setAddress(rs.getString(3));
                   // employee.setName(rs.getString(4));
                    list.add(employee);
                }
                return list;
            }

        });
        return employeeList;
    }

    // Updating a particular Employee
    public void updateEmployee(Employee employee)
    {
        String sql = "update Employee set  address=?,name=? where id=?";
        jdbcTemplate.update(sql, new Object[]
        {  employee.getAddress(),employee.getName(),employee.getId() });
    }

    // Deletion of a particular Employee
    public void deleteEmployee(int id)
    {
        String sql = "delete employee where id=?";
        jdbcTemplate.update(sql, new Object[]
        { id });
    }

	@Override
	public List<Employee> getAllEmployees(EmployeeRowMapper rowMapper) {
		String sql="SELECT * FROM EMPLOYEE";
		List<Employee> listOfAllEmployees=jdbcTemplate.query(sql, rowMapper);
		return listOfAllEmployees;
	}

	@Override
	public String getEmployeeNameById(int id) {
		    String sql = "select name from Employee where id=?";
		        String  employeeName =  jdbcTemplate.queryForObject(sql,  new Object[] { id }, String.class);//(sql, new SinleRowSingleColumnMapper<String>());
		       return employeeName;
	}
	
	
	//public
}
