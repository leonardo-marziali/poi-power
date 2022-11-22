package com.github.leonardomarziali.poipower.exceptions.parser;

public class WorkbookNotProvidedException extends RuntimeException {

    public WorkbookNotProvidedException() {
        super("Workbook not provided. Probably the call to setWorkbookToParse method is missing");
    }
}
