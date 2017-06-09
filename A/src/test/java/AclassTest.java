import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

public class AclassTest {
	Aclass obj = new Aclass();
	
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
		Assert.assertEquals(2, Aclass.getArea(2, 2, 2));
	}
}
