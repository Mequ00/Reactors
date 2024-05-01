package Handlers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ReactorsRelated.Reactor;

public interface Handler {
    public List<Reactor> handle(File file) throws IOException;
    public void setNext(Handler handler); 
}
