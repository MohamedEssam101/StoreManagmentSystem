/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package store.mangament.system;
import java.util.Scanner;
/**
 *
 * @author utd
 */
public class StoreManagmentSystem {
    public static void main(String[] args){
        Store MyStore = new Store ("Happy Store");
        System.out.printf("         Wlecome in %s !!!\n",MyStore.getName());
        System.out.println("++++++++ Select Operation from Menu +++++++++++++");
      try {
          Scanner   input = new Scanner(System.in);
        int choice  = 0;
            do {
              System.out.println("1- Products Management"); // add - remove - browser
                System.out.println("2- Users Management"); // add customer - add employee - edit salary
                System.out.println("3- Buy Product"); // ask id of customer and ask for pruduct want to buy , wrong or right
                System.out.println("4- Show Special Products"); // auto show
                System.out.println("5- Exit"); 
                System.out.print(">>>");
                choice = input.nextInt();
                switch(choice) {
                    case 1:
                        int S1 = 0;
                        do{
                        System.out.println("++++++++++ Products Management ++++++++++ ");
                            System.out.println("1- Add Product");
                            System.out.println("2- Remove Products"); // ask for user id , if manager can remove
                            System.out.println("3- Print Products");
                            System.out.println("4- Back to main menu");
                            System.out.print(">>>");
                            S1 = input.nextInt();
                        switch (S1) {
                            case 1:
                                System.out.print("product name: ");
                                String ProductNames = input.next();
                                System.out.print("Product Price: ");
                                double PPrice = input.nextDouble();
                                System.out.print("Product Kind: ");
                                String SpecialProduct = input.next();
                                Product NewProduct = new Product(ProductNames,PPrice,SpecialProduct);
                                MyStore.AddProduct(NewProduct);
                                break;                      
                            case 2:
                                System.out.print("Enter Employee ID: ");
                                    int id = input.nextInt();
                                    if(MyStore.CheckManager(id)) {
                                        System.out.print("enter Product Name: ");;
                                        ProductNames = input.next();
                                        MyStore.RemoveProduct(ProductNames);
                                        System.out.println("Product Has Been Removed !");
                                        
                                    }
                                    else{
                                        System.out.println("Its An Employee Not Manager,Product Cannot Be Removed");
                                    }
                                    break;
                            case 3:
                                if(MyStore.products.isEmpty()) {
                                    System.out.println("Store is Empty");
                                }
                                else {
                                    System.out.println("Products in Store");
                                    MyStore.PrintProducts();
                                }
                                break;
                        }
                        }while(S1 != 4);
                    
                        case 2:
                        int S2 = 0;
                        do {
                            System.out.println("++++++++++ Users Management ++++++++++ ");
                            System.out.println("1- Add Customer");
                            System.out.println("2- Add Employee");
                            System.out.println("3- Update Employee");// increase all salarys
                            System.out.println("4- Print Users");
                            System.out.println("5- Back to main menu");
                            System.out.print(">>>");
                            S2 = input.nextInt();
                        switch(S2){
                            case 1:
                                System.out.print("Customer name: ");
                                String CustomerName = input.next();
                                Customer NewCustomer = new Customer(CustomerName);
                                MyStore.customers.add(NewCustomer);
                                break;
                            case 2:
                                System.out.print("Employee Name: ");
                                String EmployeeName = input.next();
                                System.out.print("Empolyee Salary : ");
                                double ESalary = input.nextDouble();
                                System.out.print("Is He a Manager ? (1:yes) ,(2.No)");
                                int choice2 = input.nextInt();
                                String EmployeeType;
                                if (choice2 == 1) {
                                    EmployeeType = "Manager";
                                 }
                                else {
                                    EmployeeType = null;
                                }
                                Employee NewEmployee = new Employee(EmployeeName, ESalary, EmployeeType);
                                MyStore.employees.add(NewEmployee);
                                break;
                            case 3:
                                System.out.print("increasing Salary %: ");    
                                double percent = input.nextDouble();
                                MyStore.IncreaseSalary(percent);
                                break;
                            case 4:
                                if((MyStore.customers.isEmpty()) 
                                    && (MyStore.employees.isEmpty()))
                                    System.out.println("No Users");
                                else {
                                    System.out.println("List of Users");
                                    MyStore.PrintCustomers();
                                    MyStore.PrintEmployee();
                                }
                                break;
                                
                        }
                        
                        }while (S2 != 5);
                        
                        
                        break;
                    case 3:
                        int S3 = 0;
                        int n = 0;
                        System.out.println("Enter Customer id:");
                        int CustomerId = input.nextInt();
                        for (int i = 0; i < MyStore.customers.size(); i++) {
                            if (CustomerId == MyStore.customers.get(i).getID()) {
                                System.out.println(MyStore.customers.get(i).toString());
                                while(S3 != 1){
                                    System.out.println("Enter ID of Product: ");
                                    int ProductId = input.nextInt();
                                    for (int j = 0; j < MyStore.products.size(); j++) {
                                        if(ProductId == MyStore.products.get(j).getID()){
                                        System.out.println(MyStore.products.get(j).toString());
                                       MyStore.customers.get(i).addPurchased(MyStore.products.get(j));
                                       n = i;
                                       break;
                                    }
                                    else if(ProductId != MyStore.products.get(j).getID()){
                                            System.out.println("Product Not Found");
                                            break;
                                            }           
                                }
                                    System.out.print("enter 0 to add another product or -1 when finish:");
                                    S3=input.nextInt();
                            }
                            
                        }
                            
                    }
                        System.out.printf("%s : %s \n",MyStore.customers.get(n).getTypeofCustomer(),MyStore.customers.get(n).getName());
                        System.out.println("Bought : ");
                        MyStore.totalPrice(CustomerId);
                        MyStore.buy(CustomerId);
                        MyStore.customers.get(n).setNums_visits();
                        MyStore.customers.get(n).purchased.clear();
                        break;
                    case 4:
                        System.out.println("++++++++++ Special Product ++++++++++ ");
                        MyStore.PrintSpecialProduct();
                        break;
                }
                System.out.println("-----------------------");
            }while (choice !=5);
      }catch (Exception e) {
          System.out.println("Invalid Input");
      }
        System.out.println("Good Bye");
    }
}
