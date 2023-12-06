package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "member")
public class MemberRegisterForm implements Serializable {
	private static final long serialVersionUID = 1430727612761896709L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long mem_id;

	@NotBlank
	@Size(max = 10)
	private String mem_name;
	
	@NotBlank
	@Size(max = 3)
	private String age;
	
	@NotBlank
	@Size(max = 10)
	private String sex;

	@NotBlank
	@Email
	private String mail;

	@NotBlank
	@Size(max = 400)
	private String content;
	
//	@NotBlank
//	@Size(max = 3)
//	private String update_no;
//	
//	@NotBlank
//	@Size(max = 3)
//	private String delete_no;
	
	public void clear() {
		mem_name = null;
		age = null;
		sex = null;
		mail = null;
		content = null;
	}
}
