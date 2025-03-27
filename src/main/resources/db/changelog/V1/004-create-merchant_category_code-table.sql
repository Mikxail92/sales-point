--liquibase formatted sql
--changeset Mihail:004-create-merchant_category_code-table.sql
--preconditions onFail:CONTINUE onError:CONTINUE

CREATE TABLE IF NOT EXISTS merchant_category_code
(
    id       BIGSERIAL PRIMARY KEY, -- Уникальный идентификатор категории
    mcc      VARCHAR(4)   NOT NULL, -- Код категории торговца (MCC)
    mcc_name VARCHAR(255) NOT NULL  -- Название категории
);

INSERT INTO merchant_category_code (mcc, mcc_name)
VALUES
    ('5309', 'Беспошлинные магазины Duty Free'),
    ('5651', 'Одежда для всей семьи'),
    ('5691', 'Магазины мужской и женской одежды'),
    ('5812', 'Места общественного питания, рестораны'),
    ('5814', 'Фастфуд');
