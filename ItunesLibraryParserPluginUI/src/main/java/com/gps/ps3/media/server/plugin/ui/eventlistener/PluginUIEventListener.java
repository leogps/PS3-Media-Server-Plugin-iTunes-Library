package com.gps.ps3.media.server.plugin.ui.eventlistener;

import java.io.File;

/**
 * UI event listener.
 * 
 * @author leogps
 *
 */
public interface PluginUIEventListener {
	
	/**
	 * This is invoked when the user selects a 'library' file from the UI.
	 * 
	 * @param selected file.
	 */
	public void onLibraryFileSelect(File file);

}
