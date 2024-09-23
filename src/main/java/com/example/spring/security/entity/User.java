package com.example.spring.security.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "users")
public class User implements UserDetails {

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column(nullable = false)
    private String password;

    @Column
    private String email;

    @Column
    private Boolean enabled = false;

    @Column
    private Boolean locked = false;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public User(String name, String email, String password, UserRole userRole) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
