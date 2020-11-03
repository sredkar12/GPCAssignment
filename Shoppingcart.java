package com.in28minutes.springboot.machineservices;

public class Shoppingcart {
    private int id;

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    private int quantity;
    private String itemname;
    private double itemprice;
    private double saletax;
    private double importsalestax;
    private double itemtotalsalestax ;
    private double itemtotalcost ;

    public Shoppingcart(int q, String itemname, double itemprice, double saletax, double importsalestax) {
        this.quantity = q;
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.saletax = saletax;
        this.importsalestax = importsalestax;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getItemprice() {
        return itemprice;
    }

    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }

    public double getSaletax() {
        return saletax;
    }

    public void setSaletax(double saletax) {
        this.saletax = saletax;
    }

    public double getImportsalestax() {
        return importsalestax;
    }

    public void setImportsalestax(double importsalestax) {
        this.importsalestax = importsalestax;
    }
    public double getItemtotalsalestax() {
        double totalsalestax = this.importsalestax + this.saletax;
        double totalprice = this.quantity * this.itemprice;
        double totaltax = totalprice * totalsalestax;
        double roundedtax =  round05(totaltax);
        return roundedtax;
    }


    public double getItemtotalcost() {
        double cost = quantity * itemprice ;
        this.itemtotalcost = cost + getItemtotalsalestax() ;
        return this.itemtotalcost;
    }

    public double round05(double num) {
        return Math.round(num * 20) / 20.0;
    }
}
