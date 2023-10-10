package cian.herlihy.r00205604.rowmappers;

import cian.herlihy.r00205604.model.Salon;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalonRowMapper implements RowMapper<Salon> {

    @Override
    public Salon mapRow(ResultSet rs, int rowNum) throws SQLException {

        Salon salon = new Salon();
        salon.setSalon_id(rs.getInt(1));
        salon.setName(rs.getString(2));
        salon.setAddress(rs.getString(3));
        salon.setPhone_number(rs.getString(4));
        salon.setDays_open(rs.getString(5));
        return salon;
    }
}
