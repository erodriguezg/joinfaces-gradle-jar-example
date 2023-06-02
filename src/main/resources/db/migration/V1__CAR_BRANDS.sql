CREATE TABLE car_brands (
	id_brand int NOT NULL,
	name_brand varchar NOT NULL,
	country varchar NOT NULL,
	CONSTRAINT car_brands_pk PRIMARY KEY (id_brand),
	CONSTRAINT car_brands_un UNIQUE (name_brand)
);

insert into car_brands (id_brand, name_brand, country) values 
(1, 'Aston Martin', 'United Kingdom'),
(2, 'Ferrari', 'Italy'),
(3, 'Lamborghini', 'Italy'),
(4, 'Jaguar', 'United Kingdom'),
(5, 'Porsche', 'Germany'),
(6, 'BMW', 'Germany'),
(7, 'Ford', 'United States'),
(8, 'Tesla', 'United States'),
(9, 'Toyota', 'Japan');