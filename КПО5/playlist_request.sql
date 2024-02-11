SELECT p.name AS playlist_name FROM playlisttrack
JOIN public.playlist p ON playlisttrack.playlistid = p.playlistid
JOIN public.track t ON playlisttrack.trackid = t.trackid
JOIN public.genre g ON t.genreid = g.genreid
WHERE g.name = 'Rock' OR g.name = 'Rap'
GROUP BY p.playlistid, g.genreid
HAVING COUNT(*) > 2
