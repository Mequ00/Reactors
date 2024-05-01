package Interface;

import Handlers.XMLHandler;
import Handlers.YAMLHandler;
import Handlers.Handler;
import Handlers.JSONHandler;
import ReactorsRelated.Reactor;
import ReactorsRelated.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Manager {

    private Repository repository = new Repository();
    private Handler handler = new XMLHandler();

    public Manager() {
        YAMLHandler yamlHandler = new YAMLHandler();
        JSONHandler jsonHandler = new JSONHandler();
        handler.setNext(yamlHandler);
        yamlHandler.setNext(jsonHandler);
    }

    public void readFile(File file) throws IOException {
        List<Reactor> list = handler.handle(file);
        for (Reactor reactor : list) {
            reactor.setParameters();
        }
        repository.addToMap(file.getName(), list);
    }

    public DefaultTreeModel getTreeData() {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Reactors");
        Map<String, List<Reactor>> map = repository.getMap();
        for (Entry<String, List<Reactor>> entry : map.entrySet()) {
            DefaultMutableTreeNode fileNode = new DefaultMutableTreeNode(entry.getKey());
            for (Reactor reactor : entry.getValue()) {
                DefaultMutableTreeNode concreteReactor = new DefaultMutableTreeNode(reactor.getType());
                for (String parameter : reactor.getParameters()) {
                    concreteReactor.add(new DefaultMutableTreeNode(parameter));
                }
                fileNode.add(concreteReactor);
            }
            rootNode.add(fileNode);
        }
        return new DefaultTreeModel(rootNode);
    }
}
