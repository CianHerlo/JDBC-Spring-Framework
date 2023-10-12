package cian.herlihy.r00205604.service;

import cian.herlihy.r00205604.model.Staff;
import cian.herlihy.r00205604.service.exceptions.StaffNotFoundException;

import java.util.List;

public interface StaffService {

    // CREATE
    boolean addStaff(int id, String firstName, String surname, String phoneNumber, int annualSalary, int salonId);

    // READ
//    Optional<Integer> countTotalStaff();
    List<Staff> findAll() throws StaffNotFoundException;
    Staff findStaffById(int id) throws StaffNotFoundException;
    List<Staff> findStaffBySalonId(int salonId) throws StaffNotFoundException;
    float findAverageSalary(int salonId);

    //UPDATE
    boolean updateById(int id, String columnName, String newValue);
    boolean updateById(int id, String columnName, int newValue);
//    boolean updateByFirstName(String firstName, String columnName, String newValue);
//    boolean updateBySurname(String surname, String columnName, String newValue);

    // DELETE
    boolean deleteById(int id);
    boolean deleteBySalonId(int salonId);
//    boolean deleteByFirstName(String firstName);
//    boolean deleteBySurname(String surname);
//    boolean deleteByPHNumber(String phoneNumber);
}
