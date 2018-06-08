package com.techlabs.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebFileLoader implements ILoadable {
	private URL url;
	BufferedReader bufferedReader;

	public WebFileLoader(String url) throws MalformedURLException {
		this.url = new URL(url);
	}

	@Override
	public String fileContentReader() throws IOException {
		URLConnection urlConnection = url.openConnection();
		String currentLine="",fileContent="";
		bufferedReader =  new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		while ((currentLine = bufferedReader.readLine()) != null) {
			fileContent = fileContent + currentLine+"\n";
		}
		return fileContent;
	}
}