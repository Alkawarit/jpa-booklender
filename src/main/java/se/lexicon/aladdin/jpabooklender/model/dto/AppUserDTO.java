package se.lexicon.aladdin.jpabooklender.model.dto;

import se.lexicon.aladdin.jpabooklender.model.entity.AppRole;

import java.io.Serializable;
import java.util.Set;

public class AppUserDTO implements Serializable {

    private String id;
    private String username;
    private Set<AppRole> roles;

    public AppUserDTO(String id, String username, Set<AppRole> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public AppUserDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRole> roles) {
        this.roles = roles;
    }
}
