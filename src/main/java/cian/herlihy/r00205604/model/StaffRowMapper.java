package cian.herlihy.r00205604.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffRowMapper implements RowMapper<Staff> {

    @Override
    public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {

        Staff staff = new Staff();
        staff.setStaff_id(rs.getInt(1));
        staff.setName(rs.getString(2));
        staff.setPhone_number(rs.getString(3));
        staff.setSalary(rs.getInt(4));
        return staff;
    }
}
