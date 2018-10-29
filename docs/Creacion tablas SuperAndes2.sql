			/**CREACION TABLA CATEGORIA PRODUCTO*/
CREATE TABLE CategoriaProducto(
idProd int,
idCategoria int,
CONSTRAINT PKCategoriaProducto PRIMARY KEY (idProd,idCategoria),
CONSTRAINT FKCategoriaProd  FOREIGN KEY (idCategoria) REFERENCES categoria(id) ,
CONSTRAINT FKProdCategoria  FOREIGN KEY (idProd) REFERENCES producto(codigoBarras)
);

			/**CREACION TABLA Cliente Sucursal*/
CREATE TABLE ClienteSucursal(
idCliente int,
idSucursal int,
CONSTRAINT PKClienteSucursal PRIMARY KEY (idCliente,idSucursal),
CONSTRAINT FKClienteSucursal  FOREIGN KEY (idCliente) REFERENCES cliente(id) ,
CONSTRAINT FKSucursalCliente  FOREIGN KEY (idSucursal) REFERENCES sucursal(id)
);

			/**CREACION TABLA Proveedor Sucursal*/
CREATE TABLE ProveedorSucursal(
idProveedor int,
idSucursal int,
CONSTRAINT PKProveedorSucursal PRIMARY KEY (idProveedor,idSucursal),
CONSTRAINT FKProveedorSucursal  FOREIGN KEY (idProveedor) REFERENCES proveedor(id) ,
CONSTRAINT FKSucursalProveedor  FOREIGN KEY (idSucursal) REFERENCES sucursal(id)
);


			/**CREACION TABLA Almacenamiento */
CREATE TABLE Almacenamiento(
idSucursal int,
tipo int NOT NULL, 
volumen int NOT NULL,
peso int NOT NULL,
nivelAbastecimiento int NOT NULL,
unidadesDisponibles int NOT NULL,
idCategoria int NOT NULL,
productoCodigoBarras int NOT NULL,
CONSTRAINT PKAlmacenamiento PRIMARY KEY (idSucursal, productoCodigoBarras),
CONSTRAINT FKCategoriaAbastecimiento  FOREIGN KEY (idCategoria) REFERENCES categoria(id) ,
CONSTRAINT FKSucursalAlmacenamiento  FOREIGN KEY (idSucursal) REFERENCES sucursal(id),
CONSTRAINT FKProducto FOREIGN KEY (productoCodigoBarras) REFERENCES producto(codigoBarras),
CONSTRAINT CKnivelAbastecimiento CHECK(nivelAbastecimiento>0),
CONSTRAINT CKunidadesDisponibles CHECK(unidadesDisponibles>0)
);

			/**CREACION TABLA Pedido */
CREATE TABLE Pedido(
id int,
idSucursal int,
idProveedor int,
idProducto int, 
cantidad int NOT NULL,
completo char, 
costo int NOT NULL,
fechaEntrega DATE NOT NULL,
calificacionCalidad int NOT NULL,
presentacion varchar(32),
CONSTRAINT PKPedido PRIMARY KEY (id,idSucursal,idProveedor,idProducto),
CONSTRAINT FKproveedorPedido  FOREIGN KEY (idProveedor) REFERENCES proveedor(id) ,
CONSTRAINT FKSucursalPedido  FOREIGN KEY (idSucursal) REFERENCES sucursal(id),
CONSTRAINT FKProdcutoPedido  FOREIGN KEY (idProducto) REFERENCES producto(codigoBarras),
CONSTRAINT CKCostoPedido CHECK(costo>0),
CONSTRAINT CKCompleto CHECK(completo='Y'OR completo='N'),
CONSTRAINT CKucalificacionCalidadPedido CHECK(calificacionCalidad>0)
);

			/**CREACION TABLA Factura */
CREATE TABLE Factura(
id int,
idCliente int, 
nombre varchar(32) NOT NULL,
correo varchar(32) NOT NULL UNIQUE,
puntos int NOT NULL,
CONSTRAINT PKFactura PRIMARY KEY (id),
CONSTRAINT FKClienteFactura  FOREIGN KEY (idCliente) REFERENCES cliente(id) ,
CONSTRAINT CKpuntosFactura CHECK(puntos>0)
);



			/**CREACION TABLA Venta */
CREATE TABLE Venta(
id int,
idSucursal int,
idFactura int,
idProducto int, 
idPromocion int NOT NULL,
valor int NOT NULL,
puntos int NOT NULL,
CONSTRAINT PKVenta PRIMARY KEY (id,idSucursal,idFactura,idProducto),
CONSTRAINT FKVentaSucursal FOREIGN KEY (idSucursal) REFERENCES sucursal(id) ,
CONSTRAINT FKVentaFactura FOREIGN KEY (idFactura) REFERENCES factura(id),
CONSTRAINT FKProdcutoVenta  FOREIGN KEY (idProducto) REFERENCES producto(codigoBarras),
CONSTRAINT CKvalorVenta  CHECK(valor>0),
CONSTRAINT CKPuntosVenta CHECK(puntos>0)
);

			/**CREACION TABLA Promocion */
CREATE TABLE Promocion(
id int,
idSucursal int,
tipo int NOT NULL,
descripcion varchar(32) NOT NULL, 
cantidadProductos int,
productoCodigoBarras int,
fechaExpiracion DATE NOT NULL,
CONSTRAINT PKPromocion PRIMARY KEY (id),
CONSTRAINT FKPromocionSucursal FOREIGN KEY (idSucursal) REFERENCES sucursal(id),
CONSTRAINT FKProductoPromo  FOREIGN KEY (productoCodigoBarras) REFERENCES producto(codigoBarras)
);


