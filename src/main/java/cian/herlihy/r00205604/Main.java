package cian.herlihy.r00205604;

import cian.herlihy.r00205604.dao.SalonDataDao;
import cian.herlihy.r00205604.dao.StaffDataDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(applicationContext.getMessage("welcome", null, Locale.getDefault()));
        SalonDataDao salonDataDao = applicationContext.getBean(SalonDataDao.class);
        StaffDataDao staffDataDao = applicationContext.getBean(StaffDataDao.class);

        // Salon data
        System.out.println("Get all salons");
        System.out.println(salonDataDao.findAll());
        System.out.println();

        System.out.println("Create a new salon providing all data and return this new salon");
        salonDataDao.addSalon(5, "REVO Hair & Beauty", "10 Parnell Pl, Centre, Cork",
                "0214248966", "0111110");
        System.out.println(salonDataDao.findSalonById(5));
        System.out.println();

        System.out.println("Get all salons by name");
        System.out.println(salonDataDao.findSalonByName("Stylz"));
        System.out.println();

        System.out.println("Get a salon by its primary key");
        System.out.println(salonDataDao.findSalonById(1));
        System.out.println();

        System.out.println("Update salon by modifying the days on which it is open");
        System.out.println(salonDataDao.findSalonById(1));
        salonDataDao.updateById(1, "days_open", "1010101");
        System.out.println(salonDataDao.findSalonById(1));
        System.out.println();

        System.out.println("Delete a salon and all that salon's stylists.");
        System.out.println(salonDataDao.findAll());
        System.out.println(staffDataDao.findAll());
        salonDataDao.deleteById(1);
        System.out.println(salonDataDao.findAll());
        System.out.println(staffDataDao.findAll());
        System.out.println();

        System.out.println("List all those salons open 7 days a week");
        salonDataDao.findAll().ifPresent(salonList -> {
            salonList.stream().filter(salon -> !salon.getDays_open().contains("0"))
                    .forEach(System.out::println);
        });
        System.out.println();
        System.out.println();
        System.out.println();

        // Staff data
        System.out.println("Get all stylists in a particular salon");
        System.out.println(staffDataDao.findStaffBySalonId(1));
        System.out.println();

        System.out.println("Add a stylist, ensuring you add them to a salon");
        staffDataDao.addStaff(6, "Rachael", "Meehan", "0851112749", 51000, 5);
        System.out.println(staffDataDao.findAll());
        System.out.println(staffDataDao.findStaffById(6));
        System.out.println();

        System.out.println("Move a stylist from one salon to another");
        System.out.println(staffDataDao.findStaffById(6));
        staffDataDao.updateById(6, "salon_id", 1);
        System.out.println(staffDataDao.findStaffById(6));
        System.out.println();

        System.out.println("Delete a stylist");
        System.out.println(staffDataDao.findAll());
        staffDataDao.deleteById(6);
        System.out.println(staffDataDao.findAll());
        System.out.println();

        System.out.println("Determine the average salary of stylists in a particular salon");
        System.out.println(staffDataDao.findStaffBySalonId(2));
        System.out.println(staffDataDao.findAverageSalary(2));
        System.out.println();
    }
}