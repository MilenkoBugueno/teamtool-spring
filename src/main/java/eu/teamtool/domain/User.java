package eu.teamtool.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document(collection = "User")
public class User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7206798553934461899L;

	@Id
    private Long id;

    @NotNull
    @Size(min = 1, max = 20)
    private String username;

    @NotNull
    @Size(min = 4, max = 8)
    private String password;
    
    private Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();

	@Override
	public Collection<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
