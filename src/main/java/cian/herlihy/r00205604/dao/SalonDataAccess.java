package cian.herlihy.r00205604.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SalonDataAccess implements SalonDataDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int countTotalSalons() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM salon_data", Integer.class);
    }
}
