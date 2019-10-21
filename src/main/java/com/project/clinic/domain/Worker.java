package com.project.clinic.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "wkr")
public class Worker implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String login;
    private String password;
    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "workers_role", joinColumns = @JoinColumn(name = "workers_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
    @ManyToMany(mappedBy = "worker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MedicalCard> medicalCards;

    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<MedicalCard> getMedicalCards() {
        return medicalCards;
    }

    public void setMedicalCards(Set<MedicalCard> medicalCards) {
        this.medicalCards = medicalCards;
    }
}
