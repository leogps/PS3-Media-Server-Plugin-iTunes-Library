package com.gps.ps3.media.server.plugin.ui.component;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Created with IntelliJ IDEA.
 * User: leogps
 * Date: 9/22/13
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class LibraryFileChooser extends JFileChooser {

    /**
	 * 
	 */
	private static final long serialVersionUID = -788061805876944603L;

	public LibraryFileChooser() {

        super(System.getProperty("user.home"));

        this.setDialogTitle("Select iTunes Library XML file, usually named as: 'iTunes Music Library.xml'");

        FileFilter fileFilter = new FileNameExtensionFilter(
                "(.xml) files only", "xml");

        this.setAcceptAllFileFilterUsed(false);
        this.addChoosableFileFilter(fileFilter);
        this.setFileFilter(fileFilter);

    }

}
