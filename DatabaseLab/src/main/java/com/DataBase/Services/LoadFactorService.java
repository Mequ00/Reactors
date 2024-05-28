package com.DataBase.Services;

import com.DataBase.Repositories.LoadFactorRepository;
import com.Models.LoadFactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadFactorService {
    @Autowired
    private LoadFactorRepository loadFactorRepository;

    public List<LoadFactor> findByReactor(Long reactorId) {
        return loadFactorRepository.findByReactor(reactorId);
    }
}

