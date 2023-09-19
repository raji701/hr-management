package com.hrmanagement.portal.service;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.hrmanagement.portal.model.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.springframework.stereotype.Service;

@Service
public class CSVFileReader {

    public static List<Employee> readCSVFile(InputStream inputStream) throws IOException {
        List<Employee> employees = new ArrayList<>();

        try (Reader reader = new InputStreamReader(inputStream);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            for (CSVRecord csvRecord : csvParser) {
                // Assuming the CSV columns are in the order: EmployeeId, UserId, FirstName, LastName, Email, Phone, EmployeeAddress, Salary, DepartmentId, EmploymentType
                Employee employee = new Employee();
                
                try {
                    employee.setEmployeeId(Integer.parseInt(csvRecord.get(0)));
                } catch (NumberFormatException e) {
                    // Handle the exception (e.g., log it, skip the record, or set a default value)
                    continue; // Skip this record and continue with the next one
                }

                employee.setUserId(csvRecord.get(1));
                employee.setFirstName(csvRecord.get(2));
                employee.setLastName(csvRecord.get(3));
                employee.setEmail(csvRecord.get(4));
                employee.setPhone(csvRecord.get(5));
                employee.setEmployeeAddress(csvRecord.get(6));
                
                try {
                    employee.setSalary(Double.parseDouble(csvRecord.get(7)));
                } catch (NumberFormatException e) {
                    // Handle the exception (e.g., log it, set a default value, or skip the record)
                    continue; // Skip this record and continue with the next one
                }
                
                try {
                    employee.setDepartmentId(Integer.parseInt(csvRecord.get(8)));
                } catch (NumberFormatException e) {
                    // Handle the exception (e.g., log it, set a default value, or skip the record)
                    continue; // Skip this record and continue with the next one
                }

                employee.setEmploymentType(csvRecord.get(9));

                employees.add(employee);
            }
        }

        return employees;
    }
}
