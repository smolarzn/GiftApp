INSERT INTO app_user (id, version, user_name, password, email) VALUES (1, 0, 'Jan Kowalski', 'kowalski', 'kowalski@gmail.com');
INSERT INTO app_user (id, version, user_name, password, email) VALUES (2, 0, 'Julia Kot', 'kot', 'kot@gmail.com');
INSERT INTO app_user (id, version, user_name, password, email) VALUES (3, 0, 'Andrzej Nowak', 'nowak', 'nowak@gmail.com');
INSERT INTO app_user (id, version, user_name, password, email) VALUES (4, 0, 'Nina Perypeczko', 'perypeczko', 'perypeczko@gmail.com');
INSERT INTO app_user (id, version, user_name, password, email) VALUES (5, 0, 'Anastazja Turek', 'turek', 'turek@gmail.com');
INSERT INTO app_user (id, version, user_name, password, email) VALUES (6, 0, 'Norbert Sobota', 'sobota', 'sobota@gmail.com');

INSERT INTO happening (id, version, topic, description, happening_day) VALUES (1, 0, 'klasowe mikołajki', null, '2021-12-10');

INSERT INTO happening_to_participant (happening_id, participant_id) VALUES (1 ,1);
INSERT INTO happening_to_participant (happening_id, participant_id) VALUES (1 ,2);
INSERT INTO happening_to_participant (happening_id, participant_id) VALUES (1 ,3);
INSERT INTO happening_to_participant (happening_id, participant_id) VALUES (1 ,4);
INSERT INTO happening_to_participant (happening_id, participant_id) VALUES (1 ,5);
INSERT INTO happening_to_participant (happening_id, participant_id) VALUES (1 ,6);

INSERT INTO gift (id, version, from_who_id, to_who_id, happening_id) VALUES (1, 0, 1, 2, 1);
INSERT INTO gift (id, version, from_who_id, to_who_id, happening_id) VALUES (2, 0, 2, 3, 1);
INSERT INTO gift (id, version, from_who_id, to_who_id, happening_id) VALUES (3, 0, 3, 4, 1);
INSERT INTO gift (id, version, from_who_id, to_who_id, happening_id) VALUES (4, 0, 4, 5, 1);
INSERT INTO gift (id, version, from_who_id, to_who_id, happening_id) VALUES (5, 0, 5, 6, 1);
INSERT INTO gift (id, version, from_who_id, to_who_id, happening_id) VALUES (6, 0, 6, 1, 1);

INSERT INTO role (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (2, 'ROLE_ADMIN');

