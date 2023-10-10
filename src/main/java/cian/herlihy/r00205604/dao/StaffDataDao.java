package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Staff;

import java.util.List;

public interface StaffDataDao extends CommonQueries {

    int countTotalStaff();

    List<Staff> findAll();

    List<Staff> findStaffById(int id);

    List<Staff> findStaffByName(String name);
}
