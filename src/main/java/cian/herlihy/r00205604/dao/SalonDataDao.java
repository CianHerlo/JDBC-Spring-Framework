package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Salon;

import java.util.List;
import java.util.Optional;

public interface SalonDataDao extends Queries {

    // CREATE
    boolean addSalon(int id, String name, String address, String phoneNumber, String daysOpen);

    // READ
    Optional<Integer> countTotalSalons();
    Optional<List<Salon>> findAll();
    Optional<Salon> findSalonById(int id);
    Optional<List<Salon>> findSalonByName(String name);

    //UPDATE
    boolean updateById(int id, String columnName, String newValue);
    boolean updateByName(String name, String columnName, String newValue);

    // DELETE
    boolean deleteById(int id);
    boolean deleteByName(String name);
    boolean deleteByPHNumber(String phoneNumber);
}
