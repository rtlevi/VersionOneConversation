/**
 * Grace Tshihata
 * 
 * */
package com.davita.restAssured;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvWriter;
import com.davita.config.DataConfig;

public class MyCsvFile extends DataConfig{
	

	public static void WriteToCsvFile(String id, String comment) {
		
		String outputFile = CSV_OUTPUT_FILE;
		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(outputFile).exists();
			
		try {
			// use FileWriter constructor that specifies open for appending
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
			
			// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				csvOutput.write(ID);
				csvOutput.write(COMMENT);
				csvOutput.write(SUMMARY);
				csvOutput.endRecord();
			}
			// else assume that the file already has the correct header line
			
			// write out a few records
			csvOutput.write(id);
			csvOutput.write(comment);
			csvOutput.endRecord();
			
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
//	public static void main(String[] args) {
//		WriteToCsvFile("B-125","Now i believe it is off!");
//	}

}
