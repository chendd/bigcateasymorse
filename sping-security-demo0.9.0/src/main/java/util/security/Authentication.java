package util.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;

/**
 * 认证对象。
 * 
 * 用于实现认证所需的属性和行为。供Spring Security使用。
 * 
 * @author Marshal Wu <a
 *         href="mailto:marshal.wu@gmail.com">marshal.wu@gmail.com</a>
 * 
 */
@Entity
@Table(name = "authentications")
public class Authentication implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "user_name", unique = true)
	private String username;
	@Column
	private String password;
	@Column
	private boolean accountNonExpired;
	@Column
	private boolean accountNonLocked;
	@Column
	private boolean enabled;
	@Column
	private String name;
	@Column
	private String dmpt;
	@Column
	private Date createTime;
	@Column
	private boolean credentialsNonExpired;
	@Column
	private String notes;

	@ManyToMany(targetEntity = Role.class)
	@JoinTable(name = "auth_roles")
	private Set<Role> roles;

	@Override
	public GrantedAuthority[] getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(
				roles.size());
		for (Role role : roles) {
			grantedAuthorities.add(new GrantedAuthorityImpl(role.getName()));
		}
		return grantedAuthorities.toArray(new GrantedAuthority[roles.size()]);
	}

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getDmpt() {
		return dmpt;
	}

	public void setDmpt(String dmpt) {
		this.dmpt = dmpt;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setDepartment(String dmpt) {
		this.dmpt = dmpt;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
