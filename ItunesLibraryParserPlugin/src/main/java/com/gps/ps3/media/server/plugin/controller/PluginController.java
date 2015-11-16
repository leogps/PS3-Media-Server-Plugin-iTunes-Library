package com.gps.ps3.media.server.plugin.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Calendar;

import javax.swing.JOptionPane;

import net.pms.dlna.virtual.VirtualFolder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gps.itunes.lib.exceptions.LibraryParseException;
import com.gps.itunes.lib.exceptions.NoChildrenException;
import com.gps.ps3.media.server.plugin.ItunesLibraryParserPlugin.PluginHelper;
import com.gps.ps3.media.server.plugin.ui.PluginUI;
import com.gps.ps3.media.server.plugin.ui.eventlistener.PluginUIEventListener;

/**
 * Controls the plugin UI => Translates the user interaction with plugin UI into PMS plugin action.
 * 
 * @author leogps
 *
 */
public class PluginController implements PluginUIEventListener {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PluginController.class);

	private final PluginHelper helper = new PluginHelper();
	private final VirtualFolder rootLibraryFolder;
	private static int playlistLoadCount = 0;
	private final PluginUI pluginUI;
	private final ItunesLibraryFetchProgressInformer itunesLibraryFetchProgressInformer;

	public PluginController(VirtualFolder rootLibraryFolder, PluginUI pluginUI) {
		this.rootLibraryFolder = rootLibraryFolder;
		this.pluginUI = pluginUI;
		this.itunesLibraryFetchProgressInformer = new ItunesLibraryFetchProgressInformer(pluginUI);
	}

	public void onLibraryFileSelect(File file) {
		try {

			VirtualFolder newLibraryFolder = new VirtualFolder("Playlist count - "
							+ ++playlistLoadCount + " - loaded at " + Calendar.getInstance().getTime(), null);
			
			
			helper.loadLibraryData(newLibraryFolder, file.getAbsolutePath(), itunesLibraryFetchProgressInformer);
			
			this.rootLibraryFolder.addChild(newLibraryFolder);

		} catch (MalformedURLException e) {

			JOptionPane
					.showMessageDialog(
							null,
							"The file could not be read. Is the file available? See debug log for more information.");
			LOGGER.error("The file could not be read.", e);

		} catch (UnsupportedEncodingException e) {

			JOptionPane
					.showMessageDialog(null,
							"The file could not be parsed. See debug log for more information.");
			LOGGER.error("The file could not be parsed.", e);

		} catch (LibraryParseException e) {

			JOptionPane
					.showMessageDialog(null,
							"The file could not be parsed. See debug log for more information.");
			LOGGER.error("The file could not be parsed.", e);

		} catch (NoChildrenException e) {

			JOptionPane
					.showMessageDialog(
							null,
							"The file could not be parsed. The playlist file may be corrupted. See debug log for more information.");
			LOGGER.error("The file could not be parsed.", e);

		}

	}

}
