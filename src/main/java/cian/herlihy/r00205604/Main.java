package cian.herlihy.r00205604;

import cian.herlihy.r00205604.dao.SalonDataDao;
import cian.herlihy.r00205604.dao.StaffDataDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(applicationContext.getMessage("welcome", null, Locale.getDefault()));
        SalonDataDao salonDataDao = applicationContext.getBean(SalonDataDao.class);

        StaffDataDao staffDataDao = applicationContext.getBean(StaffDataDao.class);

        System.out.println("Get all salons");
        System.out.println(salonDataDao.findAll());

        System.out.println("Create a new salon providing all data and return this new salon");
        salonDataDao.addSalon(4, "REVO Hair & Beauty", "10 Parnell Pl, Centre, Cork",
                "0214248966", "0111110");
        System.out.println(salonDataDao.findSalonById(4));

        System.out.println("Get a salon by its primary key");
        System.out.println(salonDataDao.findSalonById(1));

        System.out.println("Update salon by modifying the days on which it is open");
        System.out.println(salonDataDao.findSalonById(1));
        salonDataDao.updateById(1, "days_open", "1010101");
        System.out.println(salonDataDao.findSalonById(1));

    }
}