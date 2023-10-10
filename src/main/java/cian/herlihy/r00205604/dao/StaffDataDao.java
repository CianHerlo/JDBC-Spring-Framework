package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Staff;

import java.util.List;

public interface StaffDataDao {

    int countTotalStaff();

    List<Staff> findAll();
}
