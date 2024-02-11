CREATE TABLE Artist
(
    ArtistId int4 PRIMARY KEY,
    Name     varchar(64) NOT NULL
);
CREATE TABLE Genre
(
    GenreID int4 PRIMARY KEY,
    Name    varchar(64) NOT NULL
);
CREATE TABLE MediaType
(
    MediaTypeID int4 PRIMARY KEY,
    Name        varchar(64) NOT NULL
);
CREATE TABLE Playlist
(
    PlaylistID int4 PRIMARY KEY,
    Name       varchar(64) NOT NULL
);
CREATE TABLE Album
(
    AlbumID  int4 PRIMARY KEY,
    Title    varchar(64) NOT NULL,
    ArtistId int4 REFERENCES artist (artistid)
);
CREATE TABLE Track
(
    TrackID      int4 PRIMARY KEY,
    Name         varchar(64) NOT NULL,
    AlbumID      int4 REFERENCES album (albumid),
    MediaTypeID  int4 REFERENCES mediatype (mediatypeid),
    GenreID      int4 REFERENCES genre (genreid),
    Composer     varchar(64),
    Milliseconds int8,
    Bytes        int4,
    UnitPrice    int4
);
CREATE TABLE PlaylistTrack
(
    PlaylistId int4 REFERENCES playlist (playlistid),
    TrackId    int4 REFERENCES track (trackid)
)
