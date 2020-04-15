//Amritpal Chera
//Traiangle class: to solve a triangle, its area and perimeter 
//2019-03-25


public class triangle {
	private int A,B,C;
	private double a,b,c;
	private String function=""; //what function to use to solve triangle; cos or sin
	private double perimeter;
	private double height, area;
	
	//5 scenarios: 1.ASA, 2.SAS, 3.SSS, 4.AAS, 5.SSA
	//all missing sides are set to 0. 
	
	
	
	//************************************	
	
	//satisfies scenarios 1 and 4
	//one side and 2 angles
	public triangle (boolean sa[],double aa, int AA, int BB, String func) {
		
		int count=0; //to count how many parameters have been stored
		//all vlaues set to 0 by default
		A=0;
		B=0;
		C=0;
		a=0;
		b=0;
		c=0;
		
		if (sa[0]==true) { //if angle A was inputed
			A=AA;	
			
			if (A>180) //if A is more than 180, A is set to 180
				A=180;
			else if (A<0) //if A is less that 0, A is set to 0
				A=0;
			
			count++;
		}
		
		if (sa[1]==true) { //if angle B was inputed
			if (count==0)
				B=AA;
			else
				B=BB;
			
			if (B>180) //if B is greater than 180, B is set to 180
				B=180;
			else if (B<0) //if B is less than 0, B is set to 0
				B=0;
			
			count++;
		}
		
		if (sa[2]==true) { //if angle C was inputed
			if (count==0)
				C=AA;
			else
				C=BB;
			count++;
			
			if (C>180) //if C is more than 180, C is set ot 180
				A=180;
			else if (C<0) //if C is less than 0, C is set to 0
				A=0;
		}
		
		if (sa[3]==true) { //if side a was inputed
			a=Math.abs(aa);
		}
		
		if (sa[4]==true) { //if side b was inputed
			b=Math.abs(aa);
		}
		
		if (sa[5]==true) { //if side c was inputed
			c=Math.abs(aa);
		}
		
		function=func;
		
	}
	
	
	//************************************
	
	
	//satisfies scenarios 2 and 5
	//2 sides and one angle
	public triangle(boolean sa[] ,double aa, double bb, int AA,String func) {
		int count=0; //to count how many parameters have been stored
		//all values set to 0 by default
				A=0;
				B=0;
				C=0;
				a=0;
				b=0;
				c=0;
		if (sa[0]==true) { //if angle A was inputed
			A=AA;
			if (A>180) //if A is more than 180, A is set to 180
				A=180;
			else if (A<0) //if A is less that 0, A is set to 0
				A=0;
			
		}
		
		if (sa[1]==true) { //if angle B was inputed
			B=AA;
			
			if (B>180) //if A is more than 180, A is set to 180
				B=180;
			else if (B<0) //if A is less that 0, A is set to 0
				B=0;
		}
		
		if (sa[2]==true) { //if angle C was inputed
			C=AA;
			if (C>180) //if A is more than 180, A is set to 180
				C=180;
			else if (C<0) //if A is less that 0, A is set to 0
				C=0;
		}
		
		if (sa[3]==true) { //if side a was inputed
			a=Math.abs(aa);
			count++;
		}
		
		if (sa[4]==true) { //if side b was inputed
			if (count==0)
				b=Math.abs(aa);
			else 
				b=Math.abs(bb);
		}
		
		if (sa[5]==true) { //if side c was inputed
			c=Math.abs(bb);
		}
		
		function=func;
	}
	
	//************************************
	

	//satisfies scenario 3
	//three sides
	public triangle (double aa, double bb, double cc, String func) {
		a=Math.abs(aa);
		b=Math.abs(bb);
		c=Math.abs(cc);
		A=0;
		B=0;
		C=0;
		function=func;
	}
	
	//*********************************************
	//SETTERS AND GETTERS
	
	//setter for A
	public void setA(int ang) {
		if (ang<0)
			ang=0;
		else if (ang>180)
			ang=180;
		A=ang;
	}
	
	

	
	//GEtter for A
	public int getA() {
		return A;
	}
	
	//Setter for B
	public void setB(int ang) {
		if (ang<0)
			ang=0;
		else if (ang>180)
			ang=180;
		B=ang;
	}
	
	//Getter for B
	public int getB() {
		return B;
	}
	
