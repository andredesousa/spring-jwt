CREATE TABLE IF NOT EXISTS "users"
(
	id serial PRIMARY KEY,
	username VARCHAR (20) UNIQUE NOT NULL,
	password VARCHAR (65) NOT NULL,
	email VARCHAR (255) UNIQUE NOT NULL,
	is_enabled boolean DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS "user_role"
(
    id serial PRIMARY KEY,
    user_id integer NOT NULL,
	role VARCHAR (20) NOT NULL
);

ALTER TABLE IF EXISTS "user_role"
	ADD CONSTRAINT users_user_roles FOREIGN KEY (user_id) REFERENCES "users" (id);
