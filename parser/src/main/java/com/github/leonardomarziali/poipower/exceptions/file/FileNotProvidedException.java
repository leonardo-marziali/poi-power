package com.github.leonardomarziali.poipower.exceptions.file;

public class FileNotProvidedException extends RuntimeException{

    public FileNotProvidedException() {
        super("The provided file is null");
    }
}
