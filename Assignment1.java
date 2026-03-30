package com.anudip.project.lab1;
import java.util.Scanner;

class Vehicle{
	String make;
	String model;
	int year;
	int maximumspeed;
	
	public Vehicle(String make, String model, int year, int maximumspeed ) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.maximumspeed = maximumspeed;
	}
	public void drive() {
		System.out.println("the vehicle is driving");
	}
}
class Car extends Vehicle{
	public Car(String make, String model, int year, int maximumspeed) {
		super(make, model,year,maximumspeed);
	}
	@Override
	public void drive() {
		System.out.println(make +" "+ model+"car is driving");
	}
}
class Bike extends Vehicle{
	public Bike(String make, String model , int year, int maximumspeed) {
		super(make, model, year, maximumspeed);
	}
	@Override
	public void drive() {
		System.out.println(make +" "+ model+"Bike is driving");
	}
}

public class Assignment1 {
	
	

	public static void main(String[] args) {
		int choose;
		String m1;
		int y;
		int s;
		String m2;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Vehicle\n1]CAR\n2]BIKE");
		choose= sc.nextInt();
		
		
	if(choose==1) {
		System.out.println("==============================ENTER DETAILS FOR THE CAR============================");
   	 
   	 sc.nextLine();
   	 
   	 System.out.println("ENTER MANUFACTURE OF CAR");
   	 m1=sc.nextLine();
   	 
   	 System.out.println("ENTER MODEL OF CAR");
   	 m2=sc.nextLine();
   	 
   	 System.out.println("ENTER YEAR OF MANUFACTURE");
   	 y=sc.nextInt();
   	 
   	 System.out.println("ENTER TOP SPEED OF CAR");
   	 s=sc.nextInt();

   	 
   	 Car myCar=new Car(m1,m2,y,s);

       System.out.println("Car: " + myCar.make + " " + myCar.model + " (" + myCar.year + ")");
       myCar.drive();
    }
 else if(choose==2) {
	  System.out.println("==============================ENTER DETAILS FOR THE BIKE============================");
	 
	 sc.nextLine();
	 
	 System.out.println("ENTER MANUFACTURE OF BIKE");
	 m1=sc.nextLine();
	 
	 System.out.println("ENTER MODEL OF BIKE");
	 m2=sc.nextLine();
	 
	 System.out.println("ENTER YEAR OF MANUFACTURE");
	 y=sc.nextInt();
	 
	 System.out.println("ENTER TOP SPEED OF BIKE");
	 s=sc.nextInt();

	 
	 Bike myBike=new Bike(m1,m2,y,s);
	  
       System.out.println("Bike: " + myBike.make + " " + myBike.model + " (" + myBike.year + ")");
       myBike.drive();
 }
 else {
	  System.out.println("YOU CHOOSED WRONG OPTION!");
	  
 }
   }
   }