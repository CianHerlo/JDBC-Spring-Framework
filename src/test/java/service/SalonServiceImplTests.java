package service;

import cian.herlihy.r00205604.Config;
import cian.herlihy.r00205604.service.SalonServiceImpl;
import cian.herlihy.r00205604.service.exceptions.SalonNotFoundException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SalonServiceImplTests {

    @Autowired
    private SalonServiceImpl salonService;

    @Test
    @Order(1)
    public void testFindAll() throws SalonNotFoundException {
        Assertions.assertEquals(4, salonService.findAll().size());
    }

    @Test
    @Order(2)
    public void testFindSalonById() throws SalonNotFoundException {
        Assertions.assertNotNull(salonService.findSalonById(1));
    }

    @Test
    @Order(3)
    public void testThrowsFindSalonById() {
        Executable executable = () -> salonService.findSalonById(5);
        Assertions.assertThrows(SalonNotFoundException.class, executable);
    }

    @Test
    @Order(4)
    public void testFindSalonByName() throws SalonNotFoundException {
        Assertions.assertNotNull(salonService.findSalonByName("Stylz"));
    }

    @Test
    @Order(5)
    public void testEmptySalonByName() throws SalonNotFoundException {
        Assertions.assertEquals(0, salonService.findSalonByName("Bob's Chip Shop").size());
    }
}
