package com.example.accessingdatamysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//RowMapper implementation
public class PaymentTableRowMapper implements RowMapper<SalaryExporter> {
	@Override
	public SalaryExporter mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		SalaryExporter salExporter = new SalaryExporter();
		System.out.println("resultSet.getInt(\"emp_id\") is : " + resultSet.getInt("emp_id"));
		salExporter.setEmployeeID(resultSet.getInt("emp_id"));
		salExporter.setTds(resultSet.getInt("tds"));

		return salExporter;
	}
}