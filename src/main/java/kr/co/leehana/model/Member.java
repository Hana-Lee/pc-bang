package kr.co.leehana.model;

import lombok.Data;

/**
 * @author Hana Lee
 * @since 2015-11-13 13-52
 */
@Data
public class Member {
	private long id;
	private int num;
	private String userId;
	private String password;
	private int mileage;
	private String fullName;
	private int age;
	private String phone;
}