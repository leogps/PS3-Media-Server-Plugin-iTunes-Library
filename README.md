# PS3-Media-Server-Plugin-iTunes-Library
This is a PS3 Media Server (PMS) plugin that reads (parses) your Itunes Library (xml file) and shows it as a folder under the Media Server.


1. Download the ItunesLibraryParserPlugin-v2.0.0.zip file and unzip its contents.
2. Copy the unzipped contents - (.jar) file and (config) folder into the PS3 Media Server
plugins folder.
3. Plugin Folder: 
Mac Users: Open Applications, right-click on 'PS3 Media Server' > Show Package Contents >
Contents > Resources > Java > plugins
Windows Users: C:/Program Files (x86)/PS3 Media Server/plugins
4. Start the PS3 Media Server and you should see this message in the logs tab:
'Found plugin: com.gps.ps3.media.server.plugin.ItunesLibraryParserPlugin.ItunesLibraryParserPlugin'
5. To add the Itunes Library file manually once the plugin is loaded:
From PS3 Media Server, go to:
'General Configuration'
scroll all the way to the bottom and you should see a button 'Itunes Library Parser'
Click the button and browse to the ItunesLibrary(.xml) file and refresh or reconnect to the Media 
Server from PS3 (DLNA device). You should now see another iTunes library folder with a number at the end.


[License](http://creativecommons.org/licenses/by/4.0/legalcode)

[License summary](http://creativecommons.org/licenses/by/4.0/)

[Download PMS Plugin](http://sourceforge.net/projects/ituneslibparser-pms/files/v2.0.0/ItunesLibraryParserPlugin-v2.0.0.zip/download)

# PS3 Media Server (PMS)

PS3 Media Server is a DLNA-compliant UPnP Media Server.
Originally written to support the PlayStation 3, PS3 Media Server has been expanded to support a range of other media renderers, including smartphones, TVs, music players and more - all of which are listed on the right.
Because it is written in Java, PS3 Media Server supports all major operating systems, with versions for Windows, Linux and Mac OS X.
The program streams or transcodes many different media formats with little or no configuration.
It is powered by MEncoder, FFmpeg, tsMuxeR and AviSynth, which combine to offer support for a wide range of media formats.

[PS3 Media Server](http://www.ps3mediaserver.org)
[Github](https://github.com/ps3mediaserver/ps3mediaserver)
[Plugins](http://www.ps3mediaserver.org/forum/viewtopic.php?f=12&t=9078)
