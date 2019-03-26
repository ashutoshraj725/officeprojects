package oops_programs;

public class MakePayment implements IMyInterface {

	@Override
	public void makePayment(long accountNumber, int pin) {
		System.out.println("Payment successful");
	}
}
