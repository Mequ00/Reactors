package com.Service;

import com.Calculations.ConsumptionCalculator;
import com.DataBase.Services.DatabaseService;
import com.Handler.Handler;
import com.Handler.JSONHandler;
import com.Handler.XMLHandler;
import com.Handler.YAMLHandler;
import com.ReactorType.ReactorFileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

@Component
public class ApplicationManager {

    @Autowired
    private DataStorage storage;

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private ConsumptionCalculator consumptionCalculator;

    private final Handler firstHandler;

    public ApplicationManager() {
        this.firstHandler = new JSONHandler();
        Handler secoHandler = new XMLHandler();
        firstHandler.setNext(secoHandler);
        Handler thirdHandler = new YAMLHandler();
        secoHandler.setNext(thirdHandler);
    }

    public boolean canCalculate() {
        return !storage.getReactorDataMap().isEmpty();
    }

    public void createDatabase() throws SQLException {
        databaseService.reloadDatabase();
    }

    public void readFile(File file) throws IOException {
        storage.getReactorDataMap().put(file.getName(), this.firstHandler.handle(file));
    }

    public DefaultTableModel addTableCountriesToGui() {
        return consumptionCalculator.calculateConsumptionByCountry();
    }

    public DefaultTableModel addTableRegionsToGui() {
        return consumptionCalculator.calculateConsumptionByRegion();
    }

    public DefaultTableModel addTableOperatorsToGui() {
        return consumptionCalculator.calculateConsumptionByOperator();
    }

    public DefaultMutableTreeNode addTreeToGUI() {
        DefaultMutableTreeNode mainNode = new DefaultMutableTreeNode("Реакторы");
        for (Entry<String, List<ReactorFileData>> entry : storage.getReactorDataMap().entrySet()) {
            DefaultMutableTreeNode fileNode = new DefaultMutableTreeNode(entry.getKey());
            for (ReactorFileData reactor : entry.getValue()) {
                fileNode.add(reactor.reactoreNode());
            }
            mainNode.add(fileNode);
        }
        return mainNode;
    }
}
