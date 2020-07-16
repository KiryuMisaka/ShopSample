package jp.co.illmatics.apps.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TEST_ADMIN_USERS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "email", "password" })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", length = 60, nullable = false)
	private String name;
	@Column(name = "email", length = 120, nullable = false, unique = true)
	private String email;
	@Column(name = "password", length = 120, nullable = false)
	private String password;
	@Column(name = "is_owner", length = 120)
	private String roles;
	@Column(name = "enable_flag", nullable = false)
	private Boolean enable;
	
	public User(Object object, String name, String email, String password, String roles, Boolean enable) {
		// TODO 自動生成されたコンストラクター・スタブ???
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}