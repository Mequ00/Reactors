package FileReaders;

import ReactorsRelated.Reactor;
import ReactorsRelated.ReactorType;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLFileReader extends FileReaders.FileReader {

    @Override
    public List<Reactor> read(File file) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        ReactorType reactorType = xmlMapper.readValue(file, ReactorType.class);
        for (Reactor reactor : reactorType.getReactors()) {
            reactor.setFiletype("XML");
        }
        return reactorType.getReactors();
    }
}
