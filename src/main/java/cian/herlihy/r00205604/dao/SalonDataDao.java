package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Salon;

import java.util.List;

public interface SalonDataDao extends CommonQueries {

    // CREATE
    boolean addSalon(int id, String name, String address, String phoneNumber, String daysOpen);

    // READ
    int countTotalSalons();
    List<Salon> findAll();
    List<Salon> findSalonById(int id);
    List<Salon> findSalonByName(String name);

    //UPDATE
    boolean updateById(int id, String columnName, String newValue);
    boolean updateByName(String name, String columnName, String newValue);

    // DELETE
    boolean deleteById(int id);
    boolean deleteByName(String name);
    boolean deleteByPHNumber(String phoneNumber);
}
