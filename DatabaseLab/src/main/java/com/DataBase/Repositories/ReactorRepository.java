package com.DataBase.Repositories;

import com.Models.Reactor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReactorRepository extends JpaRepository<Reactor, Long> {

    @EntityGraph(attributePaths = {"type", "loadFactors", "country", "country.region", "operator", "owner"})
    @Query("SELECT r FROM Reactor r")
    List<Reactor> findAllWithDetails();

    @EntityGraph(attributePaths = {"type", "loadFactors", "country", "country.region", "operator", "owner"})
    @Query("SELECT r FROM Reactor r WHERE r.country.id = :countryId")
    List<Reactor> findByCountry_Id(@Param("countryId") Long countryId);

    @EntityGraph(attributePaths = {"type", "loadFactors", "country", "country.region", "operator", "owner"})
    @Query("SELECT r FROM Reactor r WHERE r.country.region.id = :regionId")
    List<Reactor> findByRegion_Id(@Param("regionId") Long regionId);

    @EntityGraph(attributePaths = {"type", "loadFactors", "country", "country.region", "operator", "owner"})
    @Query("SELECT r FROM Reactor r WHERE r.owner.id = :ownerId")
    List<Reactor> findByOwner_Id(@Param("ownerId") Long ownerId);

    @EntityGraph(attributePaths = {"type", "loadFactors", "country", "country.region", "operator", "owner"})
    @Query("SELECT r FROM Reactor r WHERE r.operator.id = :operatorId")
    List<Reactor> findByOperator_Id(@Param("operatorId") Long operatorId);
}


