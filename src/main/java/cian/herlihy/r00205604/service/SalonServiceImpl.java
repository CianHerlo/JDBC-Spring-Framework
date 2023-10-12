package cian.herlihy.r00205604.service;

import cian.herlihy.r00205604.dao.SalonDataDao;
import cian.herlihy.r00205604.model.Salon;
import cian.herlihy.r00205604.service.exceptions.SalonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SalonServiceImpl implements SalonService {

    @Autowired
    private SalonDataDao salonDataDao;


    @Override
    public boolean addSalon(int id, String name, String address, String phoneNumber, String daysOpen) {
        return salonDataDao.addSalon(id, name, address, phoneNumber, daysOpen);
    }

    @Override
    public List<Salon> findAll() throws SalonNotFoundException {
        return salonDataDao.findAll().orElseThrow(() -> new SalonNotFoundException("Did not retrieve any salon data."));
    }

    public void printAllSalons(List<Salon> salonList) throws SalonNotFoundException {
        System.out.printf("%-3s%-30s%-55s%-14s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%n", "ID", "Name", "Address", "Phone Num", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        salonList.forEach(salon -> {
            System.out.printf("%-3d%-30s%-55s%-14s", salon.getSalon_id(), salon.getName(), salon.getAddress(), salon.getPhoneNumber());
            salon.getDays_open()
                    .chars()
                    .mapToObj(day -> day == '1' ? "Open" : "Closed")
                    .forEach(status -> System.out.printf("%-10s", status));
            System.out.println();
        });
    }

    public void printSalon(Salon salon) {
        System.out.printf("%-3s%-30s%-55s%-14s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%n", "ID", "Name", "Address", "Phone Num", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        System.out.printf("%-3d%-30s%-55s%-14s", salon.getSalon_id(), salon.getName(), salon.getAddress(), salon.getPhoneNumber());
        salon.getDays_open()
                .chars()
                .mapToObj(day -> day == '1' ? "Open" : "Closed")
                .forEach(status -> System.out.printf("%-10s", status));
        System.out.println();
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

        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        // Print the header row with day names
        System.out.printf("%-30s", "Name");
        Arrays.stream(days).forEach(day -> System.out.printf("%-10s", day));
        System.out.println();

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
    public boolean updateById(int id, String columnName, String newValue) {
        return salonDataDao.updateById(id, columnName, newValue);
    }

    @Override
    public boolean deleteById(int id) {
        return salonDataDao.deleteById(id);
    }
}
