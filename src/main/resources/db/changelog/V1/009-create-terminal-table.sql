--liquibase formatted sql
--changeset Mihail:009-create-terminal-table.sql
--preconditions onFail:CONTINUE onError:CONTINUE

CREATE TABLE IF NOT EXISTS terminal
(
    id          BIGSERIAL PRIMARY KEY,                                             -- Уникальный идентификатор терминала
    terminal_id VARCHAR(9) NOT NULL,                                               -- Идентификатор терминала
    mcc_id      BIGINT    NOT NULL,                                               -- Ссылка на MCC (категорию)
    pos_id      BIGINT     NOT NULL,                                               -- Ссылка на точку продаж
    CONSTRAINT fk_mcc FOREIGN KEY (mcc_id) REFERENCES merchant_category_code (id), -- Внешний ключ на таблицу merchant_category_code
    CONSTRAINT fk_pos FOREIGN KEY (pos_id) REFERENCES sales_point (id)             -- Внешний ключ на таблицу sales_point
);

INSERT INTO terminal (terminal_id, mcc_id, pos_id)
VALUES
    ('000000001', 1, 1),
    ('000000002', 2, 2),
    ('000000003', 3, 2);
