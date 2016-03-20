CREATE EXTENSION IF NOT EXISTS postgis;

CREATE TABLE IF NOT EXISTS "users" (
    user_name text PRIMARY KEY,
    first_name text,
    last_name text,
    location GEOMETRY(Point, 4326)
);
CREATE INDEX IF NOT EXISTS users_gix
    ON "users"
    USING GIST (location);


CREATE TABLE IF NOT EXISTS messages (
    id SERIAL PRIMARY KEY,
    content text NOT NULL,
    author text REFERENCES users(user_name),
    location GEOMETRY(Point, 4326)
);
CREATE INDEX IF NOT EXISTS messages_gix
    ON messages
    USING GIST (location);