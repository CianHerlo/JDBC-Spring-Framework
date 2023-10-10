package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Staff;
import cian.herlihy.r00205604.model.StaffRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDataAccess implements StaffDataDao {

    private static final String TABLE = "staff_data";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int countTotalStaff() {
        String query = String.format(TOTAL_COUNT_QUERY, TABLE);
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    @Override
    public List<Staff> findAll() {
        String query = String.format(SELECT_ALL_QUERY, TABLE);
        return jdbcTemplate.query(query, new StaffRowMapper());
    }

    @Override
    public List<Staff> findStaffById(int id) {
        String query = String.format(FIND_BY_ID, TABLE, id);
        return jdbcTemplate.query(query, new StaffRowMapper());
    }

    @Override
    public List<Staff> findStaffByName(String name) {
        String query = String.format(FIND_BY_NAME, TABLE, name);
        return jdbcTemplate.query(query, new StaffRowMapper());
    }
}
