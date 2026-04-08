Drop database if exists DB_tiendaConsony_in5cm;
create database DB_tiendaConsony_in5cm;
use DB_tiendaConsony_in5cm;
 
create table Clientes (
    dpi_cliente int primary key not null,
    nombre_cliente varchar(50),
    apellido_cliente varchar(50),
    direccion varchar(100),
    estado int
);
 
create table Usuarios (
    codigo_usuario int primary key not null,
    username varchar(45),
    password varchar(45),
    email varchar(60),
    rol varchar(45),
    estado int
);
 
create table Productos (
    codigo_producto int primary key,
    nombre_producto varchar(60),
    precio decimal(10,2),
    stock int,
    estado int
);
 
create table Ventas (
    codigo_venta int primary key not null,
    fecha_venta date,
    total decimal(10,2),
    estado int,
    clientes_dpi_cliente int,
    usuarios_codigo_usuario int,
    foreign key (clientes_dpi_cliente) references Clientes(dpi_cliente) on delete cascade,
    foreign key (usuarios_codigo_usuario) references Usuarios(codigo_usuario) on delete cascade
);
 
create table Detalle_venta (
    codigo_detalle_venta int primary key not null,
    cantidad int,
    precio_unitario decimal(10,2),
    subtotal decimal(10,2),
    productos_codigo_producto int,
    ventas_codigo_venta int,
    foreign key (productos_codigo_producto) references Productos(codigo_producto) on delete cascade,
    foreign key (ventas_codigo_venta) references Ventas(codigo_venta) on delete cascade
);
 
 
-- ======== Procedimientos Almacenados ======== --
 
 
-- ===== clientes =====
delimiter $$
create procedure sp_create_Cliente(in p_dpi int,in p_nombre varchar(50),
    in p_apellido varchar(50),in p_direccion varchar(100),in p_estado int
)
begin
    insert into Clientes values(p_dpi, p_nombre, p_apellido, p_direccion, p_estado);
end$$
delimiter ;
 
delimiter $$
create procedure sp_read_all_Clientes()
begin
    select * from Clientes;
end$$
delimiter ;
 
delimiter $$
create procedure sp_update_Cliente(in p_dpi int,in p_nombre varchar(50),
    in p_apellido varchar(50),in p_direccion varchar(100),in p_estado int
)
begin
    update Clientes
    set nombre_cliente = p_nombre,
        apellido_cliente = p_apellido,
        direccion = p_direccion,
        estado = p_estado
    where dpi_cliente = p_dpi;
end$$
delimiter ;
 
delimiter $$
create procedure sp_delete_Cliente(in p_dpi int)
begin
    delete from Clientes where dpi_cliente = p_dpi;
end$$
delimiter ;
 
-- ===== usuarios =====
delimiter $$
create procedure sp_create_Usuario(in p_codigo int,in p_username varchar(45),
    in p_password varchar(45),in p_email varchar(60),in p_rol varchar(45),in p_estado int
)
begin
    insert into Usuarios values(p_codigo, p_username, p_password, p_email, p_rol, p_estado);
end$$
delimiter ;
 
delimiter $$
create procedure sp_read_all_Usuarios()
begin
    select * from Usuarios;
end$$
delimiter ;
 
delimiter $$
create procedure sp_update_Usuario(in p_codigo int,in p_username varchar(45),
    in p_password varchar(45),in p_email varchar(60),in p_rol varchar(45),in p_estado int
)
begin
    update Usuarios
    set username = p_username,
        password = p_password,
        email = p_email,
        rol = p_rol,
        estado = p_estado
    where codigo_usuario = p_codigo;
end$$
delimiter ;
 
delimiter $$
create procedure sp_delete_Usuario(in p_codigo int)
begin
    delete from Usuarios where codigo_usuario = p_codigo;
end$$
delimiter ;
 
-- ===== productos =====
delimiter $$
create procedure sp_create_Producto(in p_codigo int,in p_nombre varchar(60),
    in p_precio decimal(10,2),in p_stock int,in p_estado int
)
begin
    insert into Productos values(p_codigo, p_nombre, p_precio, p_stock, p_estado);
end$$
delimiter ;
 
delimiter $$
create procedure sp_read_all_Productos()
begin
    select * from Productos;
end$$
delimiter ;
 
delimiter $$
create procedure sp_update_Producto(in p_codigo int,in p_nombre varchar(60),
    in p_precio decimal(10,2),in p_stock int,in p_estado int
)
begin
    update Productos
    set nombre_producto = p_nombre,
        precio = p_precio,
        stock = p_stock,
        estado = p_estado
    where codigo_producto = p_codigo;
end$$
delimiter ;
 
delimiter $$
create procedure sp_delete_Producto(in p_codigo int)
begin
    delete from Productos where codigo_producto = p_codigo;
end$$
delimiter ;
 
-- ===== ventas =====
delimiter $$
create procedure sp_create_Venta(in p_codigo int,in p_fecha date,
    in p_total decimal(10,2),in p_estado int,in p_cliente int,in p_usuario int
)
begin
    insert into Ventas values(p_codigo, p_fecha, p_total, p_estado, p_cliente, p_usuario);
end$$
delimiter ;
 
delimiter $$
create procedure sp_read_all_Ventas()
begin
    select * from Ventas;
end$$
delimiter ;
 
delimiter $$
create procedure sp_delete_venta(in p_codigo int)
begin
    delete from Ventas where codigo_venta = p_codigo;
end$$
delimiter ;
 
-- ===== detalle_venta =====
delimiter $$
create procedure sp_create_Detalle_venta(in p_codigo int,in p_cantidad int,
    in p_precio decimal(10,2),in p_subtotal decimal(10,2),in p_producto int,in p_venta int
)
begin
    insert into Detalle_venta values(p_codigo, p_cantidad, p_precio, p_subtotal, p_producto, p_venta);
end$$
delimiter ;
 
delimiter $$
create procedure sp_read_all_Detalle_venta()
begin
    select * from Detalle_venta;
end$$
delimiter ;
 
delimiter $$
create procedure sp_update_Detalle_venta(in p_codigo int,in p_cantidad int,
    in p_precio decimal(10,2),in p_subtotal decimal(10,2),in p_producto int,in p_venta int
)
begin
    update Detalle_venta
    set cantidad = p_cantidad,
        precio_unitario = p_precio,
        subtotal = p_subtotal,
        productos_codigo_producto = p_producto,
        ventas_codigo_venta = p_venta
    where codigo_detalle_venta = p_codigo;
end$$
delimiter ;
 
delimiter $$
create procedure sp_delete_Detalle_venta(in p_codigo int)
begin
    delete from Detalle_venta where codigo_detalle_venta = p_codigo;
end$$
delimiter ;