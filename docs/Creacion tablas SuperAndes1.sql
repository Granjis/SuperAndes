				/**CREACION PROVEEDOR:**/

CREATE TABLE Proveedor(
id int,
nombre varchar(32)  NOT NULL,
tipoProd varchar(32)  NOT NULL,
CONSTRAINT PKProveedor PRIMARY KEY (id)
);
		
				/**CREACION CLIENTE :**/

CREATE TABLE Cliente(
id int,
tipo int  NOT NULL,
nombre varchar(32)  NOT NULL,
correo varchar(32)  NOT NULL UNIQUE, 
direccion varchar(32)  NOT NULL,
puntos int,
CONSTRAINT PKCliente PRIMARY KEY (id),
CONSTRAINT CKPuntos CHECK (puntos>0)
);

		
				/**CREACION SUCURSAL:**/

CREATE TABLE Sucursal(
id int,
compania varchar(32)  NOT NULL,
ciudad varchar(32)  NOT NULL,
tamano varchar(32)  NOT NULL,
direccion varchar(32)  NOT NULL,
CONSTRAINT PKSucursal PRIMARY KEY (id)
);


				/**CREACION PRODUCTO:**/

CREATE TABLE Producto(
codigoBarras int,
nombre varchar(32)  NOT NULL,
marca varchar(32)  NOT NULL,
precioUnidad int NOT NULL,
precioMedidaU int NOT NULL,
CantidadPresentacion int NOT NULL,
unidad varchar(32)  NOT NULL,
especificacion varchar(32)  NOT NULL,
nivelReOrden int NOT NULL,
cantidadReCompra int NOT NULL,
precioProveedor int NOT NULL,
presentacion varchar(32)  NOT NULL,
CONSTRAINT PKProducto PRIMARY KEY (codigoBarras),
CONSTRAINT CKnivelReOrden CHECK (nivelReOrden>0),
CONSTRAINT CKPresentacion CHECK (CantidadPresentacion>0),
CONSTRAINT CKprecioUnidad CHECK (precioUnidad>0),
CONSTRAINT CKprecioMedida CHECK (precioMedidaU>0),
CONSTRAINT CKcantidadReCompra CHECK (cantidadReCompra>0)
);

				
				/**CREACION CATEGORIA:**/

CREATE TABLE Categoria(
id int,
tipo int  NOT NULL,
fechaVencimiento DATE, 
CONSTRAINT PKCategoria PRIMARY KEY (id)
);
