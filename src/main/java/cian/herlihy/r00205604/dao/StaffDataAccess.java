package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Salon;
import cian.herlihy.r00205604.model.Staff;
import cian.herlihy.r00205604.rowmappers.StaffRowMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StaffDataAccess implements StaffDataDao {

    private static final Logger LOGGER = LogManager.getLogger(SalonDataAccess.class);
    private static final String TABLE = "staff_data";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private  SalonDataAccess salonDataAccess;



    /*
     *               CREATE
     *
     * All create methods will be handled below.
     */

    @Override
    public boolean addStaff(int id, String firstName, String surname, String phoneNumber, int annualSalary, int salonId) {
        try {
            Optional<Staff> existingStaff = findStaffById(id);
            Optional<Salon> existingSalon = salonDataAccess.findSalonById(salonId);

            if (existingStaff.isPresent() || existingSalon.isEmpty()) {
                return false;
            } else {

                MapSqlParameterSource parameters = new MapSqlParameterSource();
                parameters.addValue("id", id);
                parameters.addValue("first_name", firstName);
                parameters.addValue("surname", surname);
                parameters.addValue("phone_number", phoneNumber);
                parameters.addValue("annual_salary", annualSalary);
                parameters.addValue("salon_id", salonId);

                String insertSql = String.format(INSERT_STAFF, TABLE);
                namedParameterJdbcTemplate.update(insertSql, parameters);
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Error adding Staff to table. Cause: {}", e.getMessage());
            return false;
        }
    }



    /*
     *               READ
     *
     * All read methods will be handled below.
     */

    @Override
    public Optional<List<Staff>> findAll() {
        String query = String.format(SELECT_ALL_QUERY, TABLE);
        return Optional.of(namedParameterJdbcTemplate.getJdbcTemplate().query(query, new StaffRowMapper()));
    }

    @Override
    public Optional<Staff> findStaffById(int id) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("id", id);

            String query = String.format(FIND_BY_ID, TABLE);
            List<Staff> staffList = namedParameterJdbcTemplate.query(query, parameters, new StaffRowMapper());

            if (staffList.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(staffList.get(0));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Staff>> findStaffBySalonId(int salonId) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("salon_id", salonId);

            String query = String.format(FIND_BY_SALON_ID, TABLE);
            List<Staff> staffList = namedParameterJdbcTemplate.query(query, parameters, new StaffRowMapper());
            return Optional.of(staffList);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public float findAverageSalary(int salonId) {
        try {
            Optional<List<Staff>> staffListOptional = findStaffBySalonId(salonId);

            if (staffListOptional.isPresent()) {
                List<Staff> staffList = staffListOptional.get();
                if (staffList.isEmpty()) {
                    return 0.0f;
                }

                return (float) staffList.stream()
                        .mapToDouble(Staff::getSalary)
                        .average()
                        .orElse(0.0);
            }
        } catch (Exception e) {
            LOGGER.error("Failed to find average salary. Cause: {}", e.getMessage());
            return 0.0f;
        }
        return 0.0f;
    }





    /*
     *               UPDATE
     *
     * All update methods will be handled below.
     */

    @Override
    public boolean updateById(int id, String columnName, String newValue) {
        try {
            String query = String.format("UPDATE " + TABLE + " SET " + columnName + " = " +
                    newValue + " WHERE id = " + id);
            return namedParameterJdbcTemplate.getJdbcTemplate().update(query) == 1;
        } catch (Exception e) {
            LOGGER.error("Error updating staff by id. Cause: {}", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateById(int id, String columnName, int newValue) {
        try {
            String query = String.format("UPDATE " + TABLE + " SET " + columnName + " = " +
                    newValue + " WHERE id = " + id);
            return namedParameterJdbcTemplate.getJdbcTemplate().update(query) == 1;
        } catch (Exception e) {
            LOGGER.error("Error updating staff by id. Cause: {}", e.getMessage());
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
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("id", id);

            String query = String.format(DELETE_BY_ID, TABLE);
            return namedParameterJdbcTemplate.update(query, parameters) == 1;
        } catch (Exception e) {
            LOGGER.error("Error deleting staff by id. Cause: {}", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteBySalonId(int salonId) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("salon_id", salonId);

            String query = String.format(DELETE_BY_SALON_ID, TABLE);
            int rowsAffected = namedParameterJdbcTemplate.update(query, parameters);
            return rowsAffected > 0;
        } catch (Exception e) {
            LOGGER.error("Error deleting staff by salon_id. Cause: {}", e.getMessage());
            return false;
        }
    }
}
