
--populate WORKER
INSERT INTO WORKER (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES ('Nikita', '1989-04-05', 'Middle', 4000),
('Mephisto', '1909-01-01', 'Junior', 1500),
('Lucifer', '1908-04-08', 'Junior', 1600),
('Uriel', '1907-12-24', 'Middle', 5000),
('Belial', '1906-03-15', 'Junior', 1200),
('Cain', '1950-09-10', 'Junior', 1002),
('Belzebub', '1924-10-01', 'Middle', 3800),
('Adolf', '1909-08-01', 'Junior', 1000),
('Bob', '2001-11-28', 'Trainee', 1150),
('Michael', '1901-01-01', 'Senior', 10000);


--populate CLIENT
INSERT INTO client (NAME)
VALUES ('Andrew'),
('Alex'),
('Victoria'),
('Vladimir'),
('Mark');


--populate project
INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (1, '2015-12-03', '2023-07-03'),
(2, '2017-10-03', '2026-04-03'),
(3, '2018-05-03', '2027-01-03'),
(4, '2018-09-03', '2025-11-03'),
(5, '2015-12-03', '2020-11-03'),
(1, '2019-04-03', '2027-04-03'),
(2, '2016-07-03', '2023-11-03'),
(3, '2018-12-03', '2025-10-03'),
(4, '2017-05-03', '2022-09-03'),
(5, '2016-02-03', '2023-02-03');


--populate project_worker
INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (1,5),
(1,10),
(2,7),
(3,9),
(4,4),
(5,10),
(6,9),
(7,2),
(8,1),
(9,8),
(10,6);


