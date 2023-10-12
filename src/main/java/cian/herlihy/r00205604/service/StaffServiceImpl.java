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
    public void addStaff(int id, String firstName, String surname, String phoneNumber, int annualSalary, int salonId) {
        staffDataDao.addStaff(id, firstName, surname, phoneNumber, annualSalary, salonId);
    }

    @Override
    public List<Staff> findAll() throws StaffNotFoundException {
        return staffDataDao.findAll().orElseThrow(() -> new StaffNotFoundException("Did not retrieve any staff data."));
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
        System.out.printf(TABLE_HEADER_FORMAT, "Staff ID", "First Name", "Surname", "Phone Number", "Salary", "Salon ID");
        staffList.forEach(staff -> {
            System.out.printf(TABLE_HEADER_FORMAT, staff.getStaffId(), staff.getFirstName(),
                    staff.getSurname(), staff.getPhoneNumber(), staff.getSalary(), staff.getSalonId());
        });
    }

    @Override
    public boolean updateById(int id, String columnName, String newValue) {
        return staffDataDao.updateById(id, columnName, newValue);
    }

    @Override
    public void updateById(int id, String columnName, int newValue) {
        staffDataDao.updateById(id, columnName, newValue);
    }

    @Override
    public void deleteById(int id) {
        staffDataDao.deleteById(id);
    }

}
