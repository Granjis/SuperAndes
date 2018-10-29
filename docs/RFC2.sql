
SELECT * 
FROM PROMOCION NATURAL JOIN  (SELECT COUNT (IdPromocion), IdPromocion as id
                             FROM VENTA
                             GROUP BY idPromocion
                             ORDER BY idPromocion ASC)
WHERE rownum <21    ;                        