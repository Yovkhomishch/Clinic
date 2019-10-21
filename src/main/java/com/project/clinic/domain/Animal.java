package com.project.clinic.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "anim")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private Owner owner;
    private String name;
    private int age;
    private String spicies;
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MedicalCard> medicalCards;


    public Animal(Owner owner, String name, int age, String spicies) {
        this.owner = owner;
        this.name = name;
        this.age = age;
        this.spicies = spicies;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpicies() {
        return spicies;
    }

    public void setSpicies(String spicies) {
        this.spicies = spicies;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Set<MedicalCard> getMedicalCards() {
        return medicalCards;
    }

    public void setMedicalCards(Set<MedicalCard> medicalCards) {
        this.medicalCards = medicalCards;
    }
}
