-- id, phrase
INSERT INTO syllabus VALUES (1, 'Everest');
INSERT INTO syllabus VALUES (2, 'Romania');
INSERT INTO syllabus VALUES (3, 'London');
INSERT INTO syllabus VALUES (4, 'Berlin');
INSERT INTO syllabus VALUES (5, 'Croatia');

-- id , gameStatus,  maxAttempts, syllabus_id, user_id
INSERT INTO game VALUES (1, 'NEW', 5, 3, 1);

-- id, isGuessed, letter, game_id
INSERT INTO attempt VALUES (1, TRUE, 'L', 1);
INSERT INTO attempt VALUES (2, FALSE, 'G', 1);
INSERT INTO attempt VALUES (3, TRUE, 'O', 1);

--id, email, name, pass
INSERT INTO user VALUES (1, 'dan@gmail.com','Dan', 'dan');
INSERT INTO user VALUES (2, 'mark@yahoo.com', 'Mark', 'mark');
INSERT INTO user VALUES (3, 'zoe@gmail.com', 'Zoe', 'zoe');


