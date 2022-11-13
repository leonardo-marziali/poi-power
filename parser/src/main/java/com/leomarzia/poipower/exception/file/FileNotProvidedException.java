package com.leomarzia.poipower.exception.file;

public class FileNotProvidedException extends RuntimeException{

    public FileNotProvidedException() {
        super("The provided file is null");
    }
}
