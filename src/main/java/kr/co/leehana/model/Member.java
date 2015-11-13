package kr.co.leehana.model;

import lombok.Data;

/**
 * @author Hana Lee
 * @since 2015-11-13 13-52
 */
@Data
public class Member {
	private int num;
	private String id;
	private String password;
	private int age;
	private int mileage;
	private String phone;
}