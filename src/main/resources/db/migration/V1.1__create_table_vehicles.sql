CREATE TABLE vehicles (
      id BIGSERIAL PRIMARY KEY,
      name VARCHAR(30) NOT NULL,
      color VARCHAR(20) NOT NULL,
      year INTEGER NOT NULL,
      brand_id BIGINT,
      created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
      updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
      CONSTRAINT fk_vehicle_brand
          FOREIGN KEY (brand_id)
              REFERENCES brands(id)
              ON DELETE SET NULL
              ON UPDATE CASCADE
);

