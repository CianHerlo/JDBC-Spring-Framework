package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Staff;
import cian.herlihy.r00205604.model.StaffRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDataAccess implements StaffDataDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int countTotalStaff() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM staff_data", Integer.class);
    }

    @Override
    public List<Staff> findAll() {
        return jdbcTemplate.query("SELECT * FROM staff_data", new StaffRowMapper());
    }
}
