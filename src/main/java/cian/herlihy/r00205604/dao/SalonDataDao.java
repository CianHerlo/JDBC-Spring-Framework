package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Salon;

import java.util.List;

public interface SalonDataDao extends CommonQueries {

    int countTotalSalons();

    List<Salon> findAll();

    List<Salon> findSalonById(int id);

    List<Salon> findSalonByName(String name);
}