	//Setter for C
	public void setC(int ang) {
		if (ang<0)
			ang=0;
		else if (ang>180)
			ang=180;
		C=ang;
	}
	
	//Getter for C
	public int getC() {
		return C;
	}
	
	//setter for a
	public void seta (double side) {
		a=Math.abs(side);
	}
	
	//getter for a
	public double geta() {
		return a;
	}
	
	//setter for b
	public void setb (double side) {
		b=Math.abs(side);
	}
	
	//getter for b
	public double getb() {
		return b;
	}
	
	//setter for c
	public void setc (double side) {
		c=Math.abs(side);
	}
	
	//getter for c
	public double getc() {
		return c;
	}
	
	//getter for perimeter
	public double getPerimeter() {
		return perimeter;
	}
	
	//getter for area
	public double getArea() {
		return area;
	}
		
		
	
	
	//****************************************
	
	
	//AA,BB, CC are angles 
	//aa,bb,cc are sides
	//sa[0]=A, sa[1]=B, sa[2]=C, sa[3]=a, sa[4]=b, sa[5]=c;
		
	
	//validity check for the triangle, each case is seperated 
	//x indicates what values were entered
	//x index storage: [0]=A, [1]=B, [2]=C, [3]=a, [4]=b, [5]=c
	
	public static boolean possible (boolean x[],int A, int B, int C, double a, double b, double c ) {
		boolean y=true; //triangle valid by default
		double rad1;//stores radian measure of the angle given
		double h=0; //height of triangle for ambiguous measurements
		
		//**************************************
		//checks SSS case
		
		
		//inputs: abc: sum of 2 sides must be greater than 3rd
		//y=true is requirements met, else false
		if (x[3] && x[4] && x[5]) {
	
			if ((a + b)<=c)
				y=false;
			else if ((a+c)<=b)
				y=false;
			else if ((b+c)<=a)
				y=false;	
			
		}
		//*************************
		
		if (A>90 || B>90 || C>90) { //if any obtuse angle given, ambiguity case eliminated
			y=true;
		}
		
		//************************
		//SSA case
		
		//input of Aa values
		else if (x[0]==true && x[3]==true && x[1]==false && x[2]==false) {
			
			//radian measure of A
			rad1= Math.toRadians(A);
			
			if (x[4]==true) { //if b is given
				h=Math.sin(rad1)*b;
			}
			
			else if (x[5]==true) { //if c is given
				h=Math.sin(rad1)*c;
				
			}
			
			//if there is one triangle, h must equal the opposite side
			if (Math.round(((h/a))*10.0)/10.0==1) { //due to decimal values, the program accepts 1% error
				y=true;
			}
			//if h!=the opposite side
			else 
				y=false;
			
			//multiple triangles exist if h<a, therefore,  calculations made for any one triangle
			if (h<a) {
				y=true;
				System.out.println("\nMultiple triangles exist");
				System.out.println("Calculations for 1 triangle will be made");
			}
			
		}
		
		//checks Bb vlaues 
		else if(x[1]==true && x[4]==true && x[0]==false && x[2]==false) {
			rad1= Math.toRadians(B);//radian measure of B
			if (x[3]==true) { //if a is given
				h=Math.sin(rad1)*a;
			}
			
			else if (x[5]==true) { //if c is given
				h=Math.sin(rad1)*c;
			}

			//if there is one triangle, h must equal the opposite side
			if (Math.round((h/b)*10.0)/10.0==1) { //due to decimal values, the program accepts 1% error
				y=true;
			}
			//if h!=the opposite side
			else
				y=false;
			
			//multiple triangles exist if h<a, therefore,  calculations made for any one triangle
			if (h<b) {
				y=true;
				System.out.println("\nMultiple triangles exist");
				System.out.println("Calculations for 1 triangle will be made");
			}
			
		}
		//input values of Cc
		else if(x[2]==true && x[5]==true && x[0]==false && x[1]==false) {
			rad1= Math.toRadians(C); //radian measure of C
			
			if (x[3]==true) { //if a is given
				h=Math.sin(rad1)*a;
			}
			
			else if (x[4]==true) { //if b is given
				h=Math.sin(rad1)*b;
			}
			
			//if there is one triangle, h must equal the opposite side
			if (Math.round((h/c)*10.0)/10.0==1) { //due to decimal values, the program accepts 1% error
				y=true;
			}
			//if h!=the opposite side
			else 
				y=false;
	
			//multiple triangles exist if h<a, therefore,  calculations made for any one triangle
			if (h<c) {
				y=true;
				System.out.println("\nMultiple triangles exist");
				System.out.println("Calculations for 1 triangle will be made");
			}
			
		}
		//********************
		//SSA Case
		//check reason: if A > B, therefore a>b
		
		
		//Aab
		if ((x[0]&&x[3]&&x[4])){
			if (A>=90 && (a<=b)) 
				y=false;
		}
		//Aac
		else if ((x[0]&&x[3]&&x[5])){
			if (A>=90 && (a<=c)) 
				y=false;
		}
		
		//Ccb
		else if ((x[2]&&x[5]&&x[4])){
			if (C>=90 && (c<=b)) 
				y=false;
		}
		
		//Cca
		else if ((x[2]&&x[3]&&x[5])){
			if (C>=90 && (a>=c)) 
				y=false;
		}
		
		//Bbc
		else if ((x[1]&&x[4]&&x[5])){
			if (B>=90 && (b<=c)) 
				y=false;
		}
		
		//Bba
		else if ((x[1]&&x[4]&&x[3])){
			if (B>=90 && (b<=a)) 
				y=false;
		}
		
		//*****************************
		
		//calculations can't be made if all angles provided
		if (x[0]==true && x[1]==true && x[2]==true)
			y=false;
		
		if ((A+B+C)>=180) //all angles added must be less than 180
			y=false;
		
		//checks if angles were invalid; less than or equal to 0
		if (x[0] && A<=0)
			y=false;
		else if (x[1] && B<=0)
			y=false;
		else if (x[2] && C<=0)
			y=false;
			
		
		return y; //returns true if triangle is ambiguous, else is false

	}
	
