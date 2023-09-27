package com.example.accessingdatamysql;

import java.util.Calendar;
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

	public List<Long> executeQuery(int i, int month, int year, String reqTable) {
		String sql = "select id from " + reqTable + " t where t.emp_id=" + i + " AND month_number=" + month
				+ " AND year_number=" + year;
		// String sql = "select id from payments_table t where t.emp_id=" + i + " AND
		// month_number=" + month + " AND year_number=" + year;
		System.out.println("sql query is : " + sql);

		return jdbcTemplate.queryForList(sql, Long.class);
	}

	public List<Long> leavesQuery(int id, int month, int year, String reqTable) {
		System.out.println("QueryService | id is : " + id);
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		int lastDayOfMonth = calendar.getActualMaximum(Calendar.DATE);
		int startDayOfMonth = calendar.getActualMinimum(Calendar.DATE);

		String startDate = year + "-" + month + "-" + Integer.toString(startDayOfMonth);
		String endDate = year + "-" + month + "-" + Integer.toString(lastDayOfMonth);

		String sql = "SELECT id FROM " + reqTable + "  WHERE emp_id = " + id + " AND ((leave_from_date between '"
				+ startDate + "' AND '" + endDate + "') OR (leave_to_date between '" + startDate + "' AND '" + endDate
				+ "'));";

		System.out.println("sql 22 query is : " + sql);

		return jdbcTemplate.queryForList(sql, Long.class);
	}
}
