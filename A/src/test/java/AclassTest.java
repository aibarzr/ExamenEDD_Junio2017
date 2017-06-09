import java.awt.Button;
import java.awt.Container;
import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.JFrame;
import javax.xml.ws.FaultAction;

@RunWith(MockitoJUnitRunner.class)
public class AclassTest {
	Aclass obj = new Aclass();
	
	@Mock
	FaultAction faultAction;
	
	@Mock
	Button button;
	
	@Mock
	Container container;
	
	@Mock
	Point point;
	
	@Mock
	JFrame frame;
	
	@Mock
	Button close;
	
	
	
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
	
	
	
	//Testing mockito1
	@Test
	public void mockito1Test_1() {
		Mockito.when(button.getParent()).thenReturn(container);
		Mockito.when(container.isEnabled()).thenReturn(true);
		Mockito.when(container.contains(point)).thenReturn(true);
		Mockito.when(faultAction.value()).thenReturn("salesianos.edu");
		try {
			obj.mockito1(faultAction, button, point);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void mockito1Test_2() {
		Mockito.when(button.getParent()).thenReturn(container);
		Mockito.when(container.isEnabled()).thenReturn(false);
		Mockito.when(container.contains(point)).thenReturn(false);
		try {
			obj.mockito1(faultAction, button, point);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//Testing mockito2
	@Test
	public void mockito2Test_1() {
		Mockito.when(close.getActionCommand()).thenReturn("close");
		Mockito.when(frame.checkImage(null, null)).thenReturn(3);
		Mockito.when(frame.isDisplayable()).thenReturn(true);
		try {
			obj.mockito2(frame, close);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void mockito2Test_2() {
		Mockito.when(close.getActionCommand()).thenReturn("open");
		Mockito.when(frame.checkImage(null, null)).thenReturn(1);
		try {
			obj.mockito2(frame, close);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void mockito2Test_3() {
		Mockito.when(close.getActionCommand()).thenReturn("close");
		Mockito.when(frame.checkImage(null, null)).thenReturn(2);
		Mockito.when(frame.isDisplayable()).thenReturn(false);
		try {
			obj.mockito2(frame, close);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}
