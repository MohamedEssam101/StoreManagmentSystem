/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package store.mangament.system;

import java.util.ArrayList;

/**
 *
 * @author utd
 */
public class Store {

    private String name;
    ArrayList<Product> products;
    ArrayList<Customer> customers;
    ArrayList<Employee> employees;

    public Store() {
        this.name = null;
        products = new ArrayList<Product>();
        customers = new ArrayList<Customer>();
        employees = new ArrayList<Employee>();
    }

    public Store(String name) {
        this.name = name;
        products = new ArrayList<Product>();
        customers = new ArrayList<Customer>();
        employees = new ArrayList<Employee>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }
    public boolean isExist(String ProductName){
        for(int i = 0; i < products.size(); i++){
            if(ProductName.equals(products.get(i).getProductName()))
                return true;
        }
        return false;
    }
    public void AddProduct(Product NewProduct) {
        if(products.size() == 100)
            System.out.println("the Store is Full!!");
        else
            products.add(NewProduct);
    }
    public void RemoveProduct(String ProductName) {
        if(products.isEmpty())
            System.out.println("the Store is Empty !!");
        else{
            if(isExist(ProductName)) {
            for(int i  = 0; i < products.size(); i++){
                if(ProductName.equals(products.get(i).getProductName()));
                    products.remove(i);
            }
                }
        
            else {
                System.out.println("This Product Doesn't Exists !! ");
                }
            }    
    }
    public void totalPrice(int CustomerID) {
        double total = 0.0;
        double discount = 0.0;
        for (int i = 0; i < customers.size(); i++) {
            if(CustomerID == customers.get(i).getID()){
                total += customers.get(i).getPurchased();
            }
            if(customers.get(i).isSpecialCustomer()){
                discount = total * (0.25);
                total -= discount;
            }
            
        }
        System.out.printf("Discount: %.2f EGP .\n",discount);
        System.out.printf("Total Price: %.2f EGP.\n",total);
    }
    public void buy(int CustomerID){
        for (int i = 0; i < customers.size(); i++) {
            if(CustomerID == customers.get(i).getID()){
                for (int j = 0; j < customers.get(i).purchased.size(); j++) {
                    RemoveProduct(customers.get(i).purchased.get(j).getProductName());
                    
                }
            }
            
        }
        
    }
   public void PrintProducts() {
       for (int i = 0; i < products.size(); i++) {
           System.out.println(products.get(i).toString());
       }
   }
   public void PrintCustomers() {
       for (int i = 0; i < customers.size(); i++) {
           System.out.println(customers.get(i).toString());
       }
   }
   public  void PrintEmployee() {
       for (int i = 0; i < employees.size(); i++) { 
           System.out.println(employees.get(i).toString());  
       }
   }
   public void IncreaseSalary(double percent) {
       for (int i = 0; i < employees.size(); i++) {
           employees.get(i).setNewSalary(percent);
           
       }
   }
   public boolean CheckManager(int ID) {
    boolean status = false;
       for (int i = 0; i < employees.size(); i++) {
            if(ID == employees.get(i).getID()){
                if (employees.get(i).isManager()) {
                    status = true;
            
                }
            }
           
       }
       return status;
   }
   public void PrintSpecialProduct() {
       System.out.println("(In IT) the List of special products");
       for (int i = 0; i < products.size(); i++) {
           if ("IT".equals(products.get(i).getProductKind())) {
               System.out.println(products.get(i).toString());
           }
           
       }
   }
}
    