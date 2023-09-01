package com.example.springfileiodemo.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Service
@Slf4j
public class UserExcelExporter {
    private List<User> listUsers;

    @PostConstruct
    public void load() {
        User user1 = User.builder()
                .id(123)
                .fullName("Firstname Lastname")
                .enabled(true)
                .email("testEmailId@example.com")
                .build();
        User user2 = User.builder()
                .id(456)
                .fullName("AnotherFirstname AnotherLastname")
                .enabled(false)
                .email("secondTestEmailId@example.com")
                .build();
        listUsers = Arrays.asList(user1, user2);
    }

    public byte[] getXlsxSheetAsBytes() throws IOException {

        XSSFWorkbook workbook = getXlsxWorkbook();

        byte[] bytes = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            workbook.write(bos);
            bytes = bos.toByteArray();
        } catch (IOException e) {
            log.error("IOException while building xlsx workbook.");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            workbook.close();
        }

        return bytes;
    }

    public XSSFWorkbook getXlsxWorkbook() throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Users");

        writeHeaderLine(workbook, sheet);

        writeDataLines(workbook, sheet);

        return workbook;
    }


    private void writeHeaderLine(XSSFWorkbook workbook, XSSFSheet sheet) {

        Row headerRow = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        style.setWrapText(true);

        createCell(sheet, headerRow, 0, "User ID", style);
        createCell(sheet, headerRow, 1, "E-mail", style);
        createCell(sheet, headerRow, 2, "Full Name", style);
        createCell(sheet, headerRow, 3, "Enabled", style);

    }

    private void writeDataLines(XSSFWorkbook workbook, XSSFSheet sheet) {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (User user : listUsers) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(sheet, row, columnCount++, user.getId(), style);
            createCell(sheet, row, columnCount++, user.getEmail(), style);
            createCell(sheet, row, columnCount++, user.getFullName(), style);
            createCell(sheet, row, columnCount++, user.isEnabled(), style);

        }
    }

    private void createCell(XSSFSheet sheet, Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
}
