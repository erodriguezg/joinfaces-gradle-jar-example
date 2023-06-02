CREATE TABLE cars (
	id_car uuid NOT NULL,
	id_brand int NOT NULL,
	model_code int NOT NULL,
	color varchar NULL,
	buy_date date NOT NULL,
	second_hand_car bool NOT NULL,
	CONSTRAINT cars_pk PRIMARY KEY (id_car),
	CONSTRAINT cars_fk FOREIGN KEY (id_brand,model_code) REFERENCES public.car_models(id_brand,model_code)
);
