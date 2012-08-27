package br.com.bitwaysystem.wilks;

import br.com.bitwaysystem.bean.Man;
import br.com.bitwaysystem.bean.Supine;
import br.com.bitwaysystem.bean.Woman;

/*Calculo do Wilks para levantamento de Supino
 * Referẽncias:
 * http://wilkscalculator.com/kg
 * http://en.wikipedia.org/wiki/Wilks_Coefficient
 */

public class Wilks {

	private Double a;
	private Double b;
	private Double c;
	private Double d;
	private Double e;
	private Double f;
	private Double x;
	private Double coeff;
	private Double liftAmount;
	private Man man;
	private Woman woman;

	public Wilks(Woman woman) {
		super();
		this.a = Woman.getA();
		this.b = Woman.getB();
		this.c = Woman.getC();
		this.d = Woman.getD();
		this.e = Woman.getE();
		this.f = Woman.getF();
		this.x = woman.getWeight();
		this.woman = woman;
	}

	public Wilks(Man man) {
		super();
		this.a = Man.getA();
		this.b = Man.getB();
		this.c = Man.getC();
		this.d = Man.getD();
		this.e = Man.getE();
		this.f = Man.getF();
		this.x = man.getWeight();
		this.man = man;
	}

	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}

	public Double getC() {
		return c;
	}

	public void setC(Double c) {
		this.c = c;
	}

	public Double getD() {
		return d;
	}

	public void setD(Double d) {
		this.d = d;
	}

	public Double getE() {
		return e;
	}

	public void setE(Double e) {
		this.e = e;
	}

	public Double getF() {
		return f;
	}

	public void setF(Double f) {
		this.f = f;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getCoeff() {
		return coeff;
	}

	public void setCoeff(Double coeff) {
		this.coeff = coeff;
	}

	public Double getLiftAmount() {
		return liftAmount;
	}

	public void setLiftAmount(Double liftAmount) {
		this.liftAmount = liftAmount;
	}

	public Double showCoeff() {
		coeff = 500 / (a + b * x + c * Math.pow(x, 2) + d * Math.pow(x, 3) + e
				* Math.pow(x, 4) + f * Math.pow(x, 5));
		return coeff;

	}

	public Double formulaTotalWoman() {

		return coeff * woman.getSupine().getLiftAmount();

	}

	public Double formulaTotalMan() {

		return coeff * man.getSupine().getLiftAmount();

	}

	public static void main(String args[]) {

		Man man = new Man();

		man.setName("Fernando");
		man.setWeight(94.0);
		Supine supineMan = new Supine(100.0);
		man.setSupine(supineMan);

		Wilks wilksMan = new Wilks(man);

		Woman woman = new Woman();

		woman.setName("Fulana");
		woman.setWeight(60.0);
		Supine supineWoman = new Supine(46.0);
		woman.setSupine(supineWoman);

		Wilks wilksWoman = new Wilks(woman);

		System.out.println("-------------------------------------------");
		System.out.println(" Wilks Calculator");
		System.out.println("-------------------------------------------");

		System.out.println("Coeff Man " + wilksMan.showCoeff());

		System.out.println("Coeff Woman " + wilksWoman.showCoeff());

		System.out.println("-------------------------------------------");

		System.out.println("Wilk points Man " + wilksMan.formulaTotalMan());
		System.out.println("Wilk points Woman "
				+ wilksWoman.formulaTotalWoman());

		System.out.println("-------------------------------------------");

	}
}