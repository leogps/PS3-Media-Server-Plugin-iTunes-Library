package com.gps.ps3.media.server.plugin.controller;

import javax.swing.SwingUtilities;

import com.gps.itunes.lib.tasks.ProgressInformer;
import com.gps.ps3.media.server.plugin.model.ItunesPlaylistResource;
import com.gps.ps3.media.server.plugin.model.ItunesResourceFetchProgressInformation;
import com.gps.ps3.media.server.plugin.model.ItunesTrackResource;
import com.gps.ps3.media.server.plugin.ui.PluginUI;

public class ItunesLibraryFetchProgressInformer implements ProgressInformer<ItunesResourceFetchProgressInformation>{
	
	private PluginUI pluginUI;

	public ItunesLibraryFetchProgressInformer(PluginUI pluginUI) {
		this.pluginUI = pluginUI;
		
	}

	public void informProgress(ItunesResourceFetchProgressInformation t) {
		
		if(t.getInformation() instanceof ItunesPlaylistResource) {
			final ItunesPlaylistResource itunesPlaylistResource = (ItunesPlaylistResource) t.getInformation();
			
			SwingUtilities.invokeLater(new Runnable() {
				
				public void run() {
					pluginUI.getStatusMessageLabel().setText("Playlist loaded: " + itunesPlaylistResource.getName());
					
				}
			});
			
			
			
			
		} else if(t.getInformation() instanceof ItunesTrackResource) {
			final ItunesTrackResource itunesTrackResource = (ItunesTrackResource) t.getInformation();
			
			SwingUtilities.invokeLater(new Runnable() {
				
				public void run() {
					pluginUI.getStatusMessageLabel().setText("Track loaded: " + itunesTrackResource.getName());
				}
			});

		}
		
	}

}
