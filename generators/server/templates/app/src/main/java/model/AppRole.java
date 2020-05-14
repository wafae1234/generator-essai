package ma.dxc.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class AppRole {
	@Id @GeneratedValue
	private Long id;
	private String roleName;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Permission> permissions = new ArrayList<>();
	public AppRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppRole(Long id, String roleName, Collection<Permission> permissions) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.permissions = permissions;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Collection<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Collection<Permission> permissions) {
		this.permissions = permissions;
	}
	
}

