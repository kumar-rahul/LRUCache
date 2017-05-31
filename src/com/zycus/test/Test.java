package com.zycus.test;

import java.util.Scanner;
import com.zycus.controller.Controller;
import com.zycus.model.Model;

public class Test {

	public static void main(String[] args) {
//		Model model = new Model();
		Scanner scan = new Scanner(System.in);
		Controller ctrl = new Controller();
	    while(true){
		    System.out.println("List Operations");
		    System.out.println("===============");
		    System.out.println("1.Create DataSet");
		    System.out.println("2.LRU Implementation");
		    System.out.println("3.Create Cache");
		    System.out.println("4.Read Cache");
		    System.out.println("5.Update Cache");
		    System.out.println("6.Delete Cache");
		    System.out.println("7.Exit\n");
		    System.out.println("Enter your choice : ");
		    int in = scan.nextInt();		//error handling for string
		    if(in<=0){
		    	System.out.println("Enter only an Integer\n");
		        break;
		    } else {
				ctrl.callService(in);
		    }
	    }		
		
	}

}
