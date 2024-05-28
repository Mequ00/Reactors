package com.DataBase.Repositories;

import com.Models.LoadFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoadFactorRepository extends JpaRepository<LoadFactor, Long> {

    @Query("SELECT lf FROM LoadFactor lf WHERE lf.reactor.id = :reactorId")
    List<LoadFactor> findByReactor(@Param("reactorId") Long reactorId);

}

