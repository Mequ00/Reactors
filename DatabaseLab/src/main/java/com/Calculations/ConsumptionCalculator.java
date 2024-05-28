package com.Calculations;

import com.Models.*;
import com.ReactorType.ReactorFileData;
import com.Service.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.*;

@Component
public class ConsumptionCalculator {

    @Autowired
    private DataStorage storage;

    public DefaultTableModel calculateConsumptionByRegion() {
        Map<String, Map<Integer, Float>> consumptionMap = new TreeMap<>();
        Map<Region, List<Reactor>> reactorsByContries = storage.getReactorService().getByRegion();

        for (Region region : reactorsByContries.keySet()) {
            consumptionMap.put(region.getRegionName(), processReactors(reactorsByContries.get(region)));
        }
        return createConsumptionTable(consumptionMap, "Регион");
    }

    public DefaultTableModel calculateConsumptionByCountry() {
        Map<String, Map<Integer, Float>> consumptionMap = new TreeMap<>();
        Map<Country, List<Reactor>> reactorsByContries = storage.getReactorService().getByCountries();

        for (Country country : reactorsByContries.keySet()) {
            consumptionMap.put(country.getCountryName(), processReactors(reactorsByContries.get(country)));
        }
        return createConsumptionTable(consumptionMap, "Страна");
    }

    public DefaultTableModel calculateConsumptionByOperator() {
        Map<String, Map<Integer, Float>> consumptionMap = new TreeMap<>();
        Map<Operator, List<Reactor>> reactorsByContries = storage.getReactorService().getByOperator();

        for (Operator operator : reactorsByContries.keySet()) {
            consumptionMap.put(operator.getOperatorName(), processReactors(reactorsByContries.get(operator)));
        }
        return createConsumptionTable(consumptionMap, "Оператор");
    }

    private Map<Integer, Float> processReactors(List<Reactor> reactors) {
        Map<Integer, Float> consumptionMap = new TreeMap<>();
        for (Reactor reactor : reactors) {
            ReactorFileData reactorFileData = getReactorFileData(reactor);
            if (reactorFileData == null) continue;
            List<LoadFactor> loadFactors = reactor.getLoadFactors();
            float a = reactorFileData.getTermal_capacity() / reactorFileData.getBurnup();
            for (int year = 2014; year <= 2024; year++) {
                int finalYear = year;
                Optional<LoadFactor> optional = loadFactors.stream().filter(lf -> lf.getYear() == finalYear).findFirst();
                if (optional.isPresent() && optional.get().getLoadFactor() != null) {
                    LoadFactor loadFactor = optional.get();
                    consumptionMap.merge(loadFactor.getYear(), a * (loadFactor.getLoadFactor() / 100), Float::sum);
                } else {
                    LocalDate connectionDate = reactor.getConnectionDate().toLocalDate();
                    LocalDate shutdownDate = reactor.getShutdownDate() != null ?
                            reactor.getShutdownDate().toLocalDate() : null;

                    if (connectionDate.getYear() > year ||
                            (shutdownDate != null && shutdownDate.getYear() < year)) {
                        continue;
                    } else {
                        consumptionMap.merge(year, a * 0.85f, Float::sum);
                    }
                }
            }
        }
        return consumptionMap;
    }

    private ReactorFileData getReactorFileData(Reactor reactor) {
        Map<String, String> classes = Map.ofEntries(
                Map.entry("PHWR", "PHWR"),
                Map.entry("PWR", "PWR"),
                Map.entry("BWR", "BWR"),
                Map.entry("LWGR", "RBMK"),
                Map.entry("GCR", "MAGNOX"),
                Map.entry("FBR", "BN")
        );

        String reactorType = reactor.getType().getTypeName();
        String mappedType = classes.get(reactorType);

        if (mappedType != null) {
            List<ReactorFileData> allReactorFileData = new ArrayList<>();
            storage.getReactorDataMap().values().forEach(allReactorFileData::addAll);

            for (ReactorFileData reactorFileData : allReactorFileData) {
                if (mappedType.equals(reactorFileData.getType())) {
                    return reactorFileData;
                }
            }
        }
        return null;
    }

    private DefaultTableModel createConsumptionTable(Map<String, Map<Integer, Float>> consumptionMap, String title) {
        int rowCount = consumptionMap.values().stream().mapToInt(Map::size).sum();
        Object[][] objects = new Object[rowCount][3];
        Object[] nameColums = {title, "Год", "Объём ежегодного потребления"};

        int rowIndex = 0;
        for (Map.Entry<String, Map<Integer, Float>> entry : consumptionMap.entrySet()) {
            String key = entry.getKey();
            Map<Integer, Float> yearConsumptionMap = entry.getValue();

            for (Map.Entry<Integer, Float> yearEntry : yearConsumptionMap.entrySet()) {
                objects[rowIndex][0] = key;
                objects[rowIndex][1] = yearEntry.getKey();
                objects[rowIndex][2] = yearEntry.getValue();
                rowIndex++;
            }
        }
        return new DefaultTableModel(objects, nameColums);
    }
}
