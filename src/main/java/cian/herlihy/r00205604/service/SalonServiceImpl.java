package cian.herlihy.r00205604.service;

import cian.herlihy.r00205604.dao.SalonDataDao;
import cian.herlihy.r00205604.model.Salon;
import cian.herlihy.r00205604.service.exceptions.SalonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonServiceImpl implements SalonService {

    @Autowired
    private SalonDataDao salonDataDao;

    @Override
    public void addSalon(int id, String name, String address, String phoneNumber, String daysOpen) {
        salonDataDao.addSalon(id, name, address, phoneNumber, daysOpen);
    }

    @Override
    public List<Salon> findAll() throws SalonNotFoundException {
        return salonDataDao.findAll().orElseThrow(() -> new SalonNotFoundException("Did not retrieve any salon data."));
    }

    public void printAllSalons(List<Salon> salonList) throws SalonNotFoundException {
        salonTableHeaderLayout();
        salonList.forEach(SalonServiceImpl::salonInfoFields);
    }

    public void printSalon(Salon salon) {
        salonTableHeaderLayout();
        salonInfoFields(salon);
    }

    private static void salonInfoFields(Salon salon) {
        System.out.printf(TABLE_INFO_FORMAT, salon.getSalon_id(), salon.getName(), salon.getAddress(), salon.getPhoneNumber());
        salon.getDays_open()
                .chars()
                .mapToObj(day -> day == '1' ? "Open" : "Closed")
                .forEach(status -> System.out.printf("%-10s", status));
        System.out.println();
    }

    private static void salonTableHeaderLayout() {
        System.out.printf(TABLE_HEADER_FORMAT, "ID", "Name", "Address", "Phone Num", "Mon", "Tue", "Wed",
                "Thu", "Fri", "Sat", "Sun");
    }

    @Override
    public Salon findSalonById(int id) throws SalonNotFoundException {
        return salonDataDao.findSalonById(id)
                .orElseThrow(() -> new SalonNotFoundException(String.format("Salon with id: %d not found.", id)));
    }

    @Override
    public List<Salon> findSalonByName(String name) throws SalonNotFoundException {
        return salonDataDao.findSalonByName(name)
                .orElseThrow(() -> new SalonNotFoundException(String.format("Salon with name: %s not found.", name)));
    }

    public void printSalonsWithDaysOpen() throws SalonNotFoundException {
        List<Salon> salonList = findAll();

        System.out.printf(DAYS_OPEN_HEADER, "Name", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

        // Filter and print salon information
        salonList.stream()
                .filter(salon -> !salon.getDays_open().contains("0"))
                .forEach(salon -> {
                    System.out.printf("%-30s", salon.getName());
                    salon.getDays_open()
                            .chars()
                            .mapToObj(day -> day == '1' ? "Open" : "Closed")
                            .forEach(status -> System.out.printf("%-10s", status));
                    System.out.println();
                });
    }

    @Override
    public void updateById(int id, String columnName, String newValue) {
        salonDataDao.updateById(id, columnName, newValue);
    }

    @Override
    public void deleteById(int id) {
        salonDataDao.deleteById(id);
    }
}
