package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Salon;

import java.util.List;

public interface SalonDataDao {

    int countTotalSalons();

    List<Salon> findAll();
}
