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
    String SELECT_ALL_QUERY = "SELECT * FROM %s";
    String FIND_BY_ID = "SELECT * FROM %s WHERE id = :id";
    String FIND_BY_SALON_ID = "SELECT * FROM %s WHERE salon_id = :salon_id";
    String FIND_BY_NAME = "SELECT * FROM %s WHERE name = :name";

    /*
        UPDATE queries

        No update queries. Manually done in DataAccess classes due to issues
    */

    /*
        DELETE queries
    */
    String DELETE_BY_ID = "DELETE FROM %s WHERE id = :id";
    String DELETE_BY_SALON_ID = "DELETE FROM %s WHERE salon_id = :salon_id";
}
