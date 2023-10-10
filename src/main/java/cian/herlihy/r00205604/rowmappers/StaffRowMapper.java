package cian.herlihy.r00205604.rowmappers;

import cian.herlihy.r00205604.model.Staff;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffRowMapper implements RowMapper<Staff> {

    @Override
    public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {

        Staff staff = new Staff();
        staff.setStaff_id(rs.getInt(1));
        staff.setFirst_name(rs.getString(2));
        staff.setSurname(rs.getString(3));
        staff.setPhone_number(rs.getString(4));
        staff.setSalary(rs.getInt(5));
        return staff;
    }
}
