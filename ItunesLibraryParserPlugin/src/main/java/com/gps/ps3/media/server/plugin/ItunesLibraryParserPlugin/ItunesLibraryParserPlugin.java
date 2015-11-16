package com.gps.ps3.media.server.plugin.ItunesLibraryParserPlugin;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Calendar;

import javax.swing.JComponent;

import net.pms.dlna.DLNAResource;
import net.pms.dlna.virtual.VirtualFolder;
import net.pms.external.AdditionalFolderAtRoot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gps.itunes.lib.exceptions.LibraryParseException;
import com.gps.itunes.lib.exceptions.NoChildrenException;
import com.gps.ps3.media.server.plugin.controller.PluginController;
import com.gps.ps3.media.server.plugin.ui.PluginUI;
import com.gps.ps3.media.server.plugin.ui.controller.PluginUIEventRegistrar;

/**
 * Itunes Library Parser Plugin.
 * 
 * @author leogps
 *
 */
public class ItunesLibraryParserPlugin implements AdditionalFolderAtRoot {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ItunesLibraryParserPlugin.class);
	
	private VirtualFolder parsedLibraryFolder;
	private final PluginHelper helper = new PluginHelper();
	private final PluginController controller;
	private PluginUI pluginUI;
	
	public ItunesLibraryParserPlugin() throws NoChildrenException, LibraryParseException, MalformedURLException, UnsupportedEncodingException {
		LOGGER.info("Initializing Itunes Library Parser Plugin...");
		parsedLibraryFolder = new VirtualFolder("Itunes Library [plugin by #leogps]", null);
		
		
		LOGGER.info("Loading Itunes Library...");
		try{
			
			VirtualFolder playlistFolder = new VirtualFolder("loaded at " + Calendar.getInstance().getTime(), null);
			helper.loadLibraryData(playlistFolder);
			
			parsedLibraryFolder.addChild(playlistFolder);
			
			LOGGER.info("Itunes Library loaded successfully");
			
		} catch(Exception ex) {
			
			LOGGER.error("Library file could not be loaded/parsed. Continuing with loading the plugin UI.", ex);
			LOGGER.info("Note: Try and load the library from the UI if it's at a custom path.");
			
		}
		
		pluginUI = new PluginUI();
		controller = new PluginController(parsedLibraryFolder, pluginUI);
		
		new PluginUIEventRegistrar(pluginUI).addPluginUIEventListener(controller);
		
	}

	public JComponent config() {
		return pluginUI.getRootPanel();
	}

	public String name() {
		return "Itunes Library Parser";
	}

	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

	public DLNAResource getChild() {
		LOGGER.info("Itunes Library Parser Plugin - Creating Itunes Library folder");
		return parsedLibraryFolder;
	}

}
