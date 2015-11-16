package com.gps.ps3.media.server.plugin.model;

import java.io.IOException;
import java.io.InputStream;

import net.pms.dlna.virtual.VirtualFolder;

import com.gps.itunes.lib.items.playlists.Playlist;

/**
 * Itunes Playlist as PMS virtual folder.
 * 
 * @author leogps
 *
 */
public class ItunesPlaylistResource extends VirtualFolder implements ItunesLibraryResourceInterface {
	
	private Playlist playlist;
	
	public ItunesPlaylistResource(Playlist playlist) {
		super(playlist.getName(), null);
		this.playlist = playlist;
	}

	/**
	 * Itunes Playlist is shown as a folder.
	 */
	@Override
	public boolean isFolder() {
		return true;
	}

	@Override
	public String getName() {
		return playlist.getName();
	}

	@Override
	public String getSystemName() {
		return getName();
	}

	@Override
	public long length() {
		return playlist.getPlaylistItems().length;
	}

	/**
	 * A playlist is kind of a virtual folder.
	 */
	@Override
	public InputStream getInputStream() throws IOException {
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

}
