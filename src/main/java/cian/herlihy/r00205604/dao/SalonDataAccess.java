package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Salon;
import cian.herlihy.r00205604.model.SalonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalonDataAccess implements SalonDataDao {

    private static final String COUNT_QUERY = "SELECT count(*) FROM salon_data";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM salon_data";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int countTotalSalons() {
        return jdbcTemplate.queryForObject(COUNT_QUERY, Integer.class);
    }

    @Override
    public List<Salon> findAll() {
        return jdbcTemplate.query(SELECT_ALL_QUERY, new SalonRowMapper());
    }
}
