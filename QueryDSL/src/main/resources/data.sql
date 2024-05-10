INSERT INTO User (name, email)
VALUES ('TestUser 1', 'testuser1@example.com'),
       ('TestUser 2', 'testuser2@example.com');


INSERT INTO Reservation (client_id, guide_id, name, reservated_at)
VALUES
    (1, 2, 'Reservation -1Y', DATETIME('now', '-1 years')),
    (1, 2, 'Reservation -72', DATETIME('now', '-3 days')),
    (1, 2, 'Reservation -48', DATETIME('now', '-2 days')),
    (1, 2, 'Reservation -20', DATETIME('now', '-20 hours')),
    (1, 2, 'Reservation -16', DATETIME('now', '-16 hours')),
    (1, 2, 'Reservation -12', DATETIME('now', '-12 hours')),
    (1, 2, 'Reservation -8', DATETIME('now', '-8 hours')),
    (1, 2, 'Reservation -4', DATETIME('now', '-4 hours')),
    (1, 2, 'Reservation now', CURRENT_TIMESTAMP),
    (1, 2, 'Reservation +4', DATETIME('now', '+4 hours')),
    (2, 1, 'Reservation +8', DATETIME('now', '+8 hours')),
    (2, 1, 'Reservation +12', DATETIME('now', '+12 hours')),
    (1, 2, 'Reservation +16', DATETIME('now', '+16 hours')),
    (1, 2, 'Reservation +20', DATETIME('now', '+20 hours')),
    (1, 2, 'Reservation +48', DATETIME('now', '+2 days')),
    (1, 2, 'Reservation +120', DATETIME('now', '+5 days'));

