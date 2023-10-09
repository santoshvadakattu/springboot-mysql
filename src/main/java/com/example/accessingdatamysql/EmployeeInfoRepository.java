package com.example.accessingdatamysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeInfoRepository {
	public interface EmployeeInfo extends JpaRepository<EmployeeInfo, Long> {

	}

	}

