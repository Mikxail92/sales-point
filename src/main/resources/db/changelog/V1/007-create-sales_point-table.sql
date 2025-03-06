--liquibase formatted sql
--changeset Murad:007-create-sales_point-table.sql
--preconditions onFail:CONTINUE onError:CONTINUE

CREATE TABLE IF NOT EXISTS sales_point
(
    id                BIGSERIAL PRIMARY KEY, -- Уникальный идентификатор точки продаж
    pos_name          VARCHAR(255) NOT NULL, -- Название точки продаж
    pos_address       VARCHAR(255) NOT NULL, -- Адрес точки продаж
    pos_inn           VARCHAR(12)  NOT NULL, -- ИНН точки продаж
    acquiring_bank_id BIGINT       NOT NULL, -- Ссылка на банк-эквайер
    CONSTRAINT fk_acquiring_bank FOREIGN KEY (acquiring_bank_id)
        REFERENCES acquiring_bank (id)       -- Внешний ключ на таблицу acquiring_bank
);

INSERT INTO sales_point (pos_name, pos_address, pos_inn, acquiring_bank_id)
VALUES
    ('Shop №1', 'City, 1-st 1', '1234567890', 1),
    ('Shop №2', 'City, 2-st 2', '1234567891', 2),
    ('Shop №3', 'City, 3-st 3', '1234567892', 1);
