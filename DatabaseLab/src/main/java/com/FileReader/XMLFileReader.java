package com.FileReader;

import com.ReactorType.ReactorFileData;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLFileReader implements FileReader {

    @Override
    public List<ReactorFileData> read(File file) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        List<ReactorFileData> reactorlist = xmlMapper.readValue(file,
                xmlMapper.getTypeFactory().constructCollectionType(List.class, ReactorFileData.class));
        for (ReactorFileData reactor : reactorlist) {
            reactor.setSource("XML");
        }
        return reactorlist;
    }
}
