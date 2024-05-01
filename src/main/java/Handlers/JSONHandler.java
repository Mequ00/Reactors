package Handlers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import FileReaders.JSONFileReader;
import ReactorsRelated.Reactor;

public class JSONHandler extends BaseHandler {
    public JSONHandler() {
        setExtension("json");
    }

    public List<Reactor> handle(File file) throws IOException {
        if (!canHandle(file)) return super.handle(file);
        JSONFileReader jsonFileReader = new JSONFileReader();
        return jsonFileReader.read(file);
    }
}
