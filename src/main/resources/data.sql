INSERT INTO salon_data (id, name, address, phone_number, days_open)
VALUES
    (1, 'Stylz', 'Main Street, Nadrid, Cork', '0217334125', '0111110'),
    (2, 'Coachford Hair and Beauty', 'Main Street, Contead Beg, Coachford, Cork', '0217434477', '0111110'),
    (3, 'Lavender Hair Design', 'Unit 2 Railway View, Sleveen East, Macroom, Cork', '02641875', '1111110'),
    (4, 'Bounce Hair Salon', 'UNIT 4 Washington St, Centre, Cork', '0214278982', '1111111');

INSERT INTO staff_data (id, first_name, surname, phone_number, annual_salary, salon_id)
VALUES
    (1, 'Sheila', 'Murphy', '0871234567', 60000, 1),
    (2, 'Mary', 'Horgan', '0865542687', 30000, 2),
    (3, 'Jessica', 'O Donovan', '0851994622', 37000, 2),
    (4, 'Amy', 'Lehane', '0837774215', 41000, 3),
    (5, 'Jade', 'Corkery', '0879882625', 28000, 4);