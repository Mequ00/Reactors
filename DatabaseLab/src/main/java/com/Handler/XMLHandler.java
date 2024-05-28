package com.Handler;


import com.FileReader.XMLFileReader;
import com.ReactorType.ReactorFileData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLHandler extends BaseHandler {
    public XMLHandler() {
        setExtension("xml");
    }

    public List<ReactorFileData> handle(File file) throws IOException {
        if (!canHandle(file)) return super.handle(file);
        XMLFileReader xmlFileReader = new XMLFileReader();
        return xmlFileReader.read(file);
    }
}
