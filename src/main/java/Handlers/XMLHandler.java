package Handlers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import FileReaders.XMLFileReader;
import ReactorsRelated.Reactor;

public class XMLHandler extends BaseHandler {
    public XMLHandler() {
        setExtension("xml");
    }

    public List<Reactor> handle(File file) throws IOException {
        if (!canHandle(file)) return super.handle(file);
        XMLFileReader xmlFileReader = new XMLFileReader();
        return xmlFileReader.read(file);
    }
}
