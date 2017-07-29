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

package it.darkfagio.utils.gui;

import javax.swing.JDialog;
import javax.swing.JPanel;

public abstract class DialogPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	protected JDialog superDialog;
	
	public abstract String getTitle();
	
	public void setDialog (JDialog d) {
		this.superDialog = d;
		d.setTitle(getTitle());
	}
	
}
