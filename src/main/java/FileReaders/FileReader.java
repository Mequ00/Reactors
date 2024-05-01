package FileReaders;

import ReactorsRelated.Reactor;
import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class FileReader {

    public abstract List<Reactor> read(File file) throws IOException;

}
