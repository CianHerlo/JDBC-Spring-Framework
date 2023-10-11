package cian.herlihy.r00205604.dao;

public interface CommonQueries {

    /*
        CREATE queries
    */
    String INSERT_SALON = "INSERT INTO %s (id, name, address, phone_number, days_open) VALUES (%d, %s, %s, %s, %s)";
    String INSERT_STAFF = "INSERT INTO %s (id, first_name, surname, phone_number, annual_salary) VALUES (%d, %s, %s, %s, %d)";

    /*
        READ queries
    */
    String TOTAL_COUNT_QUERY = "SELECT count(*) FROM %s";
    String SELECT_ALL_QUERY = "SELECT * FROM %s";
    String FIND_BY_ID = "SELECT * FROM %s WHERE id = %d";
    String FIND_BY_NAME = "SELECT * FROM %s WHERE name = %s";

    /*
        UPDATE queries
    */
    String UPDATE_BY_ID = "UPDATE %s SET %s = %s WHERE id = %d";
    String UPDATE_BY_NAME = "UPDATE %s SET %s = %s WHERE name = %s";
    String UPDATE_BY_FIRST_NAME = "UPDATE %s SET %s = %s WHERE first_name = %s";
    String UPDATE_BY_SURNAME = "UPDATE %s SET %s = %s WHERE surname = %s";

    /*
        DELETE queries
    */
    String DELETE_BY_ID = "DELETE FROM %s WHERE id = %d";
    String DELETE_BY_SALON_NAME = "DELETE FROM %s WHERE name = %s";
    String DELETE_BY_FIRST_NAME = "DELETE FROM %s WHERE first_name = %s";
    String DELETE_BY_SURNAME = "DELETE FROM %s WHERE surname = %s";
    String DELETE_BY_NUM = "DELETE FROM %s WHERE phone_number = %s";
}
