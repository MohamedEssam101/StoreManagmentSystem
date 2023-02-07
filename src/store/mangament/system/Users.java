/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package store.mangament.system;

/**
 *
 * @author utd
 */
public class Users {

    String name;
    protected static int ID_start = 1000; // static number starting from it
    protected int ID;
    public Users(){
    this.name = null;  //
}
    public Users (String name ){
        this.name = name;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID() {
       ID = ID_start++;
    }
    
}
