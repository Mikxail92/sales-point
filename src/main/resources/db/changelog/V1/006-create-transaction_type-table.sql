--liquibase formatted sql
--changeset Mihail:006-create-transaction_type-table.sql
--preconditions onFail:CONTINUE onError:CONTINUE

CREATE TABLE IF NOT EXISTS transaction_type
(
    id                    BIGSERIAL PRIMARY KEY, -- Уникальный идентификатор типа транзакции
    transaction_type_name VARCHAR(255) NOT NULL, -- Название типа транзакции
    operator              VARCHAR(1)   NOT NULL  -- Оператор, влияющий на транзакцию
);

INSERT INTO transaction_type (transaction_type_name, operator)
VALUES
    ('Списание со счета', '-'),
    ('Пополнение счета', '+');
