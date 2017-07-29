/*
    utilities is a collection of useful and commonly used classes for
    formatting strings and displaying Swing GUIs
    
    Copyright (C) 2014 - 2017  Jacopo Freddi

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */

package it.darkfagio.utils;

import java.math.BigInteger;

public class DoubleDigitDecimal {
	
	private BigInteger intPart;
	
	public DoubleDigitDecimal(double d) {
		d *= 100;
		String[] x = Format.formatDecimal(d).split("\\.");
		intPart = new BigInteger(x[0]);
	}
		
	public DoubleDigitDecimal(String s) {
		String[] x = Format.formatDecimal(s).split("\\.");
		intPart = new BigInteger(x[0]).multiply(new BigInteger("100"));
		intPart = intPart.add(new BigInteger(x[1]));
	}

	public DoubleDigitDecimal(DoubleDigitDecimal doubleDigitDecimal) {
		intPart = doubleDigitDecimal.intPart;
	}

	public DoubleDigitDecimal(BigInteger i) {
		intPart = i;
	}

	public DoubleDigitDecimal add(DoubleDigitDecimal d) {
		BigInteger i = intPart.add(d.intPart);
//		System.out.println("addition result is: " + i.toString());
		return new DoubleDigitDecimal(i);
	}
	public DoubleDigitDecimal add(double d) {
		return add(new DoubleDigitDecimal(d));
	}
	public DoubleDigitDecimal subtract(DoubleDigitDecimal d) {
		return add(d.invert());
	}
	public DoubleDigitDecimal invert() {
		DoubleDigitDecimal n = new DoubleDigitDecimal(this);
		n.intPart = n.intPart.negate();
//		System.out.println(toString() + " negated is " + n.toString());
		return n;
	}

	public DoubleDigitDecimal subtract(double d) {
		return subtract(new DoubleDigitDecimal(d));
	}
	public double doubleValue() {
		return Double.parseDouble(toString());
	}
	public String toString() {
		BigInteger s[] = intPart.divideAndRemainder(new BigInteger("100"));
		if (s[1].signum() < 0) {
			return Format.formatDecimal((s[0].signum() > 0 ? "-" : "") + s[0] + "." + s[1].negate());
		}
		return Format.formatDecimal(s[0] + "." + s[1]);
	}
		
	public static void main(String[] args) {
		DoubleDigitDecimal a = new DoubleDigitDecimal(3.5),
				b = new DoubleDigitDecimal("5.2");
		
		System.out.println("a = " + a.toString());
		System.out.println("b = " + b.toString());
		System.out.println("a - 1 = " + a.subtract(1D).toString());
		System.out.println("b + 3.2 = " + b.add(3.2));
		System.out.println("a + b = " + a.add(b).toString());
		System.out.println("a - b = " + a.subtract(b).toString());
		System.out.println("should be " + (3.5 - 5.2));
		System.out.println("b - a = " + b.subtract(a).toString());		
		System.out.println("should be " + (-3.5 + 5.2));

	}
	
}
