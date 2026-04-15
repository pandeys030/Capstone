CREATE DATABASE Instagram;
USE Instagram;

CREATE TABLE Users(
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR (50) UNIQUE NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(100),
  bio TEXT,
  created_at TIMESTAMP DEFAULT current_timestamp
)

CREATE TABLE Posts(
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  caption TEXT,
  media_url VARCHAR(225),
  created_at TIMESTAMP DEFAULT current_timestamp,
  FOREIGN KEY (user_id) REFERENCES Users(id)
)

CREATE TABLE Likes(
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  post_id INT,
  created_at TIMESTAMP DEFAULT current_timestamp,
  UNIQUE(user_id, post_id),
  FOREIGN KEY (user_id) REFERENCES Users(id),
  FOREIGN KEY (post_id) REFERENCES Posts(id)
)

CREATE TABLE Comments(
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  post_id INT,
  text TEXT,
  created_at TIMESTAMP DEFAULT current_timestamp,
  FOREIGN KEY (user_id) REFERENCES Users(id),
  FOREIGN KEY (post_id) REFERENCES Posts(id)
)

CREATE TABLE follows (
  follower_id INT,
  following_id INT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (follower_id, following_id),
  FOREIGN KEY (follower_id) REFERENCES Users(id),
  FOREIGN KEY (following_id) REFERENCES Users(id)
);

INSERT INTO users (username, email, password, bio) VALUES
('alice', 'alice@example.com', '$2b$10$hashalice', 'Love photography and travel'),
('bob', 'bob@example.com', '$2b$10$hashbob', 'Full-stack developer'),
('charlie', 'charlie@example.com', '$2b$10$hashcharlie', 'Coffee enthusiast ☕'),
('david', 'david@example.com', '$2b$10$hashdavid', 'Fitness and health'),
('emma', 'emma@example.com', '$2b$10$hashemma', 'UI/UX designer'),
('frank', 'frank@example.com', '$2b$10$hashfrank', 'Backend engineer'),
('grace', 'grace@example.com', '$2b$10$hashgrace', 'AI/ML student'),
('harry', 'harry@example.com', '$2b$10$hashharry', 'Blockchain developer'),
('irene', 'irene@example.com', '$2b$10$hashirene', 'Content creator'),
('jack', 'jack@example.com', '$2b$10$hashjack', 'Gamer and streamer');

INSERT INTO posts (user_id, caption, media_url) VALUES
(1, 'Sunset at the beach 🌅', 'https://img.com/post1.jpg'),
(2, 'Debugging life one bug at a time', 'https://img.com/post2.jpg'),
(3, 'Morning coffee is mandatory', 'https://img.com/post3.jpg'),
(4, 'Leg day done right 💪', 'https://img.com/post4.jpg'),
(5, 'Minimal UI, maximum impact', 'https://img.com/post5.jpg'),
(6, 'Scaling backend systems', 'https://img.com/post6.jpg'),
(7, 'Training my ML model today', 'https://img.com/post7.jpg'),
(8, 'Smart contracts are the future', 'https://img.com/post8.jpg'),
(9, 'Editing my next video', 'https://img.com/post9.jpg'),
(10, 'Late night gaming session 🎮', 'https://img.com/post10.jpg'),

(1, 'Exploring new cities', 'https://img.com/post11.jpg'),
(2, 'Docker + Kubernetes setup', 'https://img.com/post12.jpg'),
(3, 'Cold brew > hot coffee', 'https://img.com/post13.jpg'),
(4, 'Consistency beats motivation', 'https://img.com/post14.jpg'),
(5, 'Design systems matter', 'https://img.com/post15.jpg'),
(6, 'API latency optimizations', 'https://img.com/post16.jpg'),
(7, 'Deep learning experiments', 'https://img.com/post17.jpg'),
(8, 'DeFi insights', 'https://img.com/post18.jpg'),
(9, 'Filming setup upgrade', 'https://img.com/post19.jpg'),
(10, 'Rank push tonight', 'https://img.com/post20.jpg'),

(3, 'Reading while sipping coffee', 'https://img.com/post21.jpg'),
(7, 'Model accuracy improved!', 'https://img.com/post22.jpg'),
(2, 'CI/CD pipeline deployed', 'https://img.com/post23.jpg'),
(5, 'Color palettes exploration', 'https://img.com/post24.jpg'),
(1, 'Mountains over everything ⛰️', 'https://img.com/post25.jpg');

INSERT INTO follows (follower_id, following_id) VALUES
(1,2),(1,3),(1,4),
(2,1),(2,3),(2,5),
(3,1),(3,6),(3,7),
(4,1),(4,2),(4,8),
(5,2),(5,3),(5,9),
(6,1),(6,7),(6,10),
(7,3),(7,8),(7,9),
(8,4),(8,10),
(9,5),(9,6),
(10,1),(10,2);

INSERT INTO likes (user_id, post_id) VALUES
-- Post 1 (popular)
(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),

-- Post 2
(1,2),(3,2),(5,2),(7,2),

-- Post 3
(1,3),(2,3),(4,3),

-- Post 4
(2,4),(3,4),(6,4),(8,4),

-- Post 5
(1,5),(2,5),(3,5),(4,5),(5,5),

-- Post 6
(7,6),(8,6),(9,6),

-- Post 7 (viral)
(1,7),(2,7),(3,7),(4,7),(5,7),(6,7),(8,7),(9,7),

-- Post 8
(2,8),(5,8),(7,8),

-- Post 9
(1,9),(3,9),(6,9),

-- Post 10
(4,10),(5,10),(6,10),(7,10),

-- Random spread
(8,11),(9,12),(10,13),(1,14),(2,15),
(3,16),(4,17),(5,18),(6,19),(7,20);

INSERT INTO comments (user_id, post_id, text) VALUES
(2,1,'Amazing shot!'),
(3,1,'Where is this place?'),
(4,1,'Looks शांत 🔥'),

(1,2,'Relatable 😂'),
(5,2,'Debugging never ends'),

(6,3,'Same here, coffee is life'),
(7,3,'Can’t start my day without it'),

(3,4,'Solid work 💪'),
(8,4,'Keep pushing!'),

(2,5,'Clean design!'),
(4,5,'Love the minimalism'),

(1,7,'Great progress'),
(5,7,'What dataset are you using?'),
(6,7,'Accuracy kitna hai now?'),

(7,8,'Interesting take'),
(9,8,'Explain more pls'),

(3,9,'Nice setup'),
(2,9,'Camera details?'),

(10,10,'Let’s play sometime'),
(1,10,'GG 🔥'),

(4,11,'Travel goals'),
(5,12,'DevOps grind 💻'),
(6,13,'Coffee supremacy'),

(7,14,'Consistency wins'),
(8,15,'Design is clean');