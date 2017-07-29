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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class Format {
	public static String formatDecimal(String string) {
		String[] r = string.split("\\.");
		if (r.length < 2 || (r[1].length() == 0)) return r[0] + ".00";
		if (r[1].length() == 1) r[1] = r[1] + "0";
		return r[0] + "." + r[1].substring(0, 2);
	}
	
	public static String formatDecimal(double credit) {
		return formatDecimal(Double.toString(credit));
	}
	
	public static JTextField getNumericTextField() {
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
		decimalFormat.setGroupingUsed(false);
		JTextField r = new JFormattedTextField(decimalFormat);
		
		return r;
	}
	public static JTextField getNumericTextField(String string) {
		JTextField r = getNumericTextField();
		r.setText(string);
		return r;
	}
	public static JTextField getDecimalTextField() {
//		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormatSymbols s = new DecimalFormatSymbols();
		s.setDecimalSeparator('.');
		DecimalFormat decimalFormat = new DecimalFormat("###.##", s);
		decimalFormat.setGroupingUsed(false);
		JTextField r = new JFormattedTextField(decimalFormat);
		
		return r;
	}
	
	public static JTextField getDecimalTextField(String string) {
		JTextField r = getDecimalTextField();
		r.setText(string);
		return r;
	}
	
	public static String spaces(int n) {
		String r = "";
		for (int i = 0; i < n; ++i)
			r += " ";
		
		return r;

	}
	

}
