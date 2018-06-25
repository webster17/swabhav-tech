CREATE TABLE StudentA
 (ssn         CHAR(9),
  class       INT
    CONSTRAINT class_ck CHECK (class BETWEEN 1 AND 4),
  name         VARCHAR(20))

