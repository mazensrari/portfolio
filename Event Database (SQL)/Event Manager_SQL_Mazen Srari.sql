USE ev_tables;

CREATE TABLE delegates (
  id INTEGER PRIMARY KEY,
  firstname VARCHAR (40),
  surname VARCHAR (40),
  date_of_birth DATE NOT NULL,
  email TEXT NOT NULL,
  phone TEXT NOT NULL
);

CREATE TABLE events (
  id INTEGER PRIMARY KEY,
  title VARCHAR (40),
  description TEXT,
  start_time DATETIME NOT NULL,
  end_time DATETIME NOT NULL,
  quota INTEGER NOT NULL
);

CREATE TABLE bookings (
  delegate_id INTEGER NOT NULL,
  event_id INTEGER NOT NULL,
  active BOOLEAN NOT NULL,
  FOREIGN KEY (delegate_id) REFERENCES delegates (id),
  FOREIGN KEY (event_id) REFERENCES events (id),
  UNIQUE (delegate_id, event_id),
  CHECK (active IN (0, 1))
);

INSERT INTO delegates (id, firstname, surname, date_of_birth, email, phone)
VALUES
  (1, 'John', 'Hancock', '1995-01-01', 'johnancockh@example.com', '555-555-1212'),
  (2, 'Janet', 'Smith', '1990-02-15', 'janetsmith@example.com', '555-555-1313'),
  (3, 'Bob', 'Johnson', '1985-03-22', 'bobjohnson@example.com', '555-555-1414'),
  (4, 'Mike', 'Tyson', '1985-03-22', 'miketyson@example.com', '555-555-1515'),
  (5, 'Monty', 'Python', '1985-03-22', 'montypython@example.com', '555-555-1616'),
  (6, 'Joe', 'Biden', '1985-03-22', 'joebiden@example.com', '555-555-1717');

INSERT INTO events (id, title, description, start_time, end_time, quota)
VALUES
  (1, 'Event 1', 'This is the first event.', '2022-12-15 10:00:00', '2022-12-15 12:00:00', 10),
  (2, 'Event 2', 'This is the second event.', '2022-12-16 14:00:00', '2022-12-16 16:00:00', 20),
  (3, 'Event 3', 'This is the third event.', '2022-12-17 18:00:00', '2022-12-17 20:00:00', 30);

INSERT INTO bookings (delegate_id, event_id, active)
VALUES
  (1, 1, 1),
  (1, 2, 1),
  (1, 3, 0),
  (2, 1, 0),
  (2, 2, 1),
  (2, 3, 1),
  (3, 1, 1),
  (3, 2, 0),
  (3, 3, 1);

-- A list of delegates booked onto a particular event, ordered by surname;
SELECT d.surname
FROM delegates d
INNER JOIN bookings b ON d.id = b.delegate_id
WHERE b.event_id = event_id AND b.active = 1
ORDER BY d.surname ASC;

-- A list of cancellations for a particular event, ordered by date or time of
-- cancellation;

SELECT d.firstname, d.surname, b.active
FROM delegates d
INNER JOIN bookings b ON d.id = b.delegate_id
WHERE b.event_id = event_id AND b.active = 0
ORDER BY b.active ASC;

-- A list of all delegates in the system who have never made an event booking,
-- ordered by order of registering with the system;

SELECT d.firstname, d.surname
FROM delegates d
LEFT JOIN bookings b ON d.id = b.delegate_id
WHERE b.delegate_id IS NULL
ORDER BY d.id ASC;

-- The average number of booked delegates per event (considering live bookings
-- only.

SELECT AVG(booked_delegates)
FROM (
  SELECT COUNT(b.delegate_id) AS booked_delegates
  FROM bookings b
  WHERE b.active = 1
  GROUP BY b.event_id
  ORDER BY d.firstname ASC
);


-- The name of the person to have made the most recent live booking, on any
-- event.

SELECT d.firstname, d.surname
FROM delegates d
INNER JOIN bookings b ON d.id = b.delegate_id
WHERE b.active = 1
ORDER BY b.active ASC
LIMIT 1;

