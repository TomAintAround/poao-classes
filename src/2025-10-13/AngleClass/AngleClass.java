class Angle {
	private double degrees;

	public Angle() {
		degrees = 0;
	}

	public Angle(double degrees) {
		while (degrees >= 360)
			degrees -= 360;
		while (degrees < 0)
			degrees += 360;
		this.degrees = degrees;
	}

	public String toString() {
		return "Ângulo de " + degrees + " graus";
	}

	public Angle add(Angle angle) {
		Angle newAngle = new Angle(angle.degrees + degrees);
		return newAngle;
	}

	public Angle subtract(Angle angle) {
		Angle newAngle = new Angle(angle.degrees - degrees);
		return newAngle;
	}

	public double radians() {
		return degrees * Math.PI / 180;
	}

	public boolean equals(Angle angle) {
		return degrees == angle.degrees;
	}

	public double sin() {
		return Math.sin(radians());
	}

	public double cos() {
		return Math.cos(radians());
	}

	public double tan() {
		return Math.tan(radians());
	}
}

public class AngleClass {
	public static void main(String[] args) {
		Angle angle1 = new Angle(-45);
		Angle angle2 = new Angle(-45);
		System.out.println("1: " + angle1);
		System.out.println("2: " + angle2);
		System.out.println("1 + 2: " + angle1.add(angle2));
		System.out.println("1 - 2: " + angle1.subtract(angle2));
		System.out.println("1 (rad): " + angle1.radians());
		System.out.println("sin(1): " + angle1.sin());
		System.out.println("cos(1): " + angle1.cos());
		System.out.println("tan(1): " + angle1.tan());
		if (angle1.equals(angle2))
			System.out.println("Os ângulos 1 e 2 são iguais");
		else
			System.out.println("Os ângulos 1 e 2 são diferentes");
	}
}
