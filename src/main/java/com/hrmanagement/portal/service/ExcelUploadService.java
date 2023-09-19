package com.hrmanagement.portal.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.hrmanagement.portal.model.Employee;

public class ExcelUploadService {
    public static boolean isValidExcelFile(MultipartFile file){
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" );
    }
  public static List<Employee> getEmployeeDataFromExcel(InputStream inputStream){
        List<Employee> employees = new ArrayList<>();
       try {
          XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
           XSSFSheet sheet = workbook.getSheet("Employees");
           int rowIndex =0;
           for (Row row : sheet){
               if (rowIndex ==0){
                   rowIndex++;
                   continue;
               }
               Iterator<Cell> cellIterator = row.iterator();
               int cellIndex = 0;
               Employee employee = new Employee();
               while (cellIterator.hasNext()){
                   Cell cell = cellIterator.next();
                   switch (cellIndex){
                       case 0 -> employee.setEmployeeId((int) cell.getNumericCellValue());
                       case 1 -> employee.setUserId(cell.getStringCellValue());
                       case 2 -> employee.setFirstName(cell.getStringCellValue());
                       case 3 -> employee.setLastName(cell.getStringCellValue());
                       case 4 -> employee.setEmail(cell.getStringCellValue());
                       case 5 -> employee.setPhone(cell.getStringCellValue());
                       case 6 -> employee.setEmployeeAddress(cell.getStringCellValue());
                       case 7 -> employee.setSalary(cell.getNumericCellValue()); 
                       case 8 -> employee.setDepartmentId((int)cell.getNumericCellValue());
                       case 9 -> employee.setEmploymentType(cell.getStringCellValue());
                       default -> {
                       }
                   }
                   cellIndex++;
               }
               employees.add(employee);
           }
           workbook.close();
       } catch (IOException e) {
           e.getStackTrace();
       }
       return employees;
   }

}