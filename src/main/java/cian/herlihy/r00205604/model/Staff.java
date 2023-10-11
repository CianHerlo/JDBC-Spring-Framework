package cian.herlihy.r00205604.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Staff {

    private int staffId;
    private String firstName;
    private String surname;
    private String phoneNumber;
    private int salary;
    private int salonId;
}
