package com.gps.ps3.media.server.plugin.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gps.ps3.media.server.plugin.ui.PluginUI;
import com.gps.ps3.media.server.plugin.ui.component.LibraryFileChooser;
import com.gps.ps3.media.server.plugin.ui.eventlistener.PluginUIEventListener;

/**
 * Registers all the UI events for the UI.
 * 
 * Created with IntelliJ IDEA.
 * User: leogps
 * Date: 9/22/13
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class PluginUIEventRegistrar {

    private final PluginUI pluginUI;
    private final List<PluginUIEventListener> pluginUIEventListenerList = new ArrayList<PluginUIEventListener>();
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PluginUIEventRegistrar.class);

    public PluginUIEventRegistrar(final PluginUI pluginUI) {

        this.pluginUI = pluginUI;

    	registerEvents();
    	
    	addPluginUIEventListener(new PluginUIEventListener() {
		
    		public void onLibraryFileSelect(File file) {
				pluginUI.getStatusMessageLabel().setText("File loaded.");
				pluginUI.getLibraryFilePathTextField().setText(file.getAbsolutePath());
				
			}
		});
    }

    private void registerEvents() {
        // Registering browse button action listener.
        pluginUI.getBrowseButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				LOGGER.debug("Browse button clicked.");

		        JFileChooser jFileChooser = new LibraryFileChooser();

		        int returnVal = jFileChooser.showOpenDialog(pluginUI);

		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		        	for(PluginUIEventListener pluginUIEventListener : pluginUIEventListenerList) {
		        		pluginUIEventListener.onLibraryFileSelect(jFileChooser.getSelectedFile());
		        	}
		        }
				
			}
        	
        });
    }
    
    /**
     * Add PluginUIEventListener to listen and take action on event occurrence.
     * 
     * @param pluginUIEventListener
     */
    public void addPluginUIEventListener(PluginUIEventListener pluginUIEventListener) {
    	pluginUIEventListenerList.add(pluginUIEventListener);
    }


}
