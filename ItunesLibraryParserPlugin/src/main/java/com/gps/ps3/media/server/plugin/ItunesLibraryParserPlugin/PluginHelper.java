package com.gps.ps3.media.server.plugin.ItunesLibraryParserPlugin;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import com.gps.itunes.lib.parser.ItunesLibraryParsedData;
import com.gps.itunes.lib.parser.ItunesLibraryParser;
import com.gps.itunes.lib.parser.utils.PropertyManager;
import net.pms.dlna.virtual.VirtualFolder;

import com.gps.itunes.lib.exceptions.LibraryParseException;
import com.gps.itunes.lib.exceptions.NoChildrenException;
import com.gps.itunes.lib.items.playlists.Playlist;
import com.gps.itunes.lib.items.tracks.Track;
import com.gps.itunes.lib.tasks.LibraryParser;
import com.gps.itunes.lib.tasks.ProgressInformer;
import com.gps.ps3.media.server.plugin.model.ItunesLibraryResourceInterface;
import com.gps.ps3.media.server.plugin.model.ItunesPlaylistResource;
import com.gps.ps3.media.server.plugin.model.ItunesResourceFetchProgressInformation;
import com.gps.ps3.media.server.plugin.model.ItunesTrackResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Plugin Helper.
 * 
 * @author leogps
 *
 */
public class PluginHelper {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(PluginHelper.class);

	/**
	 * Loads Itunes Library data using {@link LibraryParser LibraryParser} and
	 * generates corresponding PMS folder structure.
	 *
	 * @param parsedLibraryFolder
	 *            - maps this object as the root of the library folder structure
	 * @throws LibraryParseException
	 * @throws NoChildrenException
	 * @throws MalformedURLException
	 * @throws UnsupportedEncodingException
	 */
	public void loadLibraryData(VirtualFolder parsedLibraryFolder, ProgressInformer<ItunesResourceFetchProgressInformation>... informers)
			throws LibraryParseException, NoChildrenException,
			MalformedURLException, UnsupportedEncodingException {
        loadLibraryData(parsedLibraryFolder, null, informers);
	}

	/**
	 * Loads Itunes Library located at the provided location and parses it using
	 * {@link LibraryParser LibraryParser} and generates corresponding PMS
	 * folder structure. 
	 * 
	 * 
	 * @param parsedLibraryFolder
	 *            - maps this object as the root of the library folder
	 *            structure.
	 * @param path
	 *            - The library file location.
	 * @throws LibraryParseException
	 * @throws NoChildrenException
	 * @throws MalformedURLException
	 * @throws UnsupportedEncodingException
	 */
	public void loadLibraryData(VirtualFolder parsedLibraryFolder, String path, ProgressInformer<ItunesResourceFetchProgressInformation>... informers)
			throws LibraryParseException, NoChildrenException,
			MalformedURLException, UnsupportedEncodingException {

		ItunesLibraryParser parser = new LibraryParser();
        if(path != null) {
            parser.addParseConfiguration(PropertyManager.Property.LIBRARY_FILE_LOCATION_PROPERTY.getKey(),
                    path);
        }

        LOGGER.info(PropertyManager.getConfigurationMap().toString());

		ItunesLibraryParsedData itunesLibraryParsedData = parser.parse();

		Playlist[] playlistArray = itunesLibraryParsedData.getAllPlaylists();

		for (Playlist playlist : playlistArray) {
			ItunesPlaylistResource libraryPlaylist = new ItunesPlaylistResource(
					playlist);
			
			informProgress(libraryPlaylist, informers);
			
			parsedLibraryFolder.addChild(libraryPlaylist);

			Track[] tracks = itunesLibraryParsedData.getPlaylistTracks(playlist.getPlaylistId());

			for (Track track : tracks) {
				ItunesTrackResource libraryTrack = new ItunesTrackResource(
						track);
				
				informProgress(libraryTrack, informers);
				
				libraryPlaylist.addChild(libraryTrack);
			}
		}

	}

	private void informProgress(ItunesLibraryResourceInterface libraryResource,
			ProgressInformer<ItunesResourceFetchProgressInformation>[] informers) {
		if(informers != null) {
			for(ProgressInformer<ItunesResourceFetchProgressInformation> informer : informers) {
				
				ItunesResourceFetchProgressInformation progressInformation = new ItunesResourceFetchProgressInformation();
				progressInformation.setInformation(libraryResource);
				
				informer.informProgress(progressInformation);
			}
		}
		
	}

}
