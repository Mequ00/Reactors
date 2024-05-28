package com.DataBase.Services;

import com.DataBase.Repositories.TypeRepository;
import com.Models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Type getTypeById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }
}
