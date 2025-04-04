package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.dto.CandidateDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.text.SimpleDateFormat;

@Service
public class ExportService {

    public byte[] exportCandidatesToExcel(List<CandidateDTO> candidates) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Candidates");

        // Create header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"ID", "Employee ID", "Name", "Skill", "Experience", "Base Location",
                "Status", "DOJ", "On Bench", "Bench Start Date", "Client ID",
                "Remarks", "Mentorship", "Current Location", "TH Link",
                "LWD in Accolite", "Project Type", "Project Allocation Status",
                "Selection Date", "Onboarding Date"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(createHeaderCellStyle(workbook));
        }

        // Create a date cell style
        CellStyle dateCellStyle = createDateCellStyle(workbook);

        // Fill data rows
        int rowIdx = 1;
        for (CandidateDTO candidate : candidates) {
            Row row = sheet.createRow(rowIdx++);

            row.createCell(0).setCellValue(toSafeString(candidate.getId()));
            row.createCell(1).setCellValue(toSafeString(candidate.getEmpId()));
            row.createCell(2).setCellValue(toSafeString(candidate.getName()));
            row.createCell(3).setCellValue(toSafeString(candidate.getSkill()));
            row.createCell(4).setCellValue(toSafeString(candidate.getPastExperience()));
            row.createCell(5).setCellValue(toSafeString(candidate.getBaseLocation()));
            row.createCell(6).setCellValue(toSafeString(candidate.getStatus()));

            Cell dojCell = row.createCell(7);
            dojCell.setCellValue(candidate.getAccoliteDoj());
            dojCell.setCellStyle(dateCellStyle);

            row.createCell(8).setCellValue(candidate.isOnBench()); // Boolean is directly accepted

            Cell benchStartDateCell = row.createCell(9);
            benchStartDateCell.setCellValue(candidate.getBenchStartDate());
            benchStartDateCell.setCellStyle(dateCellStyle);

            row.createCell(10).setCellValue(toSafeString(candidate.getClientId()));
            row.createCell(11).setCellValue(toSafeString(candidate.getRemarks()));
            row.createCell(12).setCellValue(toSafeString(candidate.getMentorship()));
            row.createCell(13).setCellValue(toSafeString(candidate.getCurrentLocation()));
            row.createCell(14).setCellValue(toSafeString(candidate.getThLink()));

            Cell lwdCell = row.createCell(15);
            lwdCell.setCellValue(candidate.getLwdInAccolite());
            lwdCell.setCellStyle(dateCellStyle);

            row.createCell(16).setCellValue(toSafeString(candidate.getProjectType()));
            row.createCell(17).setCellValue(toSafeString(candidate.getProjectAllocationStatus()));

            Cell selectionDateCell = row.createCell(18);
            selectionDateCell.setCellValue(candidate.getSelectionDate());
            selectionDateCell.setCellStyle(dateCellStyle);

            Cell onboardingDateCell = row.createCell(19);
            onboardingDateCell.setCellValue(candidate.getOnboardingDate());
            onboardingDateCell.setCellStyle(dateCellStyle);
        }

        // Resize columns to fit content
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write to a byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return outputStream.toByteArray();
    }

    private CellStyle createHeaderCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }

    private CellStyle createDateCellStyle(Workbook workbook) {
        CreationHelper createHelper = workbook.getCreationHelper();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
        return cellStyle;
    }

    private String toSafeString(Object value) {
        return value != null ? value.toString() : "";
    }
}
