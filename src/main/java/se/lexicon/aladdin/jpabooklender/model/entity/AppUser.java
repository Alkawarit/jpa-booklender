package se.lexicon.aladdin.jpabooklender.model.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static se.lexicon.aladdin.jpabooklender.model.constants.EntityConstants.GENERATOR;
import static se.lexicon.aladdin.jpabooklender.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String id;
@Column(length = 100, unique = true)
    private String username;
    private String password;

    @ManyToMany(
            cascade = {CascadeType.DETACH, CascadeType.DETACH},
            fetch = FetchType.LAZY,
            mappedBy = "appUsers"
    )
    private Set<AppRole> roles;

    public AppUser() {
    }

    public AppUser(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AppRole> getRoles() {
        if(roles == null) roles = new HashSet<>();
        return roles;
    }

    public void setRoles(Set<AppRole> roles) {
        if(roles == null) roles = new HashSet<>();
        if(roles.isEmpty()) {
            if (this.roles != null) {
                this.roles.forEach(appRole -> appRole.getAppUsers().remove(this));
            }
            } else {
                roles.forEach(appRole -> appRole.getAppUsers().add(this));
            }

        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id) && Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
