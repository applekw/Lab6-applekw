import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * TODO A simple class that needs to be localized
 * 
 * @author mohan. Created Mar 27, 2010.
 */
public class PrintBalance {

	private static Locale currentLocale = new Locale("en", "US");

	/**
	 * Simple Java Method that is crying out to be localized.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		String language;
		String country;
		Locale currentLocale;
		ResourceBundle messages;

		

		messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.currentLocale);

		Scanner scanInput = new Scanner(System.in);

		// Greeting
		System.out.println(getGreeting(messages));

		// Get User's Name
		System.out.println(getInquiry(messages));
		String name = scanInput.nextLine();
		System.out.println(getPoliteSaying(messages) + name);

		// print today's date, balance and bid goodbye
		System.out.println(getStatement(messages) + processDate(PrintBalance.currentLocale));
		System.out.println(getDebt(messages) + processCurrency(PrintBalance.currentLocale));
		System.out.println(getFarewell(messages));
	}

	public static String getGreeting(ResourceBundle messages) {
		return messages.getString("greeting");
	}

	public static String getInquiry(ResourceBundle messages) {
		return messages.getString("inquiry");
	}

	public static String getPoliteSaying(ResourceBundle messages) {
		return messages.getString("politesaying") + " ";
	}

	public static String getStatement(ResourceBundle messages) {
		return messages.getString("statement") + " : ";
	}

	public static String getDebt(ResourceBundle messages) {
		return messages.getString("debt") + " ";
	}

	public static String getFarewell(ResourceBundle messages) {
		return messages.getString("farewell");
	}

	public static String processCurrency(Locale currentLocale) {
		NumberFormat currencyInstance = NumberFormat
				.getCurrencyInstance(currentLocale);
		return currencyInstance.format(9876543.21);

	}

	public static String processDate(Locale currentLocale) {
		DateFormat dtInstance = DateFormat.getDateTimeInstance(0, 0,
				currentLocale);
		return dtInstance.format(new Date());
	}

	/**
	 * Sets the field called 'currentLocale' to the given value.
	 * 
	 * @param currentLocale
	 *            The currentLocale to set.
	 */
	public static void setCurrentLocale(Locale locale) {
		PrintBalance.currentLocale = locale;
	}

	/**
	 * Returns the value of the field called 'currentLocale'.
	 * 
	 * @return Returns the currentLocale.
	 */
	public static Locale getCurrentLocale() {
		return currentLocale;
	}

}
