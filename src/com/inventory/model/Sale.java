package com.inventory.model;

import java.sql.Date;

public class Sale{

    private int saleId;
    private int productId;
    private int quantitySold;
    private Date saleDate;
    private double totalAmount;

    public Sale(int saleId, int productId,
                int quantitySold,
                Date saleDate,
                double totalAmount) {

        this.saleId = saleId;
        this.productId = productId;
        this.quantitySold = quantitySold;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }

    public int getSaleId() {
        return saleId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}