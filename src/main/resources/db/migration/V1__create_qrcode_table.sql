CREATE TABLE qr_code_entity (
    id BIGSERIAL PRIMARY KEY,
    link VARCHAR(255) NOT NULL,
    image BYTEA NOT NULL
);
