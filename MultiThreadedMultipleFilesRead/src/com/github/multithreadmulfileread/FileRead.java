package com.github.multithreadmulfileread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Anupam Gangotia
 * Profile::http://en.gravatar.com/gangotia
 * github::https://github.com/agangotia
 */
public class FileRead implements Runnable {

	private String threadName;
	BufferedReader inputStream;

	FileRead(String thrdName, String fileNameWPath)
			throws FileNotFoundException {
		this.threadName = thrdName;
		inputStream = new BufferedReader(new FileReader(fileNameWPath));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String l;
			while ((l = inputStream.readLine()) != null) {
				System.out.println(threadName + "::" + l);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
