package com.loop.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelClass {
    public static void main(String[] args) throws FileNotFoundException, IOException {

//        FileInputStream efile = new FileInputStream("src/test/resources/Collection (2).xlsx");
//
//        Workbook wb = WorkbookFactory.create(efile);
//        Sheet sh = wb.getSheet("List");
//        Cell cell = sh.getRow(2).getCell(4);
//        String cellData = cell.toString();
//        System.out.println("cellData = " + cellData);

 ExcelUtils exUt = new ExcelUtils("/Users/annaivankovich/IdeaProjects/Cucumber_Practice/src/test/resources/Untitled.xlsx", "Sheet1");

        System.out.println(exUt.getCellData(2, 3));


    }
}
