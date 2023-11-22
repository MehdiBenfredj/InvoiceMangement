package com.invoice.mangement.ReportGenerator;


import com.invoice.mangement.employee.model.Employee;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileNotFoundException;

import java.util.List;

@Service
public class ReportGeneratorService {

    public void generateReport(List<Employee> employees) throws FileNotFoundException {
        List<String> data = generateDataRows(employees);

        File output = new File("src/main/resources/static/report.pdf");


        String template1 = """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Employee Report</title>
                    <style>
                        table {
                            width: 100%;
                            border-collapse: collapse;
                        }
                                
                        th, td {
                            border: 1px solid #ddd;
                            padding: 8px;
                        }
                                
                        th {
                            background-color: #4CAF50;
                            color: white;
                        }
                                
                        .total-cost {
                            margin-top: 20px;
                            font-weight: bold;
                        }
                    </style>
                </head>
                <body>
                    <h1>Employee Report</h1>
                    <table>
                        <tr>
                            <th>Full Name</th>
                            <th>Phone Number</th>
                            <th>Email</th>
                            <th>Salary</th>
                        </tr>
                        """;

        String employeesDataHRows = data.get(1);
        String tableTagClose = "</table>";
        String monthlyTotalCostDiv = """
                <div class="total-cost">
                        Monthly total cost: <!-- Total cost will go here -->"""
                + data.get(0) + " " +
                """
                $ </div>
                """;
        String templateClosingTags = """
                </body>
                </html>
                """;

        String finalTemplate = template1 +
                        employeesDataHRows +
                        tableTagClose +
                        monthlyTotalCostDiv +
                        templateClosingTags;

        HtmlConverter.convertToPdf(finalTemplate
                , new PdfWriter(output));
    }

    private List<String> generateDataRows(List<Employee> employees) {
        int totalCost = 0;
        StringBuilder finalString = new StringBuilder();
        for(Employee employee : employees) {
            totalCost += employee.getSalary();
            finalString.append("""
                    <tr>
                    	<td>
                    """).append(employee.getFirstName()).append(" ").append(employee.getLastName()).append("""
                    	</td>
                       	<td>
                    """).append(employee.getPhoneNumber()).append("""
                        </td>
                    	<td>
                    """).append(employee.getEmailAddress()).append("""
                    	</td>
                    	<td>
                    """).append(employee.getSalary()).append("$").append("""
                                </td>
                    </tr>
                    """);
        }
        System.out.println(finalString);
        return List.of(Integer.toString(totalCost), finalString.toString());
    }
}
