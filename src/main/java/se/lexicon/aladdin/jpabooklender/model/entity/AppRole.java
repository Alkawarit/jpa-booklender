package se.lexicon.aladdin.jpabooklender.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static se.lexicon.aladdin.jpabooklender.model.constants.EntityConstants.GENERATOR;
import static se.lexicon.aladdin.jpabooklender.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class AppRole {
    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR,strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String id;
    @Column(unique = true)
    private String userRole;

@ManyToMany(
        cascade = {CascadeType.DETACH,CascadeType.REFRESH},
        fetch = FetchType.LAZY
)
@JoinTable(
        name = "role_app_user",
        joinColumns = @JoinColumn(name = "fk_app_role_id", table = "role_app_user"),
        inverseJoinColumns = @JoinColumn(name = "fk_app_user_id", table = "role_app_user")
)
    private Set<AppUser> appUsers;

    public AppRole() {
    }

    public AppRole(String id, String userRole) {
        this.id = id;
        this.userRole = userRole;
    }

    public Set<AppUser> getAppUsers() {
        if(appUsers == null) appUsers = new HashSet<>();
        return appUsers;
    }

    public void setAppUsers(Set<AppUser> appUsers) {
        if(appUsers == null) appUsers = new HashSet<>();
        if(appUsers.isEmpty()) {
            if (this.appUsers != null) {
                this.appUsers.forEach(appUser -> appUser.getRoles().remove(this));
            }
        }else{
            appUsers.forEach(appUser -> appUser.getRoles().add(this));
        }
        this.appUsers = appUsers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppRole appRole = (AppRole) o;
        return Objects.equals(id, appRole.id) && Objects.equals(userRole, appRole.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userRole);
    }

    @Override
    public String toString() {
        return "AppRole{" +
                "id='" + id + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
