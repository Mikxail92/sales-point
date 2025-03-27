--liquibase formatted sql
--changeset Mihail:010-create-transaction-table.sql
--preconditions onFail:CONTINUE onError:CONTINUE

CREATE TABLE IF NOT EXISTS transaction
(
    id                         BIGSERIAL PRIMARY KEY,                                                  -- Уникальный идентификатор транзакции
    transaction_date           DATE         NOT NULL,                                                  -- Дата транзакции
    sum                        DECIMAL      NOT NULL,                                                  -- Сумма транзакции
    transaction_type_id        BIGINT       NOT NULL,                                                  -- Ссылка на тип транзакции
    card_id                    BIGINT       NOT NULL,                                                  -- Ссылка на карту
    terminal_id                BIGINT       NOT NULL,                                                  -- Ссылка на терминал
    response_code_id           BIGINT       NOT NULL,                                                  -- Ссылка на код ответа
    authorization_code         VARCHAR(6)   NOT NULL,                                                  -- Код авторизации
    CONSTRAINT fk_transaction_type FOREIGN KEY (transaction_type_id) REFERENCES transaction_type (id), -- Внешний ключ на таблицу transaction_type
    CONSTRAINT fk_card FOREIGN KEY (card_id) REFERENCES card (id),                                     -- Внешний ключ на таблицу card
    CONSTRAINT fk_terminal FOREIGN KEY (terminal_id) REFERENCES terminal (id),                         -- Внешний ключ на таблицу terminal
    CONSTRAINT fk_response_code FOREIGN KEY (response_code_id) REFERENCES response_code (id)           -- Внешний ключ на таблицу response_code
);

INSERT INTO transaction (transaction_date, sum, transaction_type_id, card_id, terminal_id, response_code_id, authorization_code)
VALUES
    ('2022-10-22', 10.11,  1, 1, 1, 1, '342190'),
    ('2022-04-06', 50.92,   1, 1, 1, 1,'427471');
