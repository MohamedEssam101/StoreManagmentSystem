/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package store.mangament.system;

/**
 *
 * @author utd
 */
public class Product {

    private String ProductName;
    private double Price;
    static int ID_start = 0;
    private int ID;
    private String ProductKind;

    public Product() {
        this.ProductName = null;
        this.Price = 0.0;
        this.ProductKind = null;
        setID();
    }
    public Product(String ProductN, double price, String ProductK){
        this.ProductName = ProductN;
        this.Price = price;
        this.ProductKind = ProductK;
        setID();
    }

    public String getProductName() {
        return ProductName;
    }
    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getID() {
        return ID;
    }
    public void setID() {
        this.ID = ID_start++ ;
    }

    /**
     * @return the ProductKind
     */
    public String getProductKind() {
        return ProductKind;
    }

    /**
     * @param ProductKind the ProductKind to set
     */
    public void setProductKind(String ProductKind) {
        this.ProductKind = ProductKind;
    }
    @Override
     public String toString(){
        return    "product: "+getID()+" ("+getProductName()+") "+"cost: "+getPrice()+" EGP." ;
     }
}
