import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import static org.junit.Assert.*;



import org.junit.Test;




/**
 * Tests that PrintBalance returns the correct localized strings.
 *
 * @author applekw.
 *         Created Apr 1, 2011.
 */
public class PrintBalanceTest {
	private Locale french  = new Locale("fr","FR");
	private Locale german = new Locale("de","DE");
	private Locale english = new Locale("en", "US");
	
	@Test
	public void testThatDefaultGreetingIsEnglish(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Hello World", PrintBalance.getGreeting(messages));
	}
	
	@Test
	public void testThatDefaultFarewellIsEnglish(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Good Bye", PrintBalance.getFarewell(messages));
	}

	@Test
	public void testThatDefaultStatementIsEnglish(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("As of"+ " : ", PrintBalance.getStatement(messages));
	}
	
	@Test
	public void testThatDefaultPoliteSayingIsEnglish(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("I am pleased to meet you"+" ", PrintBalance.getPoliteSaying(messages));
	}
	
	@Test 
	public void testThatDefaultDebtIsEnglish(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("You owe the school"+ " ", PrintBalance.getDebt(messages));
	}
	
	@Test
	public void testThatDefaultInquiryIsEnglish(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Please enter your name", PrintBalance.getInquiry(messages));
	}
	
	@Test
	public void testThatLocaleCanBeChanged(){
		PrintBalance.setCurrentLocale(french);
		assertEquals(french,PrintBalance.getCurrentLocale());
	}
	
	@Test
	public void testThatLocaleChangePersists(){
		assertEquals(french,PrintBalance.getCurrentLocale());
	}
	
	@Test
	public void testThatFrenchGreetingIsCorrect(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Bonjour tout le monde", PrintBalance.getGreeting(messages));
	}
	
	@Test
	public void testThatFrenchFarewellIsCorrect(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Au revoir", PrintBalance.getFarewell(messages));
	}

	@Test
	public void testThatFrenchStatement(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Du"+ " : ", PrintBalance.getStatement(messages));
	}
	
	@Test
	public void testThatFrenchPoliteSayingIsCorrect(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Je suis heureux de vous recontrer"+" ", PrintBalance.getPoliteSaying(messages));
	}
	
	@Test 
	public void testThatFrenchDebtIsCorrect(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Vous devez l'ecole"+ " ", PrintBalance.getDebt(messages));
	}
	
	@Test
	public void testThatFrenchInquiryIsCorrect(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("S'il vous plait entrer votre nom", PrintBalance.getInquiry(messages));
	}
	
	@Test
	public void testThatGermanGreetingIsCorrect(){
		PrintBalance.setCurrentLocale(german);
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Hallo Welt", PrintBalance.getGreeting(messages));
	}
	
	@Test
	public void testThatGermanFarewellIsCorrect(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Lebewohl", PrintBalance.getFarewell(messages));
	}

	@Test
	public void testThatGermanStatement(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Als der"+ " : ", PrintBalance.getStatement(messages));
	}
	
	@Test
	public void testThatGermanPoliteSayingIsCorrect(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Ich freue mich, Sie kennen zu lernen"+" ", PrintBalance.getPoliteSaying(messages));
	}
	
	@Test 
	public void testThatGermanDebtIsCorrect(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Sie schulden der Schule"+ " ", PrintBalance.getDebt(messages));
	}
	
	@Test
	public void testThatGermanInquiryIsCorrect(){
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", PrintBalance.getCurrentLocale());
		assertEquals("Bitte geben Sie Ihren Namen", PrintBalance.getInquiry(messages));
	}
	
	@Test
	public void testThatEnglishCurrencyIsOutputCorrectly(){
		PrintBalance.setCurrentLocale(english);
		assertEquals("$9,876,543.21", PrintBalance.processCurrency());
		
	}
	
	@Test
	public void testThatEnglishDateIsOutputCorrectly(){
		DateFormat dtInstance = DateFormat.getDateTimeInstance(0, 0,
				english);
		String currentdate = dtInstance.format(new Date());
		assertEquals(currentdate, PrintBalance.processDate());
	}
	
	@Test
	public void testThatFrenchCurrencyIsOutputCorrectly(){
		PrintBalance.setCurrentLocale(french);
		assertEquals("9 876 543,21 €", PrintBalance.processCurrency());
		
	}
	
	@Test
	public void testThatFrenchDateIsOutputCorrectly(){
		DateFormat dtInstance = DateFormat.getDateTimeInstance(0, 0,
				french);
		String currentdate = dtInstance.format(new Date());
		assertEquals(currentdate, PrintBalance.processDate());
	}
	
	@Test 
	public void testThatGermanCurrencyIsOutputCorrectly(){
		PrintBalance.setCurrentLocale(german);
		assertEquals("9.876.543,21 €", PrintBalance.processCurrency());
	}
	
	@Test
	public void testThatGermanDateIsOutputCorrectly(){
		DateFormat dtInstance = DateFormat.getDateTimeInstance(0, 0,
				german);
		String currentdate = dtInstance.format(new Date());
		assertEquals(currentdate, PrintBalance.processDate());
	}

}
