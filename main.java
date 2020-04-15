//Amritpal Chera

//main class: deals with user interface for inputing data for triangle side and angles
//2019-03-25

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		triangle t1 = null;
		
		//Angles ABC
		int A=0, B=0,C=0;
		
		//sides abc
		double a=0,b=0,c=0;
		
		//input from the user
		String input="";
		
		//values of inputs 
		int ang1, ang2; //you can only input max of 2 sides
		double side1, side2, side3;
		
		System.out.println("Before starting, read the following: ");
		System.out.println("Options for user input: \n ");
		System.out.println("Angles: 'A' , 'B' , 'C'");
		System.out.println("Sides: 'a' , 'b' , 'c' \n");
		System.out.println("NOTE: 'A' is the opposite angle of 'a' and same for others");
		System.out.println("All angles must be between 0 and 180 degrees\n");
		System.out.println("Angles must be integers only.");
		System.out.println("3 different inputs must be entered to continue");
		System.out.println("This program can not take more than 3 inputs");
		System.out.println("So DON'T WORRY about extra inputs, we got you covered :)\n");
		System.out.println("Press ENTER if you understood everything...");
		String enter= in.nextLine();
		
		boolean check=true; //check if triangle right-angled or ambiguous in reality
		boolean sa[]=new boolean[6]; //to keep record of what input was entered
		//sa[0]=A, sa[1]=B, sa[2]=C, sa[3]=a, sa[4]=b, sa[5]=c;
		
		
		//repeats if the triangle does not exist or is not valid for calculations
		do {
			triangle.printTriangle();
			boolean y=true; //to indicate valid or invalid input for sides and angle 
			int count=0; //only need 3 valid inputs, condition for while loop
			
			//inputs angles and sides from user
			do {
				
				System.out.print("Please specify the input: ");
				input =in.next(); //angle or side input
				y=true; //angle and side input set to valid by default
				
				if (input.equals("A") && sa[0]==false){
					System.out.println("Please Enter a Value: ");
					A=in.nextInt();
					sa[0]=true;
				}
				else if (input.equals("B")&& sa[1]==false) {
					System.out.println("Please Enter a Value: ");
					B=in.nextInt();
					sa[1]=true;
				}
				else if (input.equals("C")&& sa[2]==false) {
					System.out.println("Please Enter a Value: ");
					C=in.nextInt();
					sa[2]=true;
				}
				
				else if (input.equals("a")&& sa[3]==false) {
					System.out.println("Please Enter a Value: ");
					a=in.nextDouble();
					sa[3]=true;
				}
				else if (input.equals("b")&& sa[4]==false) {
					System.out.println("Please Enter a Value: ");
					b=in.nextDouble();
					sa[4]=true;
					
				}
				else if (input.equals("c")&& sa[5]==false) {
					System.out.println("Please Enter a Value: ");
					c=in.nextDouble();	
					sa[5]=true;
				}
				
				else {
					y=false;  //if angle or side input was invalid
				}
		
				if (y==true) {//if last input was valid, count+=1;
					count++; 
				}
				
				else  
					System.out.println("Invalid input");
				
			} while(count<=2);
					
			//true is triangle is valid, else false;
			check= triangle.possible (sa, A, B, C, a, b,c);
			if (check==false)
				System.out.println("Triangle not valid. Please input triangle again");
			
			System.out.println("\n");
	
			//only resets values if calculations can't be made
			if (check==false) {
				//resets all sa values to false as triangle will need to be re-entered
				for (int aa=0;aa<6;aa++) {
					sa[aa]=false;
				}
				//reset all variables
				count=0;
				A=0;B=0;C=0;a=0;b=0;c=0;
			}
			
		}while (check==false);
		
		//****At this point, all inputs of triangle are valid, triangle can be created
		//The following cases are determined through patterns associated with triangles	
		
		//all sides entered SSS
		if (sa[3]==true && sa[4]==true && sa[5]==true) {
			t1= new triangle (a,b,c,"SSS"); //SSS
		}
		
		//angle A and B entered
		else if ((sa[0]==true && sa[1]==true)) {
			//System.out.println("A and B");
			if (sa[3])
				t1=new triangle (sa, a, A,B,"AAS");  //AAS
			
			else if (sa[4])
				t1= new triangle (sa,b, A,B,"AAS"); //AAS
			else if (sa[5])
				t1=new triangle (sa, c, A,B,"ASA"); //ASA
			
		}
		
		//angle B and C entered
		else if (sa[1]==true && sa[2]==true) {
			//System.out.println("B and C");
			if (sa[3])
				t1=new triangle (sa, a,B,C,"ASA"); //ASA
			else if (sa[4])
				t1= new triangle (sa,b,B,C,"AAS"); //AAS
			else if (sa[5])
				t1=new triangle (sa, c,B,C,"AAS"); //AAS
			
		}
		
		
		//Angle A and C entered
		else if (sa[0]==true && sa[2]==true) {
			//System.out.println("A and C");
			if (sa[3])
				t1=new triangle (sa, a, A,C,"AAS"); //AAS
			else if (sa[4])
				t1= new triangle (sa,b, A,C,"ASA"); //ASA
			else if (sa[5])
				t1=new triangle (sa, c, A,C,"AAS"); //AAS
			
		}
		
		
		
		//side a and b entered
		else if (sa[3] && sa[4]) {
			//System.out.println("a and b");
			if (sa[0])
				t1= new triangle (sa,a,b,A,"SSA"); //SSA
			else if (sa[1])
				t1= new triangle (sa, a,b,B,"SSA"); //SSA
			else if (sa[2])
				t1= new triangle (sa,a,b,C,"SAS"); //SAS
			
		}
		
		//side a and c entered
		else if (sa[3] && sa[5]) {
			if (sa[0])
				t1= new triangle (sa,a,c,A,"SSA"); //SSA
			else if (sa[1])
				t1= new triangle (sa, a,c,B,"SAS"); //SAS
			else if (sa[2])
				t1= new triangle (sa,a,c,C,"SSA"); //SSA
			
		}
		
		//side b and c entered
		
		else if (sa[4] && sa[5]) {
			//System.out.println("b and c");
			if (sa[0])
				t1= new triangle (sa,b,c,A,"SAS"); //SAS
			else if (sa[1])
				t1= new triangle (sa, b,c,B,"SSA"); //SSA
			else if (sa[2])
				t1= new triangle (sa,b,c,C,"SSA"); //SSA
			
		}
		
		//necessary to calvulate triangel right after it is created
		t1.calculate();
		
		
		//At this time, the initial triangle has been created and solved
		
		boolean con=true; //condition for while loop
		do {
			triangle.printMenu(); //prints the instructions
			int choice=in.nextInt();
			switch(choice) {
			case 1:
				t1.calculate();
				System.out.println("A: "+t1.getA());
				System.out.println("B: "+t1.getB());
				System.out.println("C: "+t1.getC());
				System.out.println("a: "+Math.round((t1.geta())*1000.0)/1000.0);
				System.out.println("b: "+Math.round((t1.getb())*1000.0)/1000.0);
				System.out.println("c: "+Math.round((t1.getc())*1000.0)/1000.0);
				break;
				
			case 2:
				t1.calculatePerimeter();
				System.out.println("Perimeter: "+ Math.round(t1.getPerimeter()*100.0)/100.0);
				break;
				
			case 3:
				t1.calculateArea();
				System.out.println("Area: "+Math.round(t1.getArea()*100.0)/100.0);
				break;
				
			case 4:
				triangle.printTriangle();
				System.out.println("\nWhat side or angle to change: ");
				input =in.next();
				if (input.equals("A") && sa[0]==true){
					System.out.println("Please Enter a Value: ");
					A=in.nextInt();
				}
				else if (input.equals("B")&& sa[1]==true) {
					System.out.println("Please Enter a Value: ");
					B=in.nextInt();
				}
				else if (input.equals("C")&& sa[2]==true) {
					System.out.println("Please Enter a Value: ");
					C=in.nextInt();
					sa[2]=true;
				}
				
				else if (input.equals("a")&& sa[3]==true) {
					System.out.println("Please Enter a Value: ");
					a=in.nextDouble();
				}
				else if (input.equals("b")&& sa[4]==true) {
					System.out.println("Please Enter a Value: ");
					b=in.nextDouble();
					
				}
				else if (input.equals("c")&& sa[5]==true) {
					System.out.println("Please Enter a Value: ");
					c=in.nextDouble();	
				}
				else {
					System.out.println("Invalid Input");
					check=false;
				}
				
				//reset all values that were intially not entered to deafualt of 0
				if (sa[0]==false) 
					t1.setA(0);
				if (sa[1]==false) 
					t1.setB(0);
				if (sa[2]==false) 
					t1.setC(0);
				if (sa[3]==false) 
					t1.seta(0);
				if (sa[4]==false) 
					t1.setb(0);
				if (sa[5]==false) 
					t1.setc(0);
			
				//false if's there is one triangle, else true;
				check= triangle.possible (sa, A, B, C, a, b,c);
				if (check==false)
					System.out.println("Triangle not possible with value entered\nNo changes made");
				
				System.out.println("\n");
				//is triangle valid after entry, value is changed
				if (check==true) {
					if (input.equals("A"))
						t1.setA(Math.abs(A));
					else if (input.equals("B"))
						t1.setB(Math.abs(B));
					else if (input.equals("C"))
						t1.setC(Math.abs(C));
					else if (input.equals("a"))
						t1.seta(Math.abs(a));
					else if (input.equals("b"))
						t1.setb(Math.abs(b));
					else if (input.equals("c"))
						t1.setc(Math.abs(c));
				
				}
				t1.calculate();
				break;
				
			case 5:
				con=false;	
			}

		}while (con==true);
	}

}
