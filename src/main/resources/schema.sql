CREATE TABLE salon_data (
    id int NOT NULL PRIMARY KEY,
    name varchar(50) NOT NULL,
    address varchar(255) NOT NULL,
    phone_number varchar(10) NOT NULL,
    days_open varchar(7) NOT NULL
);

CREATE TABLE staff_data (
    id int NOT NULL PRIMARY KEY,
    first_name varchar(50) NOT NULL,
    surname varchar(50) NOT NULL,
    phone_number varchar(10),
    annual_salary int,
    salon_id int
);

-- DROP TABLE salon_data, staff_data;
