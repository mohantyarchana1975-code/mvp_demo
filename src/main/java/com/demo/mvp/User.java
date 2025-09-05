package com.demo.mvp;

import jakarta.persistence.*;

@Entity
@Table(name = "users") 
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password; // demo only
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String token;

    public User() {}

    public User(String username, String password, String name, Role role, String token) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.token = token;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public Role getRole() { return role; }
    public String getToken() { return token; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String v) { this.username = v; }
    public void setPassword(String v) { this.password = v; }
    public void setName(String v) { this.name = v; }
    public void setRole(Role v) { this.role = v; }
    public void setToken(String v) { this.token = v; }
}
