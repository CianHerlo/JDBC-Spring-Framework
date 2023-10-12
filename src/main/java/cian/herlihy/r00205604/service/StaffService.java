package cian.herlihy.r00205604.service;

import cian.herlihy.r00205604.model.Staff;
import cian.herlihy.r00205604.service.exceptions.StaffNotFoundException;

import java.util.List;

public interface StaffService {

    String TABLE_HEADER_FORMAT = "%-11s%-16s%-16s%-15s%-15s%-9s%n";

    // CREATE
    void addStaff(int id, String firstName, String surname, String phoneNumber, int annualSalary, int salonId);

    // READ
    List<Staff> findAll() throws StaffNotFoundException;
    List<Staff> findStaffBySalonId(int salonId) throws StaffNotFoundException;
    float findAverageSalary(int salonId);

    //UPDATE
    boolean updateById(int id, String columnName, String newValue);
    void updateById(int id, String columnName, int newValue);

    // DELETE
    void deleteById(int id);
}
