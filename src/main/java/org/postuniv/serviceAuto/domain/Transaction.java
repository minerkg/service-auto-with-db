package org.postuniv.serviceAuto.domain;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {

    private long transactionId;
    private int car_id;
    private int client_card_id;
    private double part_price;
    private double labor_price;
    private  LocalDateTime transaction_stamp;

    //Transaction with client card where labour price has a 10% discount.
    public Transaction(long transactionId, int car_id, int client_card_id, double part_price, double labor_price, LocalDateTime transaction_stamp) {
        this.transactionId = transactionId;
        this.car_id = car_id;
        this.client_card_id=client_card_id;
        this.part_price = part_price;
        setLabor_price(labor_price);
        this.transaction_stamp = transaction_stamp;
    }
    // Transaction without client card.
    public Transaction(long transactionId, int car_id, double part_price, double labor_price, LocalDateTime transaction_stamp) {
        this.transactionId = transactionId;
        this.car_id = car_id;
        this.client_card_id = 0;
        this.part_price = part_price;
        this.labor_price = labor_price;
        this.transaction_stamp = transaction_stamp;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public Integer getClient_card_id() {
        return client_card_id;
    }

    public void setClient_card_id(int client_card_id) {
        if (client_card_id > 0) {
            this.client_card_id = client_card_id;
        } else this.client_card_id = 0;

    }

    public double getPart_price() {
        return part_price;
    }

    public void setPart_price(double part_price) {
        this.part_price = part_price;
    }

    public double getLabor_price() {
        return labor_price;
    }

    public final void setLabor_price(double labor_price) {
        if (this.client_card_id == 0) {
            this.labor_price = labor_price;
        }else {
            double discount = (labor_price*10)/100;
            this.labor_price = labor_price-discount;
        }
    }

    public LocalDateTime getTransaction_stamp() {
        return transaction_stamp;
    }


    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setRoundingMode(RoundingMode.UP);
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", car_id=" + car_id +
                ", client_card_id=" + client_card_id +
                ", part_price=" + part_price +
                ", labor_price=" + nf.format(labor_price) +
                ", transaction_stamp=" + transaction_stamp +
                '}';
    }
}
