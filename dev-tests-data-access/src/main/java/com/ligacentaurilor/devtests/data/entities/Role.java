package com.ligacentaurilor.devtests.data.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 */
@Entity
public class Role {

    public static enum Authority {ROLE_USER, ROLE_ADMIN}

    @EmbeddedId
    private RolePK embeddedId;

    public RolePK getEmbeddedId() {
        return embeddedId;
    }

    public void setEmbeddedId(RolePK embeddedId) {
        this.embeddedId = embeddedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (embeddedId != null ? !embeddedId.equals(role.embeddedId) : role.embeddedId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return embeddedId != null ? embeddedId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "embeddedId=" + embeddedId +
                '}';
    }
}

