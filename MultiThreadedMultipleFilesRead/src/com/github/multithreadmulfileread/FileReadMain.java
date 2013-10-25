/**
 * 
 */
package com.github.multithreadmulfileread;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Anupam Gangotia
 * Profile::http://en.gravatar.com/gangotia
 * github::https://github.com/agangotia
 */
public class FileReadMain {
	
	
	ArrayList<String> pathsNNamesOfFilesToRead=new ArrayList<String>();
	private static final int NTHREDS = 5;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReadMain objMain=new FileReadMain();
		objMain.initializeFileNames();
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
	    for (int i = 0; i < 10; i++) {
	      Runnable worker;
		try {
			worker = new FileRead("thread_"+i,objMain.pathsNNamesOfFilesToRead.get(i));
			executor.execute(worker);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	    }
	    
	    // This will make the executor accept no new threads
	    // and finish all existing threads in the queue
	    executor.shutdown();
	    // Wait until all threads are finish
	    while (!executor.isTerminated()) {
        }
	    System.out.println("Finished all threads");

	}
	
	public void initializeFileNames(){
		for(int i=0;i<10;i++){
			String Path="C:\\Users\\anugan\\git\\MultiThreadedMultipleFilesRead\\MultiThreadedMultipleFilesRead\\TextFiles\\";
			String FileName="file_"+i+".txt";
			this.pathsNNamesOfFilesToRead.add(Path+FileName);
			
		}
	} 

}
