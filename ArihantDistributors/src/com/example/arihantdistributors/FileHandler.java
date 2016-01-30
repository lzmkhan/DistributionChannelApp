package com.example.arihantdistributors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;

public class FileHandler {

	Context c;
	
	
private String makeName(String fileName)
{
	return fileName + ".zaf";
}
	
public boolean saveToFile(String fileName, String Contents)
    {
    	boolean status = true;
    	String fileNameComplete = makeName(fileName);
    	   
    	   try {
    		   File f =new File(fileNameComplete);
    		   if(f.exists())
    		   c.deleteFile(fileNameComplete);
    		  
    		    FileOutputStream fos = c.openFileOutput(fileNameComplete, Context.MODE_PRIVATE);

    		    fos.write(Contents.getBytes());

    		    fos.close();

    		} catch (Exception e) {
    			status = false;
    		    e.printStackTrace();

    		}
    		return status;
    }


public String readFromFile(String fileName)
{
	String fileNameComplete = makeName(fileName);
	
    StringBuffer  stringBuffer = new StringBuffer();  
	
	try {

		 BufferedReader inputReader = new BufferedReader(new InputStreamReader(

				 c.openFileInput(fileNameComplete)));

		 String inputString;

            

		 while ((inputString = inputReader.readLine()) != null) {

			 stringBuffer.append(inputString);

		 	}


	 	} catch (IOException e) {

	 		e.printStackTrace();

	 		}
	
	return stringBuffer.toString();
	
}


public void cleanFile(String fileName)
{
	String fileNameComplete = makeName(fileName);
	
	 try {
		   File f =new File(fileNameComplete);
		   if(f.exists())
		   c.deleteFile(fileNameComplete);
		  
		    FileOutputStream fos = c.openFileOutput(fileNameComplete, Context.MODE_PRIVATE);

		    fos.write("".getBytes());

		    fos.close();

		} catch (Exception e) {
		
		    e.printStackTrace();

		}
	 
}

}
