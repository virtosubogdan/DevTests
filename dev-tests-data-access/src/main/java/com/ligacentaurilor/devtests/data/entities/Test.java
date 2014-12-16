package com.ligacentaurilor.devtests.data.entities;

import javax.persistence.*;

/**
 *
 */
@Entity(name = "TESTS")
public class Test {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(length = 4000)
    private String name;

    @Column(length = 4000)
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
