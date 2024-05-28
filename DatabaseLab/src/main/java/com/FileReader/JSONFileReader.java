package com.FileReader;

import com.ReactorType.ReactorFileData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONFileReader implements FileReader {

    @Override
    public List<ReactorFileData> read(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ReactorFileData> reactorlist = objectMapper.readValue(file,
                objectMapper.getTypeFactory().constructCollectionType(List.class, ReactorFileData.class));
        for (ReactorFileData reactor : reactorlist) {
            reactor.setSource("JSON");
        }
        return reactorlist;
    }
}
