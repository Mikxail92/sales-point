--liquibase formatted sql
--changeset Mihail:008-create-card-table.sql
--preconditions onFail:CONTINUE onError:CONTINUE

CREATE TABLE IF NOT EXISTS card
(
    id                         BIGSERIAL PRIMARY KEY,                                            -- Уникальный идентификатор карты
    card_number                VARCHAR(50) NOT NULL,                                             -- Номер карты
    expiration_date            DATE        NOT NULL,                                             -- Срок действия карты
    holder_name                VARCHAR(50) NOT NULL,                                             -- Имя владельца
    payment_system_id          BIGINT      NOT NULL,                                             -- Ссылка на платёжную систему
    CONSTRAINT fk_payment_system FOREIGN KEY (payment_system_id) REFERENCES payment_system (id) -- Внешний ключ на таблицу payment_system
);

INSERT INTO card (card_number, expiration_date, holder_name, payment_system_id)
VALUES
    ('4123450000000019', '2025-12-31', 'IVAN I. IVANOV',  1),
    ('5123450000000024', '2025-12-31', 'SEMION E. PETROV',  2);
