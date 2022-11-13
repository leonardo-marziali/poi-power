package com.leomarzia.poipower.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ParserMapperTagUtils {

    private ParserMapperTagUtils() {
        throw new IllegalStateException("Utility class");
    }

//    public static Sheet getPoiSheetBySheetTag(Workbook workbook, SheetTag sheetTag) {
//        if (sheetTag.getName() != null) {
//            return workbook.getSheet(templateSheet.getName());
//        } else if (templateSheet.getIndex() != 0) {
//            return workbook.getSheetAt(templateSheet.getIndex());
//        } else {
//            return workbook.getSheetAt(0);
//        }
//    }
}
