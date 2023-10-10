package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Salon;
import cian.herlihy.r00205604.model.SalonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalonDataAccess implements SalonDataDao {

    private static final String TABLE = "salon_data";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int countTotalSalons() {
        String query = String.format(TOTAL_COUNT_QUERY, TABLE);
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    @Override
    public List<Salon> findAll() {
        String query = String.format(SELECT_ALL_QUERY, TABLE);
        return jdbcTemplate.query(query, new SalonRowMapper());
    }

    @Override
    public List<Salon> findSalonById(int id) {
        String query = String.format(FIND_BY_ID, TABLE, id);
        return jdbcTemplate.query(query, new SalonRowMapper());
    }

    @Override
    public List<Salon> findSalonByName(String name) {
        String query = String.format(FIND_BY_NAME, TABLE, name);
        return jdbcTemplate.query(query, new SalonRowMapper());
    }
}
