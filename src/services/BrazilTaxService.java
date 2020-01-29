package services;

public class BrazilTaxService {

	/*
	 * Tax in Brazil: 
	 * 20% until R$ 100,00 15% above R$ 100,00
	 * Example: 100.00 * 0.2 = 20.00
	 */

	public double tax(double amount) {
		if (amount <= 100) {
			return amount * 0.2;
		} else {
			return amount * 0.15;
		}
	}
}
