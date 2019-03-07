package com.hlfc.file.excel;

import com.hlfc.util.EnvironmentUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

/**
 * 读取excel文件，写入excel
 * @Auther: HXL
 * @Date: 2018/12/20 15:21
 */
public class HTest {

    @Test
    public void excel() throws IOException {
        String filepath = EnvironmentUtil.getInstance().getWebInfPath()+ "/other/file/File.xlsx";
        Workbook workbook = null;
        //输入流
        FileInputStream is = new FileInputStream(filepath);
        // 获得工作簿
        workbook = new XSSFWorkbook(is);

        //获取工作表
        Sheet sheet = workbook.getSheet("工作表");

        //获取行数
        int rows = sheet.getLastRowNum();


        //设置超链接
        CreationHelper createHelper = workbook.getCreationHelper();
        Hyperlink   link =  createHelper.createHyperlink(Hyperlink.LINK_DOCUMENT);

        //设置超链接字体，颜色
        CellStyle hlink_style = workbook.createCellStyle();
        Font hlink_font = workbook.createFont();
        hlink_font.setUnderline(HSSFFont.U_SINGLE);
        hlink_font.setColor(HSSFColor.BLUE.index);
        hlink_style.setAlignment(CellStyle.ALIGN_CENTER);
        hlink_style.setFont(hlink_font);

        //工作表名称不能大于32个字符
        link.setAddress("'工作表'!A1");

        for (int row = 0; row < rows; row++) {
            Row r = sheet.getRow(row);
            Cell c = r.getCell(0);
            System.out.println(c.getStringCellValue());
            if (row == rows-1){
                c.setHyperlink(link);
                c.setCellStyle(hlink_style);
            }
        }

        //写入单元格数据
        Row rowFlow = sheet.getRow(0);
        Cell cellflow =  rowFlow.createCell(10);
        cellflow.setCellValue("流程名称:");

        //创建文件输出流
        OutputStream stream = new FileOutputStream(filepath);
        //写入数据
        workbook.write(stream);
        //关闭流
        is.close();

    }
}
