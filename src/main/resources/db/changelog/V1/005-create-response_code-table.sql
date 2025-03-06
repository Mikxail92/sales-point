--liquibase formatted sql
--changeset Murad:005-create-response_code-table.sql
--preconditions onFail:CONTINUE onError:CONTINUE

CREATE TABLE IF NOT EXISTS response_code
(
    id                BIGSERIAL PRIMARY KEY, -- Уникальный идентификатор кода ответа
    error_code        VARCHAR(2)   NOT NULL, -- Код ошибки
    error_description VARCHAR(255) NOT NULL, -- Описание ошибки
    error_level       VARCHAR(255) NOT NULL  -- Уровень ошибки
);

INSERT INTO response_code (error_code, error_description, error_level)
VALUES
    ('00', 'одобрено и завершено', 'Все в порядке'),
    ('01', 'авторизация отклонена, обратиться в банк-эмитент', 'не критическая'),
    ('03', 'незарегистрированная торговая точка или агрегатор платежей', 'не критическая'),
    ('05', 'авторизация отклонена, оплату не проводить', 'критическая'),
    ('41', 'карта утеряна, изъять', 'критическая'),
    ('51', 'недостаточно средств на счёте', 'сервисная или аппаратная ошибка'),
    ('55', 'неправильный PIN', 'не критическая');
