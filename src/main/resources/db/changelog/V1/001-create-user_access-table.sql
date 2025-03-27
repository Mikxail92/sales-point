--liquibase formatted sql
--changeset Mihail:001-create-user_access-table.sql
--preconditions onFail:CONTINUE onError:CONTINUE

CREATE TABLE IF NOT EXISTS user_access
(
    id            BIGSERIAL PRIMARY KEY, -- Уникальный идентификатор пользователя
    user_login    VARCHAR(255) NOT NULL, -- Логин пользователя
    user_password VARCHAR(255) NOT NULL, -- Хэшированный пароль пользователя
    full_name     VARCHAR(255) NOT NULL, -- Полное имя пользователя
    user_role     VARCHAR(255) NOT NULL  -- Роль пользователя (например, "Администратор", "Кассир")
    );

INSERT INTO user_access (user_login, user_password, full_name, user_role)
VALUES
    ('admin', '111', 'Adminov Admin', 'ROLE_ADMIN'),
    ('manager', '***', 'Managerov Manager', 'ROLE_MANAGER'),
    ('user', '111', 'Userov User', 'ROLE_USER');
