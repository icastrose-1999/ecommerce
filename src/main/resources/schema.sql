CREATE TABLE brands(
	brand_id INTEGER PRIMARY KEY,
	brand VARCHAR(50) NOT NULL
);

CREATE TABLE prices (
	rate_id BIGINT AUTO_INCREMENT PRIMARY KEY,
	brand_id INTEGER NOT NULL,
	start_date TIMESTAMP NOT NULL,
	end_date TIMESTAMP NOT NULL,
	product_id INTEGER NOT NULL,
	priority INTEGER NOT NULL,
	price DECIMAL(10,2),
	curr CHAR(3),
	CONSTRAINT fk_brand_id FOREIGN KEY (brand_id) REFERENCES brands(brand_id)
);