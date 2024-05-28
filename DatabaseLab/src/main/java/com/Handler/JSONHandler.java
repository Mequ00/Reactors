package com.Handler;


import com.FileReader.JSONFileReader;
import com.ReactorType.ReactorFileData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONHandler extends BaseHandler {
    public JSONHandler() {
        setExtension("json");
    }

    public List<ReactorFileData> handle(File file) throws IOException {
        if (!canHandle(file)) return super.handle(file);
        JSONFileReader jsonFileReader = new JSONFileReader();
        return jsonFileReader.read(file);
    }
}
