package com.space.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="aboutMe")
public class AboutMe {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
    
    @Column(name="age")
	Integer age;
    @Column(name="firstName")
	String firstName;
    @Column(name="lastName")
	String lastName;
    @Column(name="bio", unique = true)
	String bio;
    
    public AboutMe(Integer age, String firstName, String lastName, String bio) {
        super();
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AboutMe [id=" + id + ", age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + ", bio="
                + bio + "]";
    }
    
}
