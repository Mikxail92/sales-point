--liquibase formatted sql
--changeset Murad:003-create-acquiring_bank-table.sql
--preconditions onFail:CONTINUE onError:CONTINUE

CREATE TABLE IF NOT EXISTS acquiring_bank
(
    id               BIGSERIAL PRIMARY KEY, -- Уникальный идентификатор эквайера
    bic              VARCHAR(9)   NOT NULL, -- Банковский идентификатор эквайера
    abbreviated_name VARCHAR(255) NOT NULL  -- Сокращённое название банка
);

INSERT INTO acquiring_bank (bic, abbreviated_name)
VALUES
    ('041234567', 'ПАО Банк-эквайер №1'),
    ('041234568', 'ПАО Банк-эквайер №2'),
    ('041234569', 'ПАО Банк-эквайер №3');
