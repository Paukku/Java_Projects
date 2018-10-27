import org.junit.After;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class test {
	private final ByteArrayOutputStream testOut = new ByteArrayOutputStream();

	@After
	public void restore() {
		System.setOut(null);
	}
//	System go down if user send letters in deposit / withdraw.
	@Test
	void testShowMenuSendOnlyLetters() {
		BankApp ba = new BankApp("TestUser", "BA0002");
		ByteArrayInputStream input =  new ByteArrayInputStream("B".getBytes());
		ByteArrayInputStream input2 =  new ByteArrayInputStream("s".getBytes());
		System.setIn(input);
		System.setIn(input2);
		System.setOut(new PrintStream(testOut));
		ba.showMenu();
		String findstring = testOut.toString();
		String [] splitted = findstring.split("\n");
		String ret = splitted[15];
		assertEquals("Some error message.", ret);
	
	}
	
	@Test
	void testShowMenuSendEletter() {
		BankApp ba = new BankApp("TestUser", "BA0002");
		ByteArrayInputStream input =  new ByteArrayInputStream("E".getBytes());
		System.setIn(input);
		System.setOut(new PrintStream(testOut));
		ba.showMenu();
		String findstring = testOut.toString();
		String [] splitted = findstring.split("\n");
		String ret = splitted[15];

		assertEquals("Thank you for using our services.", ret);
	
	}
	
}
