package FileReaders;

import ReactorsRelated.Reactor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class YAMLFileReader extends FileReader {

    @Override
    public List<Reactor> read(File file) throws IOException {
        ArrayList<Reactor> list;
        list = readYAML(file);
        for (Reactor reactor : list) {
            reactor.setFiletype("YAML");
        }
        return list;
    }

    private ArrayList<Reactor> readYAML(File file) throws FileNotFoundException {
        Map<String, Reactor> map = null;
        try {
            map = (new YAMLMapper()).readValue(file, new TypeReference<Map<String, Reactor>>() {
            });
        } catch (IOException ex) {
            Logger.getLogger(YAMLFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Reactor> list = new ArrayList<>(map.values());
        return list;
    }
}
