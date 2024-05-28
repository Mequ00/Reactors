package com.FileReader;

import com.ReactorType.ReactorFileData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileReader {

    List<ReactorFileData> read(File file) throws IOException;
}
