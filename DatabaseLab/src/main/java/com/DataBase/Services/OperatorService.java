package com.DataBase.Services;

import com.DataBase.Repositories.OperatorRepository;
import com.Models.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService {
    @Autowired
    private OperatorRepository operatorRepository;

    public List<Operator> getAllOperators() {
        return operatorRepository.findAll();
    }

}
