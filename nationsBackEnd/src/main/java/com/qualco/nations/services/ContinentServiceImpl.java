package com.qualco.nations.services;

import com.qualco.nations.models.Continent;
import com.qualco.nations.repositories.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContinentServiceImpl implements ContinentService{

    @Autowired
    private ContinentRepository continentRepository;

    @Override
    public Continent getById(Integer continentId) {
        return continentRepository.getById(continentId);
    }

}
