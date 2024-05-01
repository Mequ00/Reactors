package ReactorsRelated;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class ReactorType {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Reactor")
    private List<ReactorsRelated.Reactor> Reactor;

    public List<ReactorsRelated.Reactor> getReactors() {
        return Reactor;
    }

    public void setReactors(List<ReactorsRelated.Reactor> reactors) {
        this.Reactor = reactors;
    }
}