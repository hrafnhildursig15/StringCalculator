package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	@Test
    public void testNewDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
	@Test
    public void testNewLine(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }
	@Test
    public void testNegativeNumbers(){
    	assertEquals(0, Calculator.add("-1,2,-3,4,3,-8,0,-1"));
    }
	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	
	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
	@Test
	public void largerThanThousand(){
		assertEquals(2, Calculator.add("2,1001"));
	}
}