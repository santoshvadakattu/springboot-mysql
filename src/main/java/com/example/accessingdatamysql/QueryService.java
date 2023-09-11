package com.example.accessingdatamysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Autowired
	public void MyService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Long> executeQuery(int i, int month, int year) {
		String sql = "select id from payments_table t where t.emp_id=" + i + " AND month_number=" + month
				+ " AND year_number=" + year;

		return jdbcTemplate.queryForList(sql, Long.class);
	}
}
