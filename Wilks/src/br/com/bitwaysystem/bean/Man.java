package br.com.bitwaysystem.bean;

public class Man extends Human {	

	private static Double a = -216.0475144;
	private static Double b = 16.2606339;
	private static Double c = -0.002388645;
	private static Double d = -0.00113732;
	private static Double e = 7.01863E-06;	
	private static Double f = -1.291E-08;
		
	public Man() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static Double getA() {
		return a;
	}
	public static void setA(Double a) {
		Man.a = a;
	}
	public static Double getB() {
		return b;
	}
	public static void setB(Double b) {
		Man.b = b;
	}
	public static Double getC() {
		return c;
	}
	public static void setC(Double c) {
		Man.c = c;
	}
	public static Double getD() {
		return d;
	}
	public static void setD(Double d) {
		Man.d = d;
	}
	public static Double getE() {
		return e;
	}
	public static void setE(Double e) {
		Man.e = e;
	}
	public static Double getF() {
		return f;
	}
	public static void setF(Double f) {
		Man.f = f;
	}	
}