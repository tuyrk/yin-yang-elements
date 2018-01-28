package com.cdutcm.util;

import com.cdutcm.entity.Conclusion;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/22
 * Time: 14:34 星期五
 * Description:
 */
public class ExcelUtil {
    /**
     * 生成创建Excel
     *
     * @param title       显示的导出表的标题
     * @param rowName     导出表的列名
     * @param conclusions 数据
     * @return
     */
    public static HSSFWorkbook createConclusionExcel(String title, String[] rowName, List<Conclusion> conclusions) {
        HSSFWorkbook workbook = new HSSFWorkbook();// 创建工作簿对象
        try {
            HSSFSheet sheet = workbook.createSheet(title);// 创建工作表
            // 产生表格标题行
            HSSFRow rowTitle = sheet.createRow(0);
            HSSFCell cellTitle = rowTitle.createCell(0);
            //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】
            HSSFCellStyle columnTopStyle = getColumnTopStyle(workbook);//获取列头样式对象
            HSSFCellStyle cellStyle = getStyle(workbook);//单元格样式对象


            // 定义所需列数
            int columnNum = rowName.length;
            sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (columnNum - 1)));
            cellTitle.setCellStyle(columnTopStyle);// 设置标题单元格样式
            cellTitle.setCellValue(title);// 设置标题
            HSSFRow row = sheet.createRow(2);// 在索引2的位置创建行(最顶端的行开始的第二行)
            // 将列头设置到sheet的单元格中
            for (int i = 0; i < columnNum; i++) {
                HSSFCell cell = row.createCell(i);//创建列头对应个数的单元格
                cell.setCellType(CellType.STRING);//设置列头单元格的数据类型
                HSSFRichTextString textString = new HSSFRichTextString(rowName[i]);
                cell.setCellStyle(columnTopStyle);//设置列头单元格样式
                cell.setCellValue(textString);//设置列头单元格的值
            }

            //将查询出的数据设置到sheet对应的单元格中 //添加数据到Excel单元格
            int i = 0;
            HSSFCell cell;
            for (Conclusion conclusion : conclusions) {
                row = sheet.createRow(i + 3);
                //region 给每一行数据添加值 //设置单元格的值
                cell = row.createCell(0, CellType.NUMERIC);//行号
                cell.setCellValue(i + 1);
                cell.setCellStyle(cellStyle);//设置单元格样式
                cell = row.createCell(1, CellType.STRING);//手机号码
                cell.setCellValue(conclusion.getPhone());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(2, CellType.STRING);//姓名
                cell.setCellValue(conclusion.getName());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(3, CellType.STRING);//性别
                cell.setCellValue(conclusion.getSex());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(4, CellType.STRING);//公历出生日期
                cell.setCellValue(conclusion.getSolarBirth());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(5, CellType.STRING);//农历出生日期
                cell.setCellValue(conclusion.getLunarBirth());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(6, CellType.STRING);//先天五行所属
                cell.setCellValue(ElementsUtil.byteToStr(conclusion.getInbornGenus(), false));
                cell.setCellStyle(cellStyle);
                cell = row.createCell(7, CellType.STRING);//先天五行所缺
                cell.setCellValue(ElementsUtil.byteToStr(conclusion.getInbornLack(), false));
                cell.setCellStyle(cellStyle);
                cell = row.createCell(8, CellType.STRING);//后天五行所属
                cell.setCellValue(ElementsUtil.byteToStr(conclusion.getAcquireGenus(), false));
                cell.setCellStyle(cellStyle);
                cell = row.createCell(9, CellType.STRING);//后天五行所缺
                cell.setCellValue(ElementsUtil.byteToStr(conclusion.getAcquireLack(), true));
                cell.setCellStyle(cellStyle);
                cell = row.createCell(10, CellType.NUMERIC);//所属阳值1
                cell.setCellValue(conclusion.getYangValue1());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(11, CellType.NUMERIC);//所属阳值2
                cell.setCellValue(conclusion.getYangValue2());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(12, CellType.NUMERIC);//所属阳值3
                cell.setCellValue(conclusion.getYangValue3());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(13, CellType.NUMERIC);//所属阴值1
                cell.setCellValue(conclusion.getYinValue1());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(14, CellType.NUMERIC);//所属阴值2
                cell.setCellValue(conclusion.getYinValue2());
                cell.setCellStyle(cellStyle);
                cell = row.createCell(15, CellType.NUMERIC);//所属阴值3
                cell.setCellValue(conclusion.getYinValue3());
                cell.setCellStyle(cellStyle);
                i++;
                //endregion
            }

            //让列宽随着导出的列长自动适应
            for (int j = 0; j < columnNum; j++) {
                int columnWidth = sheet.getColumnWidth(j) / 256;
                for (int k = 0; k < sheet.getLastRowNum(); k++) {
                    HSSFRow currentRow;
                    //当前行未被使用过
                    if (sheet.getRow(k) == null) {
                        currentRow = sheet.createRow(k);
                    } else {
                        currentRow = sheet.getRow(k);
                    }
                    if (currentRow.getCell(j) != null) {
                        HSSFCell currentCell = currentRow.getCell(j);
                        if (currentCell.getCellTypeEnum() == CellType.STRING) {
                            int length = currentCell.getStringCellValue().getBytes().length;
                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }
                    }
                }
                if (j == 0) {
                    sheet.setColumnWidth(j, (columnWidth - 2) * 256);
                } else {
                    sheet.setColumnWidth(j, (columnWidth + 4) * 256);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return workbook;
    }

    /**
     * 列头单元格样式
     *
     * @param workbook
     * @return
     */
    private static HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 11);
        //字体加粗
        font.setBold(true);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
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
    private static HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
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
