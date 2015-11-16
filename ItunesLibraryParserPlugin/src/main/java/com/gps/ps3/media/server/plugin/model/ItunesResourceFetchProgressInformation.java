package com.gps.ps3.media.server.plugin.model;

import com.gps.itunes.lib.tasks.progressinfo.ProgressInformation;

public class ItunesResourceFetchProgressInformation implements ProgressInformation<ItunesLibraryResourceInterface>{
	
	private ItunesLibraryResourceInterface itunesLibraryResource;

	public void setInformation(ItunesLibraryResourceInterface info) {
		this.itunesLibraryResource = info;
		
	}

	public ItunesLibraryResourceInterface getInformation() {
		return itunesLibraryResource;
	}

}
