package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Salon;
import cian.herlihy.r00205604.model.SalonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalonDataAccess implements SalonDataDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int countTotalSalons() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM salon_data", Integer.class);
    }

    @Override
    public List<Salon> findAll() {
        return jdbcTemplate.query("SELECT * FROM salon_data", new SalonRowMapper());
    }
}