	//**************************************************
	
	//calculate all sides and angles
	public void calculate () {
		//Scenario 1: ASA
		if (function.equals("ASA")) {
			System.out.println("ASA case");
			//calculate the third angle
			if (C==0) 
				C=180-A-B;
			else if (B==0)
				B=180-A-C;
			else if (A==0) 
				A=180-B-C;
			
			//use sin law with the side provided
			double AA= Math.toRadians(A);
			double BB = Math.toRadians(B);
			double CC = Math.toRadians(C);
			
			//only one side will be provided, which can not be -ve
			if (a!=0) {
				b=(a*(Math.sin(BB)) /Math.sin(AA));
				c=(a*(Math.sin(CC)) /Math.sin(AA));
			}
			else if (b!=0) {
				a=(b*(Math.sin(AA)) /Math.sin(BB));
				c=(b*(Math.sin(CC)) /Math.sin(BB));
			}
			else if (c!=0) {
				a=(c*(Math.sin(AA)) /Math.sin(CC));
				b=(c*(Math.sin(BB)) /Math.sin(CC));
			}	
		}
		
		//scenario 2: SAS
		else if (function.equals("SAS")) {
			System.out.println("SAS case");
			double AA= Math.toRadians(A);
			double BB = Math.toRadians(B);
			double CC = Math.toRadians(C);
			
			//step 1 to use cos
			
			//if angle A was provided, a must be found
			if (A!=0) {
				a=(Math.pow(b,2)+Math.pow(c,2))-(2*b*c*Math.cos(AA));
				a=Math.sqrt(a);
				//a=Math.round(a);
			}
			
			//if angle B is provided, b must be found
			else if (B!=0) {
				b=(Math.pow(a,2)+Math.pow(c,2)-(2*c*a*Math.cos(BB)));
				b=Math.sqrt(b);
				//b=Math.round(b);
			}
			//if angle C is provided, c must be found
			else if (C!=0) {
				c=(Math.pow(a,2)+Math.pow(b,2)-(2*b*a*Math.cos(CC)));
				c=Math.sqrt(c);
				//c=Math.round(c);
			}
			
			//**at this point side opposite to angle is found
			
			//step 2: use sine law to find other angles
			
			//if angle A was provided, focus on B and C
			if (A!=0) {
				if (b<c) {
					BB=(Math.sin(AA)*b)/(a);
					BB=Math.round(BB*100.0)/100.0;
					BB=(Math.asin(BB));
					//System.out.println("BB: "+BB);
					BB=Math.toDegrees(BB);
					B=(int)Math.round(BB);
					//System.out.println("B: "+B);
					C=180-A-B; //third angle can be found by 180 -A-C
				}
				else {
					CC=(Math.sin(AA)*c)/(a);
					CC=Math.round(CC*100.0)/100.0;
					CC=(Math.asin(CC));
					//System.out.println("BB: "+BB);
					CC=Math.toDegrees(CC);
					C=(int)Math.round(CC);
					//System.out.println("B: "+B);
					B=180-A-C; //third angle can be found by 180 -A-C
				}
			}
			
			//if angle B is provided, focus on A and C
			else if (B!=0) {
				if (a<c) {
					AA=(a*Math.sin(BB))/b;
					AA=Math.round(AA*100.0)/100.0;
					AA=Math.asin(AA);
					AA=Math.toDegrees(AA);
					A=(int)Math.round(AA);
					C=180-B-A;
				}
				else {
					CC=(Math.sin(AA)*c)/(b);
					CC=Math.round(CC*100.0)/100.0;
					CC=(Math.asin(CC));
					CC=Math.toDegrees(CC);
					C=(int)Math.round(CC);
					B=180-A-C;
				}
			}
			//if angle C is provided, focus on A and B
			else if (C!=0) {
				if (b<a) {
					BB=(b*Math.sin(CC))/c;
					BB=Math.round(BB*100.0)/100.0;
					BB=Math.asin(BB);
					BB=Math.toDegrees(BB);
					B=(int)Math.round(BB);
					A=180-C-B;
				}
				else {
					AA=(a*Math.sin(CC))/c;
					AA=Math.round(AA*100.0)/100.0;
					AA=Math.asin(AA);
					AA=Math.toDegrees(AA);
					A=(int)Math.round(AA);
					C=180-B-A;
				}
			}
			
			//**at this point we have all angles and sides
			
		}
		
		//case3: SSS
		
		if (function.equals("SSS")) {
			//radian measures of angles
			System.out.println("SSS case");
			double AA= Math.toRadians(A);
			double BB = Math.toRadians(B);
			double CC = Math.toRadians(C);
			
			//step 1: use cos law
	
			//find A
			AA=Math.pow(c,2)+Math.pow(b,2)-Math.pow(a,2);
			AA/=2*c*b;
			AA=Math.round(AA*100.0)/100.0;
			AA=Math.acos(AA);
			AA=Math.toDegrees(AA);
			A=(int)Math.round(AA);
			
			//find B
			BB=Math.pow(a,2)+Math.pow(c,2)-Math.pow(b,2);
			BB/=2*c*a;
			BB=Math.round(BB*100.0)/100.0;
			BB=Math.acos(BB);
			BB=Math.toDegrees(BB);
			B=(int)Math.round(BB);
			
			//find C
			C=180-A-B;
		}
		
		//Scenario 4: AAS
		
		if (function.equals("AAS")) {
			System.out.println("AAS case");
			//radian measures of angles
			double AA= Math.toRadians(A);
			double BB = Math.toRadians(B);
			double CC = Math.toRadians(C);
			
			
			// step 1; find the unknown angle
			if (A==0) {
				A=180-B-C;
			}
			else if (B==0) {
				B=180-A-C;
			}
			else if (C==0) {
				C=180-A-B;
			}
			
			//at this point we have all angles
			
			//step2: use sine law to find missing sides
			
			//if side c is given
			if (c!=0) {
				b=(Math.sin(BB)*c)/Math.sin(CC);
				a=(Math.sin(AA)*C)/Math.sin(CC);
			}
			
			//if side b is given
			else if (b!=0) {
				c=(Math.sin(CC)*b)/Math.sin(BB);
				a=(Math.sin(AA)*b)/Math.sin(BB);
			}
			
			//if side a is given
			else if (a!=0) {
				b=(Math.sin(BB)*a)/Math.sin(AA);
				c=(Math.sin(CC)*a)/Math.sin(AA);
			}
			
			//at this point we should have all sides and angles	
		}
		
		//Last scenario: SSA
		if (function.equals("SSA")) {
			System.out.println("SSA case");
			//radian measures of angles
			double AA= Math.toRadians(A);
			double BB = Math.toRadians(B);
			double CC = Math.toRadians(C);
			
			//if angle A and side b is given, find B and C
			if (A!=0 && b!=0) {
				//find B
				BB=(b*Math.sin(AA))/a;
				BB=Math.round(BB*100.0)/100.0;
				BB=Math.asin(BB);
				BB=Math.toDegrees(BB);
				B=(int)Math.round(BB);
				C=180-B-A;
				CC=Math.toRadians(C);
				BB=Math.toRadians(B);
				//find c
				c=(Math.sin(CC)*b)/(Math.sin(BB));
			}
			
			//if angle A and side c is given, find B and C
			else if (A!=0 && c!=0) {
				//find C
				CC=(c*Math.sin(AA))/a;
				CC=Math.round(CC*100.0)/100.0;
				CC=Math.asin(CC);
				CC=Math.toDegrees(CC);
				C=(int)Math.round(CC);
				B=180-C-A;
				BB=Math.toRadians(B);
				CC=Math.toRadians(C);
				//find b
				b=(Math.sin(BB)*c)/Math.sin(CC);
			}
			
			//if angle B and side a is given, find A and C
			else if (B!=0 && a!=0) {
				//find A
				AA=(a*Math.sin(BB))/b;
				AA=Math.round(AA*100.0)/100.0;
				AA=Math.asin(AA);
				AA=Math.toDegrees(AA);
				A=(int)Math.round(AA);
				C=180-B-A;
				CC=Math.toRadians(C);
				BB=Math.toRadians(B);
				//find c
				c=(Math.sin(CC)*b)/Math.sin(BB);
			}
			
			//if angle B and side c is given, find A and C
			else if (B!=0 && c!=0) {
				//find C
				CC=(c*Math.sin(BB))/b;
				CC=Math.round(CC*100.0)/100.0;
				CC=Math.asin(CC);
				CC=Math.toDegrees(CC);
				C=(int)Math.round(CC);
				A=180-B-C;
				AA=Math.toRadians(A);
				BB=Math.toRadians(B);
				//find a
				a=(Math.sin(AA)*b)/Math.sin(BB);
			}
			
			//if angle C and side a is given, find B and A
			else if (C!=0 && a!=0) {
				//find A
				AA=(a*Math.sin(CC))/c;
				AA=Math.round(AA*100.0)/100.0;
				AA=Math.asin(AA);
				AA=Math.toDegrees(AA);
				A=(int)Math.round(AA);
				B=180-C-A;
				BB=Math.toRadians(B);
				CC=Math.toRadians(C);
				//find b
				b=(Math.sin(BB)*c)/Math.sin(CC);
			}
			
			//if angle C and side b is given, find B and A
			else if (C!=0 && b!=0) {
				//find B
				BB=(b*Math.sin(CC))/c;
				BB=Math.round(BB*100.0)/100.0;
				BB=Math.asin(BB);
				BB=Math.toDegrees(BB);
				B=(int)Math.round(BB);
				A=180-B-C;
				AA=Math.toRadians(A);
				BB=Math.toRadians(B);
				//find a
				a=(Math.sin(AA)*b)/Math.sin(BB);
			}
			
		}
		
	}
	
	//calculates perimiter
	public void calculatePerimeter () {
		perimeter =a+b+c;
	}
	
	
	//calculate height of triangle
	public void calculateHeight() {
		//C and c will always be used to calculate height, h will always intersect a at 90 degrees
		double CC=Math.toRadians(C);
		height=Math.sin(CC)*b;
		//System.out.println("height: "+height);
	}
	
	//calculate area of triangle
	public void calculateArea() {
		calculateHeight();
		area=(a*height)/2;
	}
	
	public static void printMenu() {
		System.out.println("\nEnter 1 to return specifications");
		System.out.println("Enter 2 to output perimeter");
		System.out.println("Enter 3 to output area");
		System.out.println("Enter 4 to change side");
		System.out.println("Enter 5 to exit");
		
	}
	
	public static void printTriangle() {
		System.out.println("         /\\");
		System.out.println("        /__\\");
		System.out.println("       / C  \\ ");
		System.out.println("      /      \\ ");
		System.out.println("   b /        \\ a");
		System.out.println("    /          \\");
		System.out.println("   /            \\");
		System.out.println("  /|A          B|\\");
		System.out.println(" /_|____________|_\\");
		System.out.println("          c");
	
	}
}
