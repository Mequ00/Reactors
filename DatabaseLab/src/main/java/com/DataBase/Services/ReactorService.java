package com.DataBase.Services;

import com.DataBase.Repositories.ReactorRepository;
import com.Models.Country;
import com.Models.Operator;
import com.Models.Reactor;
import com.Models.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReactorService {
    @Autowired
    private ReactorRepository reactorRepository;

    public Map<Country, List<Reactor>> getByCountries() {
        Map<Country, List<Reactor>> map = new HashMap<>();
        List<Reactor> reactors = reactorRepository.findAllWithDetails();
        for (Reactor reactor : reactors) {
            Country country = reactor.getCountry();
            map.computeIfAbsent(country, k -> new ArrayList<>()).add(reactor);
        }
        return map;
    }

    public Map<Region, List<Reactor>> getByRegion() {
        Map<Region, List<Reactor>> map = new HashMap<>();
        List<Reactor> reactors = reactorRepository.findAllWithDetails();
        for (Reactor reactor : reactors) {
            Region region = reactor.getCountry().getRegion();
            map.computeIfAbsent(region, k -> new ArrayList<>()).add(reactor);
        }
        return map;
    }

    public Map<Operator, List<Reactor>> getByOperator() {
        Map<Operator, List<Reactor>> map = new HashMap<>();
        List<Reactor> reactors = reactorRepository.findAllWithDetails();
        for (Reactor reactor : reactors) {
            Operator operator = reactor.getOperator();
            if (operator == null) continue;
            map.computeIfAbsent(operator, k -> new ArrayList<>()).add(reactor);
        }
        return map;
    }

    public List<Reactor> getAllReactors() {
        return reactorRepository.findAll();
    }
}

