package com.example.springbootform.model;

import org.springframework.security.core.GrantedAuthority;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Role implements GrantedAuthority {

    @Id
    private final String id;

    @Column
    private String authority;

    public Role (String authority) {
        this.id = UUID.randomUUID().toString();
        this.authority = authority;
    }

    public Role() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
