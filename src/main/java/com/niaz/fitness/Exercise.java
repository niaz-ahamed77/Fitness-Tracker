package com.niaz.fitness;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Exercises")

public class Exercise {
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ElementCollection
    @Column(name = "tags") // why not just private List<String> Tags; ?
    private List<String> tags = new ArrayList<>();

    @ElementCollection
    @Column(name = "links")
    private List<String> links = new ArrayList<>(); // tutorials, video demos, articles, etc


    //Constructors
    Exercise(){

    }
    
    Exercise(String name){
        this.name = name;
    }

    public void addTag(){

    }

    //Getters
    public String getName(){
        return name;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}
