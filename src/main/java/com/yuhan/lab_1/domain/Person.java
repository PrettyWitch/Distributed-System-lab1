package com.yuhan.lab_1.domain;


import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

/**
 * @author yuhan
 * @date 02.10.2020 - 18:36
 * @purpose entity of peron
 */
@Entity
@Table(name = "person")
public class Person {

   //@javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, nullable = false)
    @Id
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private int age;

    @Column
    @NotNull
    private String address;

    @Column
    @NotNull
    private String work;

    public Person() {
    }

    public Person(String name, int age, String address, String work) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.work = work;
    }

    public Person(Integer id, String name, int age, String address, String work) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.work = work;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", work='" + work + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
