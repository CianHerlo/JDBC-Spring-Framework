package service;

import cian.herlihy.r00205604.Config;
import cian.herlihy.r00205604.service.StaffServiceImpl;
import cian.herlihy.r00205604.service.exceptions.StaffNotFoundException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StaffServiceImplTests {

    @Autowired
    private StaffServiceImpl staffService;

    @Test
    @Order(1)
    public void testFindAll() throws StaffNotFoundException {
        Assertions.assertEquals(4, staffService.findAll().size());
    }

    @Test
    @Order(2)
    public void testFindStaffBySalonId() throws StaffNotFoundException {
        Assertions.assertNotNull(staffService.findStaffBySalonId(1));
    }

    @Test
    @Order(3)
    public void testFindAverageSalary() {
        Assertions.assertEquals(33500.0, staffService.findAverageSalary(2));
    }

    @Test
    @Order(4)
    public void testEmptyFindStaffBySalonId() throws StaffNotFoundException {
        Assertions.assertEquals(0, staffService.findStaffBySalonId(111).size());
    }
}
