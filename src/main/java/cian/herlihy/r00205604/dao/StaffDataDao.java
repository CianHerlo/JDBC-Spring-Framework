package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Staff;

import java.util.List;

public interface StaffDataDao extends CommonQueries {

    // CREATE
    boolean addStaff(int id, String firstName, String surname, String phoneNumber, int annualSalary);

    // READ
    int countTotalStaff();
    List<Staff> findAll();
    Staff findStaffById(int id);
    List<Staff> findStaffByFirstName(String firstName);
    List<Staff> findStaffBySurname(String surname);

    //UPDATE
    boolean updateById(int id, String columnName, String newValue);
    boolean updateByFirstName(String firstName, String columnName, String newValue);
    boolean updateBySurname(String surname, String columnName, String newValue);

    // DELETE
    boolean deleteById(int id);
    boolean deleteByFirstName(String firstName);
    boolean deleteBySurname(String surname);
    boolean deleteByPHNumber(String phoneNumber);
}
