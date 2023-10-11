package cian.herlihy.r00205604.dao;

import cian.herlihy.r00205604.model.Staff;
import cian.herlihy.r00205604.rowmappers.StaffRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDataAccess implements StaffDataDao {

    /*
     *               Staff Fields
     *
     * id               int
     * firstName        String
     * surname          String
     * phoneNumber      String
     * annualSalary     int
     */

    private static final String TABLE = "staff_data";

    @Autowired
    private JdbcTemplate jdbcTemplate;



    /*
     *               CREATE
     *
     * All create methods will be handled below.
     */

    @Override
    public boolean addStaff(int id, String firstName, String surname, String phoneNumber, int annualSalary) {
        String query = String.format(INSERT_STAFF, TABLE, id, firstName, surname, phoneNumber, annualSalary);
        return jdbcTemplate.update(query) == 1;
    }



    /*
     *               READ
     *
     * All read methods will be handled below.
     */

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
    public Staff findStaffById(int id) {
        String query = String.format(FIND_BY_ID, TABLE, id);
        return jdbcTemplate.queryForObject(query, new StaffRowMapper());
    }

    @Override
    public List<Staff> findStaffByFirstName(String firstName) {
        String query = String.format(FIND_BY_NAME, TABLE, firstName);
        return jdbcTemplate.query(query, new StaffRowMapper());
    }

    @Override
    public List<Staff> findStaffBySurname(String surname) {
        String query = String.format(FIND_BY_NAME, TABLE, surname);
        return jdbcTemplate.query(query, new StaffRowMapper());
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
    public boolean updateByFirstName(String firstName, String columnName, String newValue) {
        String query = String.format(UPDATE_BY_FIRST_NAME, TABLE, columnName, newValue, firstName);
        return jdbcTemplate.update(query) >= 1;
    }

    @Override
    public boolean updateBySurname(String surname, String columnName, String newValue) {
        String query = String.format(UPDATE_BY_SURNAME, TABLE, columnName, newValue, surname);
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
    public boolean deleteByFirstName(String firstName) {
        String query = String.format(DELETE_BY_FIRST_NAME, TABLE, firstName);
        return jdbcTemplate.update(query) == 1;
    }

    @Override
    public boolean deleteBySurname(String surname) {
        String query = String.format(DELETE_BY_SURNAME, TABLE, surname);
        return jdbcTemplate.update(query) == 1;
    }

    @Override
    public boolean deleteByPHNumber(String phoneNumber) {
        String query = String.format(DELETE_BY_NUM, TABLE, phoneNumber);
        return jdbcTemplate.update(query) == 1;
    }
}
