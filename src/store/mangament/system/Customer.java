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
public class Customer  extends Users{
    private int nums_visits;
    
    private boolean special_cust;
    public ArrayList<Product> purchased;
    
    public Customer(){
        super.setName(null); // inherting from Class Users
        super.setID();
        this.nums_visits = 0;
        purchased = new ArrayList<>();
    }
    public Customer(String name) {
        super(name); // inherting from Class Users
        super.setID();
        this.nums_visits = 0;
        this.special_cust = false;
        purchased = new ArrayList<>();
    }
     @Override
    public String getName(){
        return super.name;
    }
    public int getID(){
        return super.ID;
    }
    public int getNums_visits() {
        return nums_visits;
    }
    public void setNums_visits() {
        nums_visits++;
    }
    public boolean isSpecialCustomer() {
        if(nums_visits > 2){
            this.special_cust = true;
        }
        return this.special_cust;
    }
    public String getTypeofCustomer(){
        if(isSpecialCustomer()){
            return "special Customer";
        }
        return "new customer";
    }
    public void  addPurchased(Product new_purchased) {
        
        purchased.add(new_purchased);
    }
    public double getPurchased() {
    
    double total = 0;
    for(int i = 0; i < purchased.size(); i++){
        System.out.println(purchased.get(i).toString());
        total += purchased.get(i).getPrice();   
    }
    return total;
    }
    
    @Override
    public String toString(){
            return getTypeofCustomer()+ ": "+getName()+" ("+getID()+") "+"visits"+getNums_visits()+" time(s).";
    }
}
