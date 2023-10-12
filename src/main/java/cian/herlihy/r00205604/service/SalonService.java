package cian.herlihy.r00205604.service;

import cian.herlihy.r00205604.model.Salon;
import cian.herlihy.r00205604.service.exceptions.SalonNotFoundException;

import java.util.List;

public interface SalonService {

    // CREATE
    boolean addSalon(int id, String name, String address, String phoneNumber, String daysOpen);

    // READ
    List<Salon> findAll() throws SalonNotFoundException;
    Salon findSalonById(int id) throws SalonNotFoundException;
    List<Salon> findSalonByName(String name) throws SalonNotFoundException;

    //UPDATE
    boolean updateById(int id, String columnName, String newValue);
//    boolean updateByName(String name, String columnName, String newValue);

    // DELETE
    boolean deleteById(int id);
//    boolean deleteByName(String name);
//    boolean deleteByPHNumber(String phoneNumber);
}
