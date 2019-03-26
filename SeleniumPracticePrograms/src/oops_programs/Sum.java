package oops_programs;

public class Sum {

	public static int multiply(int a, int b)
	{
		int c=a*b;
		System.out.println("Multiplication is : "+c);
		return c;
	}
	
	public static double multiply(double a, float b)
	{
		double c=a*b;
		System.out.println("Multiplication is : "+c);
		return c;
	}
	
	public static double multiply(double a, int b, float c)
	{
		double d=a*b*c;
		System.out.println("Multiplication is : "+d);
		return c;
	}
	
	public static void main(String[] args) {
		
		Sum.multiply(6.7, 5);
		Sum.multiply(5.6, 6, 5);
	}
	
}
