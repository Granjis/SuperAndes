SELECT IdSucursal,tipo, AVG(nivelAbastecimiento)as nivelAbastecimiento
FROM ALMACENAMIENTO
GROUP BY idSucursal, tipo;