package com.cg.application1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.cg.application1.dto.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public Employee save(Employee emp) {
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement("INSERT INTO EMPLOYEE(name,age) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, emp.getName());
				ps.setInt(2, emp.getAge());
				return ps;
			}
		}, holder);

		int newUserId = holder.getKey().intValue();
		emp.setId( newUserId);
		return emp;
	}
		
	@Override
	public Employee findById(long id) {
		String query="SELECT * FROM employee WHERE id=?";
		return jdbcTemplate.queryForObject(query,new Object[] {id},new EmployeeRowMapper());
	}

	@Override
	public List<Employee> findAll() {
		String query="SELECT * FROM employee";
		return jdbcTemplate.query(query,new EmployeeRowMapper());
	}

}
