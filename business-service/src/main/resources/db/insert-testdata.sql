insert into rowing_interval (repetitions, single_distance, rest_time)
values (4, 800, 120),
       (3, 2000, 240),
       (7, 500, 120);

insert into rowing_session (workout_date, strokes, distance, workout_time, rowing_interval_id, calories, rowing_mode)
values ('2024-01-02', 637, 7262, 1800000, null, 180, 'TIME'),
       ('2024-01-03', 638, 6834, 1800000, null, 156, 'TIME'),
       ('2024-01-05', 603, 7062, 1800000, null, 141, 'TIME'),
       ('2024-01-06', 630, 7134, 1800000, null, 140, 'TIME'),
       ('2024-01-08', 608, 7013, 1800000, null, 147, 'TIME'),
       ('2024-01-09', 615, 6964, 1800000, null, 145, 'TIME'),
       ('2024-01-10', 596, 6922, 1800000, null, 138, 'TIME'),
       ('2024-01-11', 619, 7106, 1800000, null, 147, 'TIME'),
       ('2024-01-12', 624, 7212, 1800000, null, 153, 'TIME'),
       ('2024-01-15', 620, 6896, 1800000, null, 147, 'TIME'),
       ('2024-01-16', 589, 6895, 1800000, null, 138, 'TIME'),
       ('2024-01-17', 615, 6922, 1800000, null, 144, 'TIME'),
       ('2024-01-18', 609, 6774, 1800000, null, 146, 'TIME'),
       ('2024-01-20', 603, 6750, 1800000, null, 145, 'TIME'),
       ('2024-01-21', 610, 6732, 1800000, null, 146, 'TIME'),
       ('2024-01-22', 576, 6354, 1800000, null, 129, 'TIME'),
       ('2024-01-23', 596, 6686, 1800000, null, 129, 'TIME'),
       ('2024-01-25', 591, 6730, 1800000, null, 133, 'TIME'),
       ('2024-01-26', 590, 6824, 1800000, null, 141, 'TIME'),
       ('2024-01-28', 604, 6734, 1800000, null, 143, 'TIME'),
       ('2024-01-29', 625, 6977, 1800000, null, 155, 'TIME'),
       ('2024-01-30', 612, 6818, 1800000, null, 146, 'TIME'),
       ('2024-02-01', 620, 6920, 1800000, null, 143, 'TIME'),
       ('2024-02-02', 647, 7331, 1800000, null, 153, 'TIME'),
       ('2024-02-04', 672, 7217, 1800000, null, 163, 'TIME'),
       ('2024-02-06', 635, 7000, 1765000, null, 150, 'TIME'),
       ('2024-02-07', 300, 3200, 615000,
        (SELECT id FROM rowing_interval WHERE repetitions = 4 and single_distance = 800 and rest_time = 120), 80,
        'INTERVAL'),
       ('2024-02-08', 642, 7000, 1741000, null, 154, 'DISTANCE'),
       ('2024-02-10', 455, 4975, 1200000, null, 112, 'TIME'),
       ('2024-02-12', 687, 7500, 1839000, null, 166, 'DISTANCE'),
       ('2024-02-13', 570, 6000, 1380000,
        (SELECT id FROM rowing_interval WHERE repetitions = 3 and single_distance = 2000 and rest_time = 240), 150,
        'INTERVAL'),
       ('2024-02-15', 670, 7500, 1782000, null, 163, 'DISTANCE'),
       ('2024-02-16', 454, 5000, 1165000, null, 111, 'DISTANCE'),
       ('2024-02-19', 704, 8000, 2048000, null, 168, 'DISTANCE'),
       ('2024-02-20', 310, 3500, 646000,
        (SELECT id FROM rowing_interval WHERE repetitions = 7 and single_distance = 500 and rest_time = 120), 95,
        'INTERVAL'),
       ('2024-02-22', 684, 8000, 1996000, null, 168, 'DISTANCE'),
       ('2024-02-23', 685, 8000, 1933000, null, 170, 'DISTANCE');