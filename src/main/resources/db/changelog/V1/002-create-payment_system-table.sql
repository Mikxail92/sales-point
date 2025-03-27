--liquibase formatted sql
--changeset Mihail:002-create-payment_system-table.sql
--preconditions onFail:CONTINUE onError:CONTINUE

CREATE TABLE IF NOT EXISTS payment_system
(
    id                  BIGSERIAL PRIMARY KEY, -- Уникальный идентификатор платёжной системы
    payment_system_name VARCHAR(50) NOT NULL   -- Название платёжной системы
);

INSERT INTO payment_system (payment_system_name)
VALUES
    ('VISA International Service Association'),
    ('Mastercard'),
    ('JCB'),
    ('American Express'),
    ('Diners Club International'),
    ('China UnionPay');
