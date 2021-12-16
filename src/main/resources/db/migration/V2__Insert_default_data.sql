INSERT INTO "users" (id, username, password, email, is_enabled)
    VALUES (1, 'admin', '$2b$10$jkzR/NI9PCgA3UXhx5T6WOqPJkzhTGAJY/5Z0txIfRt57ThjqfSOe', 'admin@admin', TRUE);

INSERT INTO "users" (id, username, password, email, is_enabled)
    VALUES (2, 'user', '$2a$10$heFHG7Dn8BTVy/E4cjpBGufQ4cABThxMoN/gdhOondb5lXXRF.Zgi', 'user@user', TRUE);

INSERT INTO "user_role" (id, user_id, role) VALUES (1, 1, 'CREATE');
INSERT INTO "user_role" (id, user_id, role) VALUES (2, 1, 'READ');
INSERT INTO "user_role" (id, user_id, role) VALUES (3, 1, 'UPDATE');
INSERT INTO "user_role" (id, user_id, role) VALUES (4, 1, 'DELETE');

INSERT INTO "user_role" (id, user_id, role) VALUES (5, 2, 'READ');
