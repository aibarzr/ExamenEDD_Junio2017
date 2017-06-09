import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

public class AclassTest {
	Aclass obj = new Aclass();
	
	@Mock
	FaultAction faultAction;
	
	@Mock
	Button button;
	
	@Mock
	Point point;
	
	@Test
	public void locateTest() {
		Assert.assertEquals(new Point(1, 1), obj.locate(1, 1));
		Assert.assertEquals(new Point(2, 3), obj.locate(2, 3));
		Assert.assertEquals(new Point(1, 4), obj.locate(-1, -4));
		try {
			Assert.assertEquals(new Point(0, 0), obj.locate(0, 0));
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	//Triangle
	public void getAreaTest() {
		Assert.assertEquals(2, Aclass.getArea(2, 2, 2), 2);
		try {
			Assert.assertEquals(4, Aclass.getArea(2, 2, 4), 4);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		try {
			Assert.assertEquals(4, Aclass.getArea(4, 2, 2), 4);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		try {
			Assert.assertEquals(4, Aclass.getArea(2, 4, 2), 4);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void concatTest() {
		Assert.assertEquals("en un lugar de la mancha", obj.concat(true, "En un lugar", " de la Mancha"));
		try {
			Assert.assertEquals(" de la mancha", obj.concat(true, null, " de la Mancha"));
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		try {
			Assert.assertEquals("en un lugar", obj.concat(true, "En un lugar", null));
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		try {
			Assert.assertEquals(null, obj.concat(true, null, null));
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void mockito1Test() {
		
	}
}
