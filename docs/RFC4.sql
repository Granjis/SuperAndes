SELECT * 
FROM (((PRODUCTO NATURAL JOIN VENTA) NATURAL JOIN PEDIDO_)
      FULL OUTER JOIN ALMACENAMIENTO on idProducto  = productoCodigoBarras);
              
              