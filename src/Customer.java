import java.util.*;

class Customer {
	private String name;

	@SuppressWarnings("rawtypes")
	private Vector rentals = new Vector();

	public Customer(String newname) {
		name = newname;
	};

	@SuppressWarnings("unchecked")
	public void addRental(Rental arg) {
		rentals.addElement(arg);
	};

	public String getName() {
		return name;
	};

	@SuppressWarnings("rawtypes")
	public String statement() {

		Enumeration enum_rentals = rentals.elements();

		String result = "Rental Record for " + this.getName() + "\n";
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount"
				+ "\n";

		while (enum_rentals.hasMoreElements()) {
			Rental each = (Rental) enum_rentals.nextElement();
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + "\t"
					+ each.getDaysRented() + "\t"
					+ String.valueOf(each.getCharge()) + "\n";
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned "
				+ String.valueOf(getTotalFrequentRenterPoints())
				+ " frequent renter points";
		return result;
	}

	@SuppressWarnings("rawtypes")
	private double getTotalCharge() {
		double result = 0;
		Enumeration enum_rentals = rentals.elements();
		while (enum_rentals.hasMoreElements()) {
			Rental each = (Rental) enum_rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration enum_rentals = rentals.elements();
		while (enum_rentals.hasMoreElements()) {
			Rental each = (Rental) enum_rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	public String htmlStatement() {
		Enumeration enum_rentals = rentals.elements();
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		while (enum_rentals.hasMoreElements()) {
			Rental each = (Rental) enum_rentals.nextElement();

			// show figures for each rental
			result += each.getMovie().getTitle() + ": "
					+ String.valueOf(each.getCharge()) + "<BR>\n";
		}
		// add footer lines
		result += "<P>You owe <EM>" + String.valueOf(getTotalCharge())
				+ "</EM><P>\n";

		result += "On thisrental you earned <EM>"
				+ String.valueOf(getTotalFrequentRenterPoints())
				+ "</EM> frequent renter points<P>";

		return result;
	}

}
