package com.Handler;

import com.ReactorType.ReactorFileData;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class BaseHandler implements Handler {
    protected Handler nextHandler;
    protected String extension;

    public void setNext(Handler handler) {
        nextHandler = handler;
    }

    protected boolean canHandle(File file) {
        return extension.equals(FilenameUtils.getExtension(file.getAbsolutePath()));
    }

    public List<ReactorFileData> handle(File file) throws IOException {
        if (nextHandler != null) {
            return nextHandler.handle(file);
        }
        throw new IOException();
    }

    protected void setExtension(String extension) {
        this.extension = extension;
    }
}
