package com.wecp.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wecp.progressive.entity.Cricketer;

@Repository
public interface CricketerRepository extends JpaRepository<Cricketer, Integer> {

   
}
