package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffDataDao extends Queries {

    // CREATE
    boolean addStaff(int id, String firstName, String surname, String phoneNumber, int annualSalary, int salonId);

    // READ
    Optional<List<Staff>> findAll();
    Optional<Staff> findStaffById(int id);
    Optional<List<Staff>> findStaffBySalonId(int salonId);
    float findAverageSalary(int salonId);

    //UPDATE
    boolean updateById(int id, String columnName, String newValue);
    boolean updateById(int id, String columnName, int newValue);

    // DELETE
    boolean deleteById(int id);
    boolean deleteBySalonId(int salonId);

}
