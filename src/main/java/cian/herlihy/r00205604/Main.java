package cian.herlihy.r00205604;

import cian.herlihy.r00205604.model.Salon;
import cian.herlihy.r00205604.service.SalonServiceImpl;
import cian.herlihy.r00205604.service.StaffServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String TASK_TITLE = "\n--------------------\n";

    public static void main(String[] args) {

        try {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
            System.out.println(applicationContext.getMessage("welcome", null, Locale.getDefault()));
            System.out.println(applicationContext.getMessage("welcome", null, Locale.FRENCH));
            System.out.println(applicationContext.getMessage("welcome", null, Locale.GERMAN));

            SalonServiceImpl salonService = applicationContext.getBean(SalonServiceImpl.class);
            StaffServiceImpl staffService = applicationContext.getBean(StaffServiceImpl.class);

            // Salon data
            System.out.println(TASK_TITLE);
            System.out.println("Get all salons");
            salonService.printAllSalons(salonService.findAll());
            System.out.println();

            System.out.println(TASK_TITLE);
            System.out.println("Create a new salon providing all data and return this new salon");
            salonService.addSalon(5, "REVO Hair & Beauty", "10 Parnell Pl, Centre, Cork",
                    "0214248966", "0111110");
            salonService.printAllSalons(salonService.findAll());
            System.out.println();

            System.out.println(TASK_TITLE);
            System.out.println("Get all salons by name");
            salonService.printAllSalons(salonService.findSalonByName("Stylz"));
            System.out.println();

            System.out.println(TASK_TITLE);
            System.out.println("Get a salon by its primary key");
            List<Salon> salons = Collections.singletonList(salonService.findSalonById(2));
            salonService.printAllSalons(salons);
            System.out.println();

            System.out.println(TASK_TITLE);
            System.out.println("Update salon by modifying the days on which it is open");
            Salon salon3Before = salonService.findSalonById(3);
            salonService.printSalon(salon3Before);
            System.out.println();
            salonService.updateById(3, "days_open", "1010101");
            Salon salon3After = salonService.findSalonById(3);
            salonService.printSalon(salon3After);
            System.out.println();

            System.out.println(TASK_TITLE);
            System.out.println("Delete a salon and all that salon's stylists.");
            salonService.printAllSalons(salonService.findAll());
            System.out.println();
            staffService.printAllStaff(staffService.findAll());
            salonService.deleteById(1);
            System.out.println();
            salonService.printAllSalons(salonService.findAll());
            System.out.println();
            staffService.printAllStaff(staffService.findAll());
            System.out.println();

            System.out.println(TASK_TITLE);
            System.out.println("List all those salons open 7 days a week");
            salonService.printSalonsWithDaysOpen();
            System.out.println("\n\n\n");


            // Staff data
            System.out.println(TASK_TITLE);
            System.out.println("Get all stylists in a particular salon");
            staffService.printAllStaff(staffService.findStaffBySalonId(2));
            System.out.println();

            System.out.println(TASK_TITLE);
            System.out.println("Add a stylist, ensuring you add them to a salon");
            staffService.printAllStaff(staffService.findAll());
            System.out.println();
            staffService.addStaff(6, "Rachael", "Meehan", "0851112749", 51000, 5);
            staffService.printAllStaff(staffService.findAll());
            System.out.println();

            System.out.println(TASK_TITLE);
            System.out.println("Move a stylist from one salon to another");
            staffService.printAllStaff(staffService.findAll());
            System.out.println();
            staffService.updateById(6, "salon_id", 2);
            staffService.printAllStaff(staffService.findAll());
            System.out.println();

            System.out.println(TASK_TITLE);
            System.out.println("Delete a stylist");
            staffService.printAllStaff(staffService.findAll());
            System.out.println();
            staffService.deleteById(6);
            staffService.printAllStaff(staffService.findAll());
            System.out.println();

            System.out.println(TASK_TITLE);
            System.out.println("Determine the average salary of stylists in a particular salon");
            List<Salon> salonNum2 = Collections.singletonList(salonService.findSalonById(2));
            salonService.printAllSalons(salonNum2);
            System.out.println();
            staffService.printAllStaff(staffService.findStaffBySalonId(2));
            System.out.println();
            System.out.println("Average Salary: €" + staffService.findAverageSalary(2));
            System.out.println();
        } catch (Exception e) {
            LOGGER.error("Error occurred. Cause: {}", e.getMessage());
        }
    }
}
