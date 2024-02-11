-- Artist Table
INSERT INTO Artist (ArtistId, Name)
VALUES (1, 'The Beatles'),
       (2, 'Queen'),
       (3, 'Michael Jackson'),
       (4, 'Eminem'),
       (5, 'Coldplay'),
       (6, 'Adele'),
       (7, 'Beyoncé');

-- Genre Table
INSERT INTO Genre (GenreID, Name)
VALUES (1, 'Rock'),
       (2, 'Pop'),
       (3, 'Rap'),
       (4, 'R&B'),
       (5, 'Electronic'),
       (6, 'Country');

-- MediaType Table
INSERT INTO MediaType (MediaTypeID, Name)
VALUES (1, 'MP3'),
       (2, 'AAC'),
       (3, 'WAV'),
       (4, 'FLAC');

-- Playlist Table
INSERT INTO Playlist (PlaylistID, Name)
VALUES (1, 'Rock Classics'),
       (2, 'Pop Hits'),
       (3, 'Rap Vibes'),
       (4, 'Chillout Mix'),
       (5, 'Road Trip'),
       (6, 'Love Songs'),
       (7, 'Workout Jams'),
       (8, 'Best of 80s'),
       (9, 'Top 40 Hits'),
       (10, 'Country Faves');

-- Album Table
INSERT INTO Album (AlbumID, Title, ArtistId)
VALUES (1, 'Abbey Road', 1),
       (2, 'Greatest Hits', 2),
       (3, 'Thriller', 3),
       (4, 'The Marshall Mathers LP', 4),
       (5, 'A Head Full of Dreams', 5),
       (6, '21', 6),
       (7, 'Lemonade', 7);

-- Track Table
INSERT INTO Track (TrackID, Name, AlbumID, MediaTypeID, GenreID, Composer, Milliseconds, Bytes, UnitPrice)
VALUES (1, 'Come Together', 1, 1, 1, 'John Lennon', 215000, 5242880, 0.99),
       (2, 'Bohemian Rhapsody', 2, 2, 1, 'Freddie Mercury', 355000, 8388608, 1.29),
       (3, 'Billie Jean', 3, 1, 4, 'Michael Jackson', 294000, 7340032, 0.99),
       (4, 'Lose Yourself', 4, 1, 3, 'Eminem', 326000, 8126464, 1.19),
       (5, 'Viva la Vida', 5, 2, 2, 'Guy Berryman', 242000, 6291456, 0.99),
       (6, 'Rolling in the Deep', 6, 1, 2, 'Adele Adkins,', 228000, 5767168, 1.09),
       (7, 'Single Ladies (Put a Ring on It)', 7, 3, 4, 'Thaddis Harrell', 211000,
        5505024, 0.99),
       (8, 'Hey Jude', 1, 1, 1, 'John Lennon', 431000, 10485760, 1.49),
       (9, 'We Will Rock You', 2, 1, 1, 'Brian May', 130000, 3145728, 0.79),
       (10, 'Thriller', 3, 2, 4, 'Rod Temperton', 358000, 8912896, 1.29),
       (11, 'Stan', 4, 1, 3, 'Eminem', 387000, 9633792, 1.39),
       (12, 'Fix You', 5, 2, 1, 'Jonny Buckland', 295000, 7340032, 0.99),
       (13, 'Someone Like You', 6, 1, 2, 'Adele Adkins', 285000, 7077888, 1.09),
       (14, 'Formation', 7, 3, 4, 'Michael L. Williams II',
        233000, 5767168, 0.99),
       (15, 'Twist and Shout', 1, 1, 1, 'Phil Medley', 165000, 4194304, 0.89),
       (16, 'Don''t Stop Me Now', 2, 1, 1, 'Freddie Mercury', 190000, 4718592, 0.99),
       (17, 'Beat It', 3, 1, 3, 'Michael Jackson', 258000, 6422528, 1.09),
       (18, 'The Real Slim Shady', 4, 1, 3, 'Eminem', 284000, 7077888, 1.19),
       (19, 'Paradise', 5, 2, 2, 'Guy Berryman, Jonny Buckland', 282000, 7077888, 1.09),
       (20, 'Set Fire to the Rain', 6, 1, 2, 'Adele Adkins', 242000, 6021120, 1.09),
       (21, 'Halo', 7, 3, 4, 'Beyoncé, Evan Bogart', 235000, 6021120, 1.09),
       (22, 'Help!', 1, 1, 1, 'John Lennon', 138000, 3538944, 0.79),
       (23, 'Under Pressure', 2, 1, 1, 'Roger Taylor', 244000,
        6021120, 1.09),
       (24, 'Smooth Criminal', 3, 2, 4, 'Michael Jackson', 258000, 6488064, 1.19),
       (25, 'Not Afraid', 4, 1, 3, 'Eminem', 263000, 6553600, 1.19),
       (26, 'Adventure of a Lifetime', 5, 2, 2, 'Guy Berryman', 259000,
        6553600, 1.19),
       (27, 'Skyfall', 6, 1, 2, 'Adele Adkins', 293000, 7340032, 1.29),
       (28, 'Crazy in Love', 7, 3, 4, 'Beyoncé, Rich Harrison', 235000, 6021120, 1.09),
       (29, 'All You Need Is Love', 1, 1, 1, 'John Lennon', 230000, 5767168, 1.09),
       (30, 'Another One Bites the Dust', 2, 1, 1, 'John Deacon', 216000, 5373952, 0.99),
       (31, 'Black or White', 3, 2, 4, 'Michael Jackson', 229000, 5767168, 1.09),
       (32, 'Mockingbird', 4, 1, 3, 'Eminem', 251000, 6246400, 1.09),
       (33, 'Fix You', 5, 2, 1, 'Guy Berryman', 295000, 7340032, 1.19),
       (34, 'Chasing Pavements', 6, 1, 2, 'Adele Adkins', 232000, 5767168, 1.09),
       (35, 'Irreplaceable', 7, 3, 4, 'Ne-Yo', 229000, 5767168, 1.09);

-- PlaylistTrack Table
INSERT INTO PlaylistTrack (PlaylistId, TrackId)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (3, 6),
       (4, 7),
       (5, 8),
       (6, 9),
       (7, 10),
       (8, 11),
       (9, 12),
       (10, 13),
       (1, 14),
       (2, 15),
       (3, 16),
       (4, 17),
       (5, 18),
       (6, 19),
       (7, 20),
       (8, 21),
       (9, 22),
       (10, 23),
       (1, 24),
       (2, 25),
       (3, 26),
       (4, 27),
       (5, 28),
       (6, 29),
       (7, 30),
       (8, 31),
       (9, 32),
       (10, 33),
       (1, 34),
       (2, 35);
