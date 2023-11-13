package javaBasic;

import java.io.File;

public class Topic_05_Upload_Files {

	static String[] fileNameList = { "chibiImage.jpeg", "doremonImage.jpeg", "funnyImage.jpeg" };

	static String fullFileName = "";

	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator;
		System.out.println(filePath);

		for (String eachFile : fileNameList) {
			System.out.println(eachFile);
			fullFileName = fullFileName + filePath + eachFile + "\n";
			System.out.println(fullFileName);

		}
		
		System.out.println("Full File Name: " + fullFileName);
		fullFileName = fullFileName.trim();
		
		System.out.println(fullFileName);

	}

}
