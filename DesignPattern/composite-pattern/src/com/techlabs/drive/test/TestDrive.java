package com.techlabs.drive.test;

import com.techlabs.drive.FileItem;
import com.techlabs.drive.FolderItem;

public class TestDrive {
	public static void main(String args[]){
		FolderItem movie= new FolderItem("Movie");
		FolderItem movieType1 = new FolderItem("Bollywood");
		FolderItem movieType2 = new FolderItem("Hollywood");
		
		FolderItem movieNames1 = new FolderItem("Krish");
		FolderItem movieNames2 = new FolderItem("Sholay");
		FolderItem movieNames3 = new FolderItem("Titanic");
		FolderItem movieNames4 = new FolderItem("Taken");
		
		FolderItem movieSeries1 = new FolderItem("Krish1");
		FolderItem movieSeries2 = new FolderItem("Krish2");

		FileItem movieFile1 = new FileItem("Krish1", 2074.43, "mkv");
		FileItem movieFile2 = new FileItem("Krish2", 2056.43, "avi");
		FileItem movieFile3 = new FileItem("Sholay", 1024.12, "mp4");
		
		FolderItem movieSeries3 = new FolderItem("Taken1");
		FolderItem movieSeries4 = new FolderItem("Taken2");
		
		FileItem movieFile4 = new FileItem("Titanic", 3193.43, "mkv");
		FileItem movieFile5 = new FileItem("Taken1", 3066.43, "avi");
		FileItem movieFile6 = new FileItem("Taken2", 4062.43, "mp4");
				
		movieSeries1.add(movieFile1);
		movieSeries2.add(movieFile2);
		movieSeries3.add(movieFile5);
		movieSeries4.add(movieFile6);
		
		movieNames1.add(movieSeries1);
		movieNames1.add(movieSeries2);
		movieNames2.add(movieFile3);
		movieNames3.add(movieFile4);
		movieNames4.add(movieSeries3);
		movieNames4.add(movieSeries4);
		
		movieType1.add(movieNames1);
		movieType1.add(movieNames2);
		
		movieType2.add(movieNames3);
		movieType2.add(movieNames4);

		movie.add(movieType1);
		movie.add(movieType2);
		
		movie.showContent(0);
		
	}
}
