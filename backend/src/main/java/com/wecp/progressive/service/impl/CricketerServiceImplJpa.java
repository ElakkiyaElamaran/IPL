package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Cricketer;
import com.wecp.progressive.repository.CricketerRepository;
import com.wecp.progressive.service.CricketerService;

@Service
public class CricketerServiceImplJpa implements CricketerService {
   
    private CricketerRepository cricketerRepository;
    

    @Autowired 
    public CricketerServiceImplJpa(CricketerRepository cricketerRepository) {
        this.cricketerRepository = cricketerRepository;
    }

    @Override
    public List<Cricketer> getAllCricketers() throws SQLException {
    //    return cricketerRepository.findAll();
    return List.of();
    }

    @Override
    public Integer addCricketer(Cricketer cricketer) throws SQLException {
        // cricketerRepository.save(cricketer);
        // return cricketer.getTeamId();
        return null;
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() throws SQLException {
        // List<Cricketer> cricketers = cricketerRepository.findAll();
        // cricketers.sort(Comparator.comparingInt(Cricketer::getExperience).reversed());
        // return cricketers;
        return List.of();
    }


    @Override
    public Cricketer getCricketerById(int id) throws SQLException
    {
        // return cricketerRepository.findById(id).orElse(null);
        return null;
    }

    @Override
    public void updateCricketer(Cricketer cricketer) throws SQLException {
        // if(cricketerRepository.existsById(cricketer.getCricketerId()))
        // cricketerRepository.save(cricketer);
    }

    @Override
    public void deleteCricketer(int cricketerId) throws SQLException {
        // cricketerRepository.deleteById(cricketerId);
    }

    public List<Cricketer> getCricketerByTeam(int teamId) throws SQLException
    {
        // return cricketerRepository.findByTeamId(teamId);
        return null;
    }

    }
