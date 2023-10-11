package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Salon;
import cian.herlihy.r00205604.rowmappers.SalonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalonDataAccess implements SalonDataDao {

    private static final String TABLE = "salon_data";

    @Autowired
    private JdbcTemplate jdbcTemplate;



    /*
     *               CREATE
     *
     * All create methods will be handled below.
     */

    @Override
    public boolean addSalon(int id, String name, String address, String phoneNumber, String daysOpen) {
        String query = String.format(INSERT_SALON, TABLE, id, name, address, phoneNumber, daysOpen);
        return jdbcTemplate.update(query) == 1;
    }



    /*
     *               READ
     *
     * All read methods will be handled below.
     */

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



    /*
     *               UPDATE
     *
     * All update methods will be handled below.
     */

    @Override
    public boolean updateById(int id, String columnName, String newValue) {
        String query = String.format(UPDATE_BY_ID, TABLE, columnName, newValue, id);
        return jdbcTemplate.update(query) == 1;
    }

    @Override
    public boolean updateByName(String name, String columnName, String newValue) {
        String query = String.format(UPDATE_BY_NAME, TABLE, columnName, newValue, name);
        return jdbcTemplate.update(query) >= 1;
    }



    /*
     *               DELETE
     *
     * All delete methods will be handled below.
     */

    @Override
    public boolean deleteById(int id) {
        String query = String.format(DELETE_BY_ID, TABLE, id);
        return jdbcTemplate.update(query) == 1;
    }

    @Override
    public boolean deleteByName(String name) {
        String query = String.format(DELETE_BY_SALON_NAME, TABLE, name);
        return jdbcTemplate.update(query) == 1;
    }

    @Override
    public boolean deleteByPHNumber(String phoneNumber) {
        String query = String.format(DELETE_BY_NUM, TABLE, phoneNumber);
        return jdbcTemplate.update(query) == 1;
    }
}
