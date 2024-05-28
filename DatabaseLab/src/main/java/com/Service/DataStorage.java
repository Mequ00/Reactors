package com.Service;

import com.DataBase.Services.*;
import com.ReactorType.ReactorFileData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@Component
public class DataStorage {
    private Map<String, List<ReactorFileData>> reactorDataMap = new HashMap<>();

    @Autowired
    private CountryService countryService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private ReactorService reactorService;

    @Autowired
    private LoadFactorService loadFactorService;
}

