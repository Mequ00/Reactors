package FileReaders;

import ReactorsRelated.Reactor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONFileReader extends FileReader {

    @Override
    public List<Reactor> read(File file) throws IOException {
        ArrayList<Reactor> list;
        list = readJSON(file);
        for (Reactor reactor : list) {
            reactor.setFiletype("JSON");
        }
        return list;
    }

    private ArrayList<Reactor> readJSON(File file) throws FileNotFoundException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Reactor> list = mapper.readValue(file,
                mapper.getTypeFactory().constructCollectionType(ArrayList.class, Reactor.class));
        return list;
    }
}
