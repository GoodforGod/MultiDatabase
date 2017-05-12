
CREATE TABLE shop.user_credentials(
  id SERIAL PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  email VARCHAR(128) NOT NULL,
  password VARCHAR(64) NOT NULL
);

CREATE TABLE shop.user_addresses(
  id BIGINT PRIMARY KEY REFERENCES shop.user_credentials(id),
  address VARCHAR(128),
  country VARCHAR(128),
  city VARCHAR(128),
  index BIGINT
);


INSERT INTO shop.user_credentials(id, name, email, password)
  SELECT x.id, 'bob', 'bobmail#' || x.id || '@mail.ru', 'pass'
  FROM generate_series(1, 10) AS x(name);

