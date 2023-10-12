package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffDataDao extends Queries {

    // CREATE
    boolean addStaff(int id, String firstName, String surname, String phoneNumber, int annualSalary, int salonId);

    // READ
    Optional<Integer> countTotalStaff();
    Optional<List<Staff>> findAll();
    Optional<Staff> findStaffById(int id);
    Optional<List<Staff>> findStaffBySalonId(int salonId);
    Optional<List<Staff>> findStaffByFirstName(String firstName);
    Optional<List<Staff>> findStaffBySurname(String surname);

    //UPDATE
    boolean updateById(int id, String columnName, String newValue);
    boolean updateByFirstName(String firstName, String columnName, String newValue);
    boolean updateBySurname(String surname, String columnName, String newValue);

    // DELETE
    boolean deleteById(int id);
    boolean deleteBySalonId(int salonId);
    boolean deleteByFirstName(String firstName);
    boolean deleteBySurname(String surname);
    boolean deleteByPHNumber(String phoneNumber);
}
