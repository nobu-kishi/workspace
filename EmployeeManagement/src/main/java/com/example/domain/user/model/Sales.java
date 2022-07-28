package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class Sales {
	private Integer employeeId;
	private String area;
	private Integer profit;
	private Integer customer;
	private Date updateTime;
}
