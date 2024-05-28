package com.Handler;


import com.FileReader.YAMLFileReader;
import com.ReactorType.ReactorFileData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class YAMLHandler extends BaseHandler {
    public YAMLHandler() {
        setExtension("yaml");
    }

    public List<ReactorFileData> handle(File file) throws IOException {
        if (!canHandle(file)) return super.handle(file);
        YAMLFileReader yamlFileReader = new YAMLFileReader();
        return yamlFileReader.read(file);
    }
}
