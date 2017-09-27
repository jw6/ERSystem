--One statement that join all tables
SELECT cus.FIRSTNAME || ' ' || cus.LASTNAME AS "Customer", al.TITLE AS "ALBUM", pl.NAME AS "Playlist", 
tra.NAME AS "Song", me.NAME AS "Mediatype",ge.NAME AS "Genre", art.NAME AS "Artist", 
emp.FIRSTNAME || ' ' || emp.LASTNAME AS "Employee"
FROM CUSTOMER cus
FULL JOIN INVOICE     inv       ON cus.CUSTOMERID   = inv.CUSTOMERID
FULL JOIN INVOICELINE invline   ON inv.INVOICEID    = invline.INVOICEID
FULL JOIN TRACK       tra       ON invline.TRACKID  = tra.TRACKID
FULL JOIN ALBUM       al        ON tra.ALBUMID      = al.ALBUMID
FULL JOIN ARTIST      art       ON al.ARTISTID      = art.ARTISTID
FULL JOIN PLAYLISTTRACK plt     ON tra.TRACKID      = plt.TRACKID
FULL JOIN MEDIATYPE   me        ON tra.MEDIATYPEID  = me.MEDIATYPEID
FULL JOIN GENRE       ge        ON tra.GENREID      = ge.GENREID
FULL JOIN EMPLOYEE    emp       ON cus.SUPPORTREPID = emp.REPORTSTO
FULL JOIN PLAYLIST    pl        ON pl.PLAYLISTID    = plt.PLAYLISTID;
/
