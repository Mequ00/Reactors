package com.FileReader;

import com.ReactorType.ReactorFileData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class YAMLFileReader implements FileReader {

    @Override
    public List<ReactorFileData> read(File file) throws IOException {
        YAMLMapper yamlMapper = new YAMLMapper();
        Map<String, ReactorFileData> reactorMap = yamlMapper.readValue(file,
                new TypeReference<Map<String, ReactorFileData>>() {
        });
        List<ReactorFileData> reactorlist = new ArrayList<>(reactorMap.values());
        for (ReactorFileData reactor : reactorlist) {
            reactor.setSource("YAML");
        }
        return reactorlist;
    }
}
