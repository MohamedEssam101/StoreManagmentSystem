/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package store.mangament.system;

/**
 *
 * @author utd
 */
public class Employee  extends Users{
    private double salary;
    private String typeOfEmployee;
    
    public Employee(){
        super.setName(null);
        super.getID();
        this.salary = 0.0;
        this.typeOfEmployee = null;
    }
    public Employee(String name ,double salary, String TOE){
        super(name);
        super.setID();
        this.typeOfEmployee = TOE;
        this.salary = salary; 
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public int getID(){
            return super.ID;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return the typeOfEmployee
     */
    public String getTypeOfEmployee() {
        return typeOfEmployee;
    }

    /**
     * @param typeOfEmployee the typeOfEmployee to set
     */
    public void setTypeOfEmployee(String typeOfEmployee) {
        this.typeOfEmployee = typeOfEmployee;
    }
    
    public  void setNewSalary(double percent) {
        double increment = salary * percent;
        this.salary += increment;
    }
    
    public boolean isManager() {
        boolean type = false;
        if(typeOfEmployee.equals("Manager")){
            type = true;
        }
        return type;
    }
    @Override
    public String toString(){
     return "Employee:"+"("+getTypeOfEmployee()+")"+getName()+" "+"("+getID()+")"+" has "+getSalary()+" RS.";
    }
}
