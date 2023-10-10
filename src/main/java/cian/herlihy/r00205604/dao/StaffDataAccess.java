package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Staff;
import cian.herlihy.r00205604.model.StaffRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDataAccess implements StaffDataDao {

    private static final String COUNT_QUERY = "SELECT count(*) FROM staff_data";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM staff_data";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int countTotalStaff() {
        return jdbcTemplate.queryForObject(COUNT_QUERY, Integer.class);
    }

    @Override
    public List<Staff> findAll() {
        return jdbcTemplate.query(SELECT_ALL_QUERY, new StaffRowMapper());
    }
}
