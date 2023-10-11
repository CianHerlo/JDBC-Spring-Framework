package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Salon;
import cian.herlihy.r00205604.rowmappers.SalonRowMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SalonDataAccess implements SalonDataDao {

    private static final Logger LOGGER = LogManager.getLogger(SalonDataAccess.class);
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
        try {
            String query = String.format(INSERT_SALON, TABLE, id, name, address, phoneNumber, daysOpen);
            return jdbcTemplate.update(query) == 1;
        } catch (Exception e) {
            LOGGER.warn("Error adding Salon to table. Cause: {}", e.getMessage());
            return false;
        }
    }



    /*
     *               READ
     *
     * All read methods will be handled below.
     */

    @Override
    public Optional<Integer> countTotalSalons() {
        String query = String.format(TOTAL_COUNT_QUERY, TABLE);
        return Optional.ofNullable(jdbcTemplate.queryForObject(query, Integer.class));
    }

    @Override
    public Optional<List<Salon>> findAll() {
        String query = String.format(SELECT_ALL_QUERY, TABLE);
        return Optional.of(jdbcTemplate.query(query, new SalonRowMapper()));
    }

    @Override
    public Optional<Salon> findSalonById(int id) {
        try {
            String query = String.format(FIND_BY_ID, TABLE, id);
            return Optional.ofNullable(jdbcTemplate.queryForObject(query, Salon.class));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Salon>> findSalonByName(String name) {
        try {
            String query = String.format(FIND_BY_NAME, TABLE, name);
            return Optional.of(jdbcTemplate.query(query, new SalonRowMapper()));
        } catch (Exception e) {
            LOGGER.warn("Error finding Salon with matching name. Cause: {}", e.getMessage());
            return Optional.empty();
        }
    }



    /*
     *               UPDATE
     *
     * All update methods will be handled below.
     */

    @Override
    public boolean updateById(int id, String columnName, String newValue) {
        try {
            String query = String.format(UPDATE_BY_ID, TABLE, columnName, newValue, id);
            return jdbcTemplate.update(query) == 1;
        } catch (Exception e) {
            LOGGER.warn("Error updating salon by id. Cause: {}", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateByName(String name, String columnName, String newValue) {
        try {
            String query = String.format(UPDATE_BY_NAME, TABLE, columnName, newValue, name);
            return jdbcTemplate.update(query) >= 1;
        } catch (Exception e) {
            LOGGER.warn("Error updating salon by name. Cause: {}", e.getMessage());
            return false;
        }
    }



    /*
     *               DELETE
     *
     * All delete methods will be handled below.
     */

    @Override
    public boolean deleteById(int id) {
        try {
            String query = String.format(DELETE_BY_ID, TABLE, id);
            return jdbcTemplate.update(query) == 1;
        } catch (Exception e) {
            LOGGER.warn("Error deleting salon by id. Cause: {}", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteByName(String name) {
        try {
            String query = String.format(DELETE_BY_SALON_NAME, TABLE, name);
            return jdbcTemplate.update(query) == 1;
        } catch (Exception e) {
            LOGGER.warn("Error deleting salon by name. Cause: {}", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteByPHNumber(String phoneNumber) {
        try {
            String query = String.format(DELETE_BY_NUM, TABLE, phoneNumber);
            return jdbcTemplate.update(query) == 1;
        } catch (Exception e) {
            LOGGER.warn("Error deleting salon by phoneNumber. Cause: {}", e.getMessage());
            return false;
        }
    }
}
