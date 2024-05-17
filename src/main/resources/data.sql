-- Insert data into the Geography table
INSERT INTO Geography (id, country, city) VALUES ('1e7c6f8a-8f6e-4f8a-b8f6-1e7c6f8a8f6e', 'USA', 'New York');
INSERT INTO Geography (id, country, city) VALUES ('2d6b5e1c-4d2a-4b5e-8c1c-2d6b5e1c4d2a', 'USA', 'Los Angeles');
INSERT INTO Geography (id, country, city) VALUES ('3c5a4d9b-2c3a-4d9b-8a3b-3c5a4d9b2c3a', 'Canada', 'Toronto');
INSERT INTO Geography (id, country, city) VALUES ('4b3c2d1a-0b1c-4d1a-8a1a-4b3c2d1a0b1c', 'UK', 'London');

-- Insert data into the Gamer table
INSERT INTO Gamer (id, name, email, geography_id) VALUES ('5a1b2c3d-4e5f-6a7b-8c9d-0e1f2a3b4c5d', 'John Doe', 'john@example.com', '1e7c6f8a-8f6e-4f8a-b8f6-1e7c6f8a8f6e');
INSERT INTO Gamer (id, name, email, geography_id) VALUES ('6b1c2d3e-4f5a-6b7c-8d9e-0f1a2b3c4d5e', 'Jane Smith', 'jane@example.com', '2d6b5e1c-4d2a-4b5e-8c1c-2d6b5e1c4d2a');
INSERT INTO Gamer (id, name, email, geography_id) VALUES ('7c1d2e3f-4a5b-6c7d-8e9f-0a1b2c3d4e5f', 'Mike Johnson', 'mike@example.com', '3c5a4d9b-2c3a-4d9b-8a3b-3c5a4d9b2c3a');
INSERT INTO Gamer (id, name, email, geography_id) VALUES ('8d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a', 'Emily Brown', 'emily@example.com', '4b3c2d1a-0b1c-4d1a-8a1a-4b3c2d1a0b1c');

-- Insert data into the Game table
INSERT INTO Game (id, name, description, geography_id) VALUES ('9e1f2a3b-4c5d-6e7f-8a9b-0c1d2e3f4a5b', 'Minecraft', 'A sandbox video game', '1e7c6f8a-8f6e-4f8a-b8f6-1e7c6f8a8f6e');
INSERT INTO Game (id, name, description, geography_id) VALUES ('0f1a2b3c-4d5e-6f7a-8b9c-0d1e2f3a4b5c', 'Fortnite', 'A battle royale game', '2d6b5e1c-4d2a-4b5e-8c1c-2d6b5e1c4d2a');

-- Insert data into the GamerGame table
INSERT INTO Gamer_Game (id, gamer_id, game_id, level) VALUES ('2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e', '5a1b2c3d-4e5f-6a7b-8c9d-0e1f2a3b4c5d', '9e1f2a3b-4c5d-6e7f-8a9b-0c1d2e3f4a5b', 'PRO');
INSERT INTO Gamer_Game (id, gamer_id, game_id, level) VALUES ('3c4d5e6f-7a8b-9c0d-1e2f-3a4b5c6d7e8f', '5a1b2c3d-4e5f-6a7b-8c9d-0e1f2a3b4c5d', '9e1f2a3b-4c5d-6e7f-8a9b-0c1d2e3f4a5b', 'N00B');

COMMIT;