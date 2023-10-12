package cian.herlihy.r00205604.service;

import cian.herlihy.r00205604.dao.StaffDataDao;
import cian.herlihy.r00205604.model.Staff;
import cian.herlihy.r00205604.service.exceptions.StaffNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDataDao staffDataDao;

    @Override
    public boolean addStaff(int id, String firstName, String surname, String phoneNumber, int annualSalary, int salonId) {
        return staffDataDao.addStaff(id, firstName, surname, phoneNumber, annualSalary, salonId);
    }

    @Override
    public List<Staff> findAll() throws StaffNotFoundException {
        return staffDataDao.findAll().orElseThrow(() -> new StaffNotFoundException("Did not retrieve any staff data."));
    }

    @Override
    public Staff findStaffById(int id) throws StaffNotFoundException {
        return staffDataDao.findStaffById(id)
                .orElseThrow(() -> new StaffNotFoundException(String.format("Staff with id: %d not found.", id)));
    }

    @Override
    public List<Staff> findStaffBySalonId(int salonId) throws StaffNotFoundException {
        return staffDataDao.findStaffBySalonId(salonId)
                .orElseThrow(() -> new StaffNotFoundException(String.format("Staff with salon_id: %d not found.", salonId)));
    }

    @Override
    public float findAverageSalary(int salonId) {
        return staffDataDao.findAverageSalary(salonId);
    }

    public void printAllStaff(List<Staff> staffList) {
        System.out.printf("%-11s%-16s%-16s%-15s%-15s%-9s%n", "Staff ID", "First Name", "Surname", "Phone Number", "Salary", "Salon ID");
        staffList.forEach(staff -> {
            System.out.printf("%-11d%-16s%-16s%-15s%-15d%-9d%n", staff.getStaffId(), staff.getFirstName(),
                    staff.getSurname(), staff.getPhoneNumber(), staff.getSalary(), staff.getSalonId());
        });
    }

    public void printStaff(Staff staff) {
        System.out.printf("%-11s%-16s%-16s%-15s%-15s%-9s%n", "Staff ID", "First Name", "Surname", "Phone Number", "Salary", "Salon ID");
        System.out.printf("%-11d%-16s%-16s%-15s%-15d%-9d%n", staff.getStaffId(), staff.getFirstName(),
                staff.getSurname(), staff.getPhoneNumber(), staff.getSalary(), staff.getSalonId());
    }

    @Override
    public boolean updateById(int id, String columnName, String newValue) {
        return staffDataDao.updateById(id, columnName, newValue);
    }

    @Override
    public boolean updateById(int id, String columnName, int newValue) {
        return staffDataDao.updateById(id, columnName, newValue);
    }

    @Override
    public boolean deleteById(int id) {
        return staffDataDao.deleteById(id);
    }

    @Override
    public boolean deleteBySalonId(int salonId) {
        return staffDataDao.deleteBySalonId(salonId);
    }
}
