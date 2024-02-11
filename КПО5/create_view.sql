CREATE VIEW TrackInfo AS
SELECT
    t.TrackID,
    t.Name AS track_name,
    art.Name AS artist,
    g.Name AS genre,
    alb.Title AS album
FROM
    Track t
JOIN Album alb ON t.AlbumID = alb.AlbumID
JOIN Genre g ON t.GenreID = g.GenreID
JOIN Artist art ON art.artistid = alb.ArtistID
