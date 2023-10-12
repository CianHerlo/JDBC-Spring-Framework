package cian.herlihy.r00205604.dao;

public interface Queries {

    /*
        CREATE queries
    */
    String INSERT_SALON = "INSERT INTO %s (id, name, address, phone_number, days_open) " +
            "VALUES (:id, :name, :address, :phone_number, :days_open)";
    String INSERT_STAFF = "INSERT INTO %s (id, first_name, surname, phone_number, annual_salary, salon_id) " +
            "VALUES (:id, :first_name, :surname, :phone_number, :annual_salary, :salon_id)";

    /*
        READ queries
    */
    String TOTAL_COUNT_QUERY = "SELECT count(*) FROM %s";
    String SELECT_ALL_QUERY = "SELECT * FROM %s";
    String FIND_BY_ID = "SELECT * FROM %s WHERE id = :id";
    String FIND_BY_SALON_ID = "SELECT * FROM %s WHERE salon_id = :salon_id";
    String FIND_BY_NAME = "SELECT * FROM %s WHERE name = :name";

    /*
        UPDATE queries
    */
    String UPDATE_BY_ID = "UPDATE %s SET %s = :days_open WHERE id = :id";
    String UPDATE_BY_NAME = "UPDATE %s SET %s = %s WHERE name = %s";
    String UPDATE_BY_FIRST_NAME = "UPDATE %s SET %s = %s WHERE first_name = %s";
    String UPDATE_BY_SURNAME = "UPDATE %s SET %s = %s WHERE surname = %s";

    /*
        DELETE queries
    */
    String DELETE_BY_ID = "DELETE FROM %s WHERE id = :id";
    String DELETE_BY_SALON_ID = "DELETE FROM %s WHERE salon_id = :salon_id";
    String DELETE_BY_SALON_NAME = "DELETE FROM %s WHERE name = %s";
    String DELETE_BY_FIRST_NAME = "DELETE FROM %s WHERE first_name = %s";
    String DELETE_BY_SURNAME = "DELETE FROM %s WHERE surname = %s";
    String DELETE_BY_NUM = "DELETE FROM %s WHERE phone_number = %s";
}
