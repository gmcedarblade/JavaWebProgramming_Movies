package edu.cvtc.web.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import edu.cvtc.web.model.Movie;

/**
 * @author gcedarblade
 *
 */
public class WorkbookUtility {

	public static List<Movie> retrieveMoiveFromWorkbook(final File inputFile) throws InvalidFormatException, IOException {
		
		final List<Movie> movies = new ArrayList<>();
		
		// Get Workbook from Excel spreadsheet
		final Workbook workbook = WorkbookFactory.create(inputFile);
		
		// Get the first Worksheet in the Workbook
		final Sheet sheet = workbook.getSheetAt(0);
		
		for (final Row row : sheet) {
			
			final Cell titleCell = row.getCell(0);
			final Cell lengthInMinutesCell = row.getCell(1);
			final Cell directorCell = row.getCell(2);
			
			final Movie movie = new Movie(
										titleCell.getStringCellValue().trim(),
										(int) lengthInMinutesCell.getNumericCellValue(),
										directorCell.getStringCellValue().trim());
					
			movies.add(movie);
			
		}
		
		return movies;
		
	}
	
}
