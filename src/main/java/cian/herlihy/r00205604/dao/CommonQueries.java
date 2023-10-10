package cian.herlihy.r00205604.dao;

public interface CommonQueries {

    String TOTAL_COUNT_QUERY = "SELECT count(*) FROM %s";
    String SELECT_ALL_QUERY = "SELECT * FROM %s";
    String FIND_BY_ID = "Select * FROM %s WHERE id = %d";
    String FIND_BY_NAME = "Select * FROM %s WHERE name = %s";

}
