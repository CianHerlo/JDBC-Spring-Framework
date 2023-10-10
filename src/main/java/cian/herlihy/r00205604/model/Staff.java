package cian.herlihy.r00205604.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Staff {

    private int staff_id;
    private String first_name;
    private String surname;
    private String phone_number;
    private int salary;
}
