package cian.herlihy.r00205604.service;

import cian.herlihy.r00205604.model.Salon;
import cian.herlihy.r00205604.service.exceptions.SalonNotFoundException;

import java.util.List;

public interface SalonService {

    String TABLE_HEADER_FORMAT = "%-3s%-30s%-55s%-14s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%n";
    String TABLE_INFO_FORMAT = "%-3d%-30s%-55s%-14s";
    String DAYS_OPEN_HEADER = "%-30s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%n";

    // CREATE
    void addSalon(int id, String name, String address, String phoneNumber, String daysOpen);

    // READ
    List<Salon> findAll() throws SalonNotFoundException;
    Salon findSalonById(int id) throws SalonNotFoundException;
    List<Salon> findSalonByName(String name) throws SalonNotFoundException;

    //UPDATE
    void updateById(int id, String columnName, String newValue);

    // DELETE
    void deleteById(int id);
}
