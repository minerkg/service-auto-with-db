package org.postuniv.serviceAuto.domain;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDateTime;

public class Transaction {

    private long transactionId;
    private int carId;
    private int clientCardId;
    private double partPrice; //TODO: atirni camel case re
    private double laborPrice;
    private  LocalDateTime transactionStamp;

    //Transaction with client card where labour price has a 10% discount.
    public Transaction(long transactionId, int carId, int clientCardId, double partPrice, double laborPrice, LocalDateTime transactionStamp) {
        this.transactionId = transactionId;
        this.carId = carId;
        this.clientCardId = clientCardId;
        this.partPrice = partPrice;
        setLaborPrice(laborPrice);
        this.transactionStamp = transactionStamp;
    }
    // Transaction without client card.
    public Transaction(long transactionId, int carId, double partPrice, double laborPrice, LocalDateTime transactionStamp) {
        this.transactionId = transactionId;
        this.carId = carId;
        this.clientCardId = 0;
        this.partPrice = partPrice;
        this.laborPrice = laborPrice;
        this.transactionStamp = transactionStamp;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Integer getClientCardId() {
        return clientCardId;
    }

    public void setClientCardId(int clientCardId) {
        if (clientCardId > 0) {
            this.clientCardId = clientCardId;
        } else this.clientCardId = 0;

    }

    public double getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(double partPrice) {
        this.partPrice = partPrice;
    }

    public double getLaborPrice() {
        return laborPrice;
    }

    public final void setLaborPrice(double laborPrice) {
        if (this.clientCardId == 0) {
            this.laborPrice = laborPrice;
        }else {
            double discount = (laborPrice *10)/100;
            this.laborPrice = laborPrice -discount;
        }
    }

    public LocalDateTime getTransactionStamp() {
        return transactionStamp;
    }


    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setRoundingMode(RoundingMode.UP);
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", car_id=" + carId +
                ", client_card_id=" + clientCardId +
                ", part_price=" + partPrice +
                ", labor_price=" + nf.format(laborPrice) +
                ", transaction_stamp=" + transactionStamp +
                '}';
    }
}
