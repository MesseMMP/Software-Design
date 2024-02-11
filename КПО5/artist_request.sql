SELECT art.name, COUNT(*) AS tracks FROM track
JOIN public.album alb ON track.albumid = alb.albumid
JOIN public.artist art ON art.artistid = alb.artistid
GROUP BY art.artistid
ORDER BY tracks DESC
LIMIT 3
