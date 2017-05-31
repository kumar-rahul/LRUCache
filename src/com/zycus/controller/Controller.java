package com.zycus.controller;

import java.util.Scanner;

import com.zycus.model.Student;
import com.zycus.service.Service;

public class Controller {
	Service service;
	Student student;
	public Controller(){
		this.service = new Service();
		this.callService(0);
	}
	public void callService(int event){
		switch(event) {
		   case 0 :
		      service.init();
		      break;
		   
		   case 1 :
			  student = new Student();
			  Scanner scan = new Scanner(System.in);
			  System.out.println("Enter student name");
			  String name = scan.next();
			  student.setName(name);
			  while(true){
				  System.out.println("Enter class name");
				  String className = scan.next();
				  student.setClassName(className);
				  System.out.println("Enter class marks");
				  String classMarks = scan.next();
				  student.setClassMarks(classMarks);
				  student.getClasses().add(student.getClassName()+" "+student.getClassMarks());
				  System.out.println("Added Successfully. Do you want to add more class?(Y/N) : ");
				  String in = scan.next();		//error handling for string
				  if(in.equalsIgnoreCase("N")){
//			    	System.out.println("classes: "+student.getClasses());
			        break;
				  } else if(in.equalsIgnoreCase("Y")) {
					continue;
				  }else{
			    	System.out.println("INVALID INPUT");
			        break;
				  }
			  }
		      service.createDataSet(student);
		      break;
		      
		   case 2 :
			      service.LRUCache();
			      break;
			   
//		   default: throw new UpiException("Invalid event"); 
		   default: System.out.println("Invalid event"); 
		}
	}

}
