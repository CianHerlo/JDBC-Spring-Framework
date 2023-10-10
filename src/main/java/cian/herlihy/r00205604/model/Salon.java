package cian.herlihy.r00205604.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Salon {

    private int salon_id;
    private String name;
    private String address;
    private String phone_number;
    private String days_open;   // MTWTFSS = 0111110 -> Closed Monday & Sunday
}
