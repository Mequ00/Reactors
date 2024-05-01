package Handlers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import FileReaders.YAMLFileReader;
import ReactorsRelated.Reactor;

public class YAMLHandler extends BaseHandler {
    public YAMLHandler() {
        setExtension("yaml");
    }

    public List<Reactor> handle(File file) throws IOException {
        if (!canHandle(file)) return super.handle(file);
        YAMLFileReader yamlFileReader = new YAMLFileReader();
        return yamlFileReader.read(file);
    }
}
