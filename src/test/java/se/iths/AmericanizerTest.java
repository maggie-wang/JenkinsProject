package se.iths;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class AmericanizerTest {
	
	Americanizer lab;
	

	@Before
	public void setup(){
		lab = new Americanizer();
	}
	
	@Test 
	@Category(IntegrationTest.class)
	public void testTimeConverter(){
		TimeConverter tc = new TimeConverter();;
		
		lab.setTimeConverter(tc);
		assertEquals("5 PM", lab.convertTime(17));
	}
	
	@Test
	@Category(IntegrationTest.class)
	public void testToPound(){
		lab = new Americanizer();
		MeasureConverter c = new MeasureConverter();
		lab.setWeightConverter(c);
		assertEquals(3, lab.convertToPound(10));
	}
	
	@Test
	@Category(UnitTest.class)
	public void testTimeConverterWithMock(){
		TimeConverter tc = Mockito.mock(TimeConverter.class);
		Mockito.when(tc.getMeridiem(17)).thenReturn("PM");
		
		lab.setTimeConverter(tc);
		assertEquals("5 PM", lab.convertTime(17));
	}
	
	@Test
	@Category(UnitTest.class)
	public void testToPoundWithMock(){
		lab = new Americanizer();
		MeasureConverter c = Mockito.mock(MeasureConverter.class);
		Mockito.when(c.convertWeight(10, true)).thenReturn(7);
		lab.setWeightConverter(c);
		assertEquals(7, lab.convertToPound(10));
	}
}
