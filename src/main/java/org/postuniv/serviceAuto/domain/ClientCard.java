package org.postuniv.serviceAuto.domain;


import java.util.Date;

public class ClientCard {

    //the ID is unique
    private int id;
    private String firstName;
    private String lastName;
    private String CNP;
    private Date birthDate;
    private Date registrationDate;

    public ClientCard(int id, String firstName, String lastName, String CNP, Date birthDate, Date registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.CNP = CNP;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

}