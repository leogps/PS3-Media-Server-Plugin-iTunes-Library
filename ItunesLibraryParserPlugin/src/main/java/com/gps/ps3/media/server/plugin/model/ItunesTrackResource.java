package com.gps.ps3.media.server.plugin.model;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

import net.pms.dlna.RealFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gps.itunes.lib.items.tracks.Track;

/**
 * PMS equivalent media file.
 * 
 * @author leogps
 *
 */
public class ItunesTrackResource extends RealFile implements ItunesLibraryResourceInterface {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ItunesTrackResource.class);
	
	private final Track track;
	private final File file;
	
	public ItunesTrackResource(Track track) throws MalformedURLException, UnsupportedEncodingException {
		super(fetchFile(track));
		this.track = track;
		this.file = fetchFile(track);
		LOGGER.debug("Itunes Track fetched: " + track.getTrackName());
	}
	
	@Override
	public File getFile() {
		return file;
	}
	
	public Track getTrack() {
		return track;
	}

	private static File fetchFile(Track track) throws MalformedURLException, UnsupportedEncodingException {
		if(track.getLocation() != null) {
			final URL srcUrl = new URL(track.getLocation());
			File file = new File(URLDecoder.decode(srcUrl.getFile(),
					"UTF-8"));

			return file;
		}
		return new File("N/A");
	}
	
	@Override
	public boolean isFolder() {
		return false;
	}

}
