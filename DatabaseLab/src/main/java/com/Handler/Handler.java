package com.Handler;


import com.ReactorType.ReactorFileData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Handler {
    List<ReactorFileData> handle(File file) throws IOException;
    void setNext(Handler handler);
}
