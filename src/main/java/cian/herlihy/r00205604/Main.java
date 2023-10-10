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
        salonDataDao.findAll().forEach(System.out::println);

        StaffDataDao staffDataDao = applicationContext.getBean(StaffDataDao.class);
        staffDataDao.findAll().forEach(System.out::println);

        System.out.println(salonDataDao.findSalonById(1));
        System.out.println(staffDataDao.findStaffById(1));
    }
}