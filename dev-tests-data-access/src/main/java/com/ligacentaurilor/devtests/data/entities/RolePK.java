package com.ligacentaurilor.devtests.data.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Embeddable
public class RolePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "USERID")
    private User user;

    @Enumerated(EnumType.STRING)
    private Role.Authority authority;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role.Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Role.Authority authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePK rolePK = (RolePK) o;

        if (authority != rolePK.authority) return false;
        if (user != null ? !user.equals(rolePK.user) : rolePK.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RolePK{" +
                "user=" + user +
                ", authority=" + authority +
                '}';
    }
}
