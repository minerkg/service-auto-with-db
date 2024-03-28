package org.postuniv.serviceAuto.domain;

import java.time.LocalDate;
import java.util.Calendar;

public class Car {
    private int id;
    private String model;
    private LocalDate yearOfAquisition;
    private int km;
    private boolean warranty;

    public Car() {
    }

    public Car(int id, String model, LocalDate localDate, int km, boolean warranty) {
        this.id = id;
        this.model = model;
        setYearOfAquisition(localDate);
        this.km = km;
        this.warranty = warranty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYearOfAquisition() {
        return yearOfAquisition;
    }

    public final void setYearOfAquisition(LocalDate yearOfAquisition) {

        if (yearOfAquisition.isAfter(LocalDate.now())) {
           throw new RuntimeException("Year of acquisition can not be in the future"); //TODO: handle exception
        }
        this.yearOfAquisition=yearOfAquisition;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean getWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return "Car " +
                "ID[" + id +
                "], model=" + model +
                ", yearOfAquisition=" + yearOfAquisition +
                ", km= " + km +
                ", warranty=" + warranty +
                '}';
    }
}
