package org.postuniv.serviceAuto.domain;


import java.time.LocalDate;


public class ClientCard implements Entity{

    //the ID is unique
    private int id;
    private String firstName;
    private String lastName;
    private String CNP;
    private LocalDate birthDate;
    private LocalDate registrationDate;

    public ClientCard(int id, String firstName, String lastName, String CNP, LocalDate birthDate, LocalDate registrationDate) {
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


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "ClientCard{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", birthDate=" + birthDate +
                ", registrationDate=" + registrationDate +
                '}';
    }
}