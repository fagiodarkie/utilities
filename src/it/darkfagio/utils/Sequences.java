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

import java.util.List;

public class Sequences {

	public static short[] shortArrayFromString(String dividend, String exp) {
		String d = dividend.trim();
		if (d.compareTo("[]") == 0)
			return new short[0];
		String[] res = d.substring(1, d.length()-1).split(exp);
		short[] r = new short[res.length];
		for (int i = 0; i < res.length; ++i) {
			r[i] = Short.parseShort(res[i]);
		}
		return r;
	}
	
	public static String[] divideStringPer(String dividend, String exp) {
		if (dividend.equalsIgnoreCase("[]"))
			return new String[0];
		return dividend.substring(1, dividend.length()-1).split(exp);
	}

	public static String toString(short[] s) {
		return toString(s, ", ");
	}
	
	public static String toString(String[] s) {
		if (s.length == 0 || s == null)
			return "[]";
		String str = "[" + s[0];
		for (int i = 1; i < s.length; ++i) 
			str += ", " + s[i];
		return str + "]";
	}

	
	public static <E> String toString(List<E> charms) {
		if (charms == null || charms.size() == 0)
			return "[]";
		String ret = "[" + charms.get(0).toString();
		for (int i = 1; i < charms.size(); ++i)
			ret += (", " + charms.get(i).toString());
		return (ret + "]");
	}

	public static <E> String toString(List<E> charms, String string) {
		if (charms == null || charms.size() == 0)
			return "[]";
		String ret = "[" + charms.get(0).toString();
		for (int i = 1; i < charms.size(); ++i)
			ret += (string + charms.get(i).toString());
		return (ret + "]");
	}

	public static String toString(Object[] effects, String string) {
		if ((effects == null) || (effects.length == 0)) return "[]";
		String r = "[" + effects[0].toString();
		for (int i = 1; i < effects.length; ++i) r += string + effects[i].toString();
		return r + "]";
	}

	public static float[] parseFloatFromString(String string, String exp) {
		String[] res = divideStringPer(string, exp);
		float[] r = new float[res.length];
		for (int i = 0; i < res.length; ++i) {
			r[i] = Float.parseFloat(res[i]);
		}
		return r;
	}

	public static String toString(float[] weight) {
		return toString(weight, ", ");
	}

	public static int[] toIntArray(List<Integer> item) {
		int[] r = new int[item.size()];
		for (int i = 0; i < item.size(); ++i )
			r[i] = item.get(i);
		return r;
	}

	public static int[] intFromList(List<Integer> equippedItems) {
		int[] r = new int[equippedItems.size()];
		for (int i = 0; i < r.length; ++i)
			r[i] = equippedItems.get(i);
		return r;
	}

	public static String toString(float[] weight, String string) {
		if ((weight == null) || (weight.length == 0))
			return "[]";
		String r = "[" + weight[0];
		for (int i = 1; i < weight.length; ++i)
			r += string + weight[i];
		return r + "]";
	}

	public static String toString(short[] s, String string) {
		if (s.length == 0 || s == null)
			return "[]";
		String str = "[" + s[0];
		for (int i = 1; i < s.length; ++i) 
			str += string + s[i];
		return str + "]";
	}

	public static String toString(int[] s, String string) {
		if (s.length == 0 || s == null)
			return "[]";
		String str = "[" + s[0];
		for (int i = 1; i < s.length; ++i) 
			str += string + s[i];
		return str + "]";
	}

	public static int[] parseIntFromString(String string, String string2) {
		String[] res = divideStringPer(string, string2);
		int[] r = new int[res.length];
		for (int i = 0; i < res.length; ++i) {
			r[i] = Integer.parseInt(res[i]);
		}
		return r;
	}
	
	public static String toString(int[] s) {
		return toString(s, ", ");
	}

	public static String[] concatenate(String[] res, String[] res2) {
		String[] r = new String[res.length + res2.length];
		for(int i = 0; i < res.length; ++i)
			r[i] = res[i];
		for(int i = 0; i < res2.length; ++i)
			r[i + res.length] = res2[i];
		return r;
	}

}
