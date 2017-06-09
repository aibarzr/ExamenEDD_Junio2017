import java.awt.Button;
import java.awt.Point;
import javax.swing.JFrame;
import javax.xml.ws.FaultAction;

public class Aclass {

	/**
	 * Este método devuelve un objeto point con las coordenadas x e y tomando su
	 * valor absoluto, en caso de que valgan 0 se lanza una exception
	 */
	public Point locate(int x, int y) {

		if (0 == x && 0 == y) {
			throw new RuntimeException();
		}

		if (x < 0 || y < 0) {
			return new Point(Math.abs(x), Math.abs(y));
		}

		return new Point(x, y);

	}

	/*
	 * este metodo calcula el area de un triangulo
	 */
	public static double getArea(double a, double b, double c) {
		double s = (a + b + c) / 2.0; // s = perimeter/2
		// If we can not form a triangle return 0.0
		if (a + b <= c || b + c <= a || a + c <= b) {
			throw new RuntimeException();
		} else {
			double x = ((s) * (s - a) * (s - b) * (s - c)); // herons formula
			double area = Math.sqrt(x);
			return area;
		}
	}

	/*
	 * este metodo CONCATENA dos cadenas y convierte a MINUSCULAS si el booleano
	 * esta activo
	 */
	public String concat(boolean append, String a, String b) {
		if (null == a || null == b) {
			throw new RuntimeException();
		}
		String result = null;
		if (append) {
			result = a + b;
		}
		return result.toLowerCase();

	}

	public void mockito1(FaultAction faultAction, Button button, Point point) {

		if (button.getParent().isEnabled() && button.getParent().contains(point)) {
			if (faultAction.value().toUpperCase().compareTo("SALESIANOS.EDU") > 0) {
				return;
			}
			throw new RuntimeException();
		}

		throw new RuntimeException();

	}

	public void mockito2(JFrame frame, Button close) {

		if (close.getActionCommand().equals("close") && frame.checkImage(null, null) > 2) {
			if (frame.isDisplayable()) {
				throw new RuntimeException();
			}
			return;
		}
		throw new RuntimeException();
	}

}
