CREATE TABLE Staff_Data (
    Staff_ID int NOT NULL PRIMARY KEY,
    Name varchar(50) NOT NULL,
    Phone_Number varchar(10),
    Annual_Salary int
);
CREATE TABLE Salon_Data (
    Salon_ID int NOT NULL PRIMARY KEY,
    Name varchar(50) NOT NULL,
    Address varchar(255) NOT NULL,
    Phone_Number varchar(10) NOT NULL,
    Days_Open int NOT NULL
);