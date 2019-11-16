package com.cdutcm.elements.utils;

import com.cdutcm.elements.entity.Acquire;
import com.cdutcm.elements.entity.Inborn;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/22
 * Time: 14:34 星期五
 * Description:
 */
public class ExcelUtils {
    /**
     * 生成创建Excel
     *
     * @param title      显示的导出表的标题
     * @param rowName    导出表的列名
     * @param inbornList 数据
     * @return SXSSFWorkbook
     */
    public static SXSSFWorkbook createConclusionExcel(String title, String[] rowName, List<Inborn> inbornList, List<Acquire> acquireList) throws UnsupportedEncodingException {
        SXSSFWorkbook workbook = new SXSSFWorkbook();// 创建工作簿对象
        SXSSFSheet sheet = workbook.createSheet(title);// 创建工作表
        // 产生表格标题行
        SXSSFRow rowTitle = sheet.createRow(0);
        SXSSFCell cellTitle = rowTitle.createCell(0);
        //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】
        CellStyle columnTopStyle = getColumnTopStyle(workbook);//获取列头样式对象
        CellStyle cellStyle = getStyle(workbook);//单元格样式对象


        // 定义所需列数
        int columnNum = rowName.length;
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (columnNum - 1)));
        cellTitle.setCellStyle(columnTopStyle);// 设置标题单元格样式
        cellTitle.setCellValue(title);// 设置标题
        SXSSFRow row = sheet.createRow(2);// 在索引2的位置创建行(最顶端的行开始的第二行)
        // 将列头设置到sheet的单元格中
        for (int i = 0; i < columnNum; i++) {
            SXSSFCell cell = row.createCell(i);//创建列头对应个数的单元格
            cell.setCellType(CellType.STRING);//设置列头单元格的数据类型
            RichTextString textString = new XSSFRichTextString(rowName[i]);
            cell.setCellStyle(columnTopStyle);//设置列头单元格样式
            cell.setCellValue(textString);//设置列头单元格的值
        }

        //将查询出的数据设置到sheet对应的单元格中 //添加数据到Excel单元格
        SXSSFCell cell;
        for (int i = 0; i < inbornList.size(); i++) {
            row = sheet.createRow(i + 3);
            //region 给每一行数据添加值 //设置单元格的值
            cell = row.createCell(0, CellType.NUMERIC);//行号
            cell.setCellValue(i + 1);
            cell.setCellStyle(cellStyle);//设置单元格样式
            cell = row.createCell(1, CellType.STRING);//手机号码
            cell.setCellValue(inbornList.get(i).getPhone());
            cell.setCellStyle(cellStyle);
            cell = row.createCell(2, CellType.STRING);//姓名
            cell.setCellValue(inbornList.get(i).getName());
            cell.setCellStyle(cellStyle);
            cell = row.createCell(3, CellType.STRING);//性别
            cell.setCellValue(inbornList.get(i).getSex());
            cell.setCellStyle(cellStyle);
            cell = row.createCell(4, CellType.STRING);//公历出生日期
            cell.setCellValue(inbornList.get(i).getSolarBirth());
            cell.setCellStyle(cellStyle);
            cell = row.createCell(5, CellType.STRING);//农历出生日期
            cell.setCellValue(inbornList.get(i).getLunarBirth());
            cell.setCellStyle(cellStyle);
            cell = row.createCell(6, CellType.STRING);//八字
            cell.setCellValue(inbornList.get(i).getHoroscope());
            cell.setCellStyle(cellStyle);
            cell = row.createCell(7, CellType.STRING);//先天五行所属 / 所缺(所次)
            cell.setCellValue(ElementsUtils.convertInborn(inbornList.get(i).getInborn()));
            cell.setCellStyle(cellStyle);
            cell = row.createCell(8, CellType.STRING);//后天五行所属 / 所缺(所次)
            cell.setCellValue(ElementsUtils.convertAcquire(acquireList.get(i)));
            cell.setCellStyle(cellStyle);
            cell = row.createCell(9, CellType.STRING);//阴阳值
            cell.setCellValue(ElementsUtils.acquire2YinYang(acquireList.get(i)));
            cell.setCellStyle(cellStyle);
            //endregion
        }

        //获取当前列的宽度，然后对比本列的长度，取最大值
        for (int i = 1; i <= columnNum; i++) {
            int columnWidth = sheet.getColumnWidth(i) / 256;
            for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row currentRow;
                //当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }
                if (currentRow.getCell(i) != null) {
                    Cell currentCell = currentRow.getCell(i);
                    int length = currentCell.toString().getBytes("UTF-8").length;
                    if (columnWidth < length) {
                        columnWidth = length;
                    }
                }
            }
            if (i == 1) {//电话号码
                columnWidth += 5;
            }
            sheet.setColumnWidth(i, columnWidth * 256);
        }
        return workbook;
    }

    /**
     * 列头单元格样式
     *
     * @param workbook
     * @return
     */
    private static CellStyle getColumnTopStyle(SXSSFWorkbook workbook) {
        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 11);
        //字体加粗
        font.setBold(true);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //设置右边框;
        style.setBorderRight(BorderStyle.THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //设置顶边框;
        style.setBorderTop(BorderStyle.THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HorizontalAlignment.CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    /**
     * 列数据信息单元格样式
     *
     * @param workbook
     * @return
     */
    private static CellStyle getStyle(SXSSFWorkbook workbook) {
        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //设置右边框;
        style.setBorderRight(BorderStyle.THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //设置顶边框;
        style.setBorderTop(BorderStyle.THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HorizontalAlignment.CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }
}
