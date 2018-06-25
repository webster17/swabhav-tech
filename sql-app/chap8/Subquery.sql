SELECT *
    FROM   Room
    WHERE  capacity <
      (SELECT AVG(capacity)
       FROM   Room)
