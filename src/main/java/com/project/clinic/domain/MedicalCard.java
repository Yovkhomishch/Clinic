package com.project.clinic.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "medcard")
public class MedicalCard {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String diagnosis;
    private String anamnesis;
    private String treatment;
    private float temperature;
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id")
    private Worker worker;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id")
    private Animal animal;


    public MedicalCard(String diagnosis, String anamnesis, String treatment, float temperature, Date date, Worker worker, Animal animal) {
        this.diagnosis = diagnosis;
        this.anamnesis = anamnesis;
        this.treatment = treatment;
        this.temperature = temperature;
        this.date = date;
        this.worker = worker;
        this.animal = animal;
    }

    public MedicalCard() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public Worker getWorkers() {
        return worker;
    }

    public void setWorkers(Worker workers) {
        this.worker = worker;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}

