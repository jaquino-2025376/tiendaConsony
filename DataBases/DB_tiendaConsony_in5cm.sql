Drop database if exists DB_tiendaConsony_in5cm;
create database DB_tiendaConsony_in5cm;
use DB_tiendaConsony_in5cm;
 
create table Clientes (
    codigo_cliente int primary key not null,
    nombre_cliente varchar(50),
    apellido_cliente varchar(50),
    direccion varchar(100),
    estado int
);
 
create table Usuarios (
    codigo_usuario int primary key auto_increment not null,
    username varchar(45),
    contrasena varchar(45),
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
    clientes_codigo_cliente int,
    usuarios_codigo_usuario int,
    foreign key (clientes_codigo_cliente) references Clientes(codigo_cliente) on delete cascade,
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

-- registros --
insert into Clientes values
(1, 'Juan', 'Perez', 'Ciudad de Guatemala', 1),
(2, 'Maria', 'Lopez', 'Mixco', 1),
(3, 'Carlos', 'Ramirez', 'Villa Nueva', 1),
(4, 'Ana', 'Gomez', 'Amatitlán', 1),
(5, 'Luis', 'Martinez', 'Escuintla', 1),
(6, 'Sofia', 'Hernandez', 'Antigua', 1),
(7, 'Pedro', 'Castillo', 'Quetzaltenango', 1),
(8, 'Lucia', 'Morales', 'Petén', 1),
(9, 'Diego', 'Alvarez', 'Chimaltenango', 1),
(10, 'Elena', 'Torres', 'Santa Rosa', 1);

insert into Usuarios values
(1, 'admin', '1234', 'admin@mail.com', 'ADMIN', 1),
(2, 'user1', '1234', 'user1@mail.com', 'USER', 1),
(3, 'user2', '1234', 'user2@mail.com', 'USER', 1),
(4, 'user3', '1234', 'user3@mail.com', 'USER', 1),
(5, 'user4', '1234', 'user4@mail.com', 'USER', 1),
(6, 'user5', '1234', 'user5@mail.com', 'USER', 1),
(7, 'user6', '1234', 'user6@mail.com', 'USER', 1),
(8, 'user7', '1234', 'user7@mail.com', 'USER', 1),
(9, 'user8', '1234', 'user8@mail.com', 'USER', 1),
(10, 'user9', '1234', 'user9@mail.com', 'USER', 1);

insert into Productos values
(1, 'Laptop', 5500.00, 10, 1),
(2, 'Mouse', 50.00, 100, 1),
(3, 'Teclado', 150.00, 50, 1),
(4, 'Monitor', 1200.00, 20, 1),
(5, 'Audifonos', 200.00, 40, 1),
(6, 'USB 32GB', 60.00, 80, 1),
(7, 'Disco Duro', 800.00, 15, 1),
(8, 'Webcam', 300.00, 25, 1),
(9, 'Silla Gamer', 1500.00, 10, 1),
(10, 'Impresora', 900.00, 12, 1);

insert into Ventas values
(1, '2026-01-10', 5550.00, 1, 1, 1),
(2, '2026-01-11', 150.00, 1, 2, 2),
(3, '2026-01-12', 1200.00, 1, 3, 3),
(4, '2026-01-13', 200.00, 1, 4, 4),
(5, '2026-01-14', 60.00, 1, 5, 5),
(6, '2026-01-15', 800.00, 1, 6, 6),
(7, '2026-01-16', 300.00, 1, 7, 7),
(8, '2026-01-17', 1500.00, 1, 8, 8),
(9, '2026-01-18', 900.00, 1, 9, 9),
(10, '2026-01-19', 50.00, 1, 10, 10);

insert into Detalle_venta values
(1, 1, 5500.00, 5500.00, 1, 1),
(2, 1, 50.00, 50.00, 2, 1),
(3, 1, 150.00, 150.00, 3, 2),
(4, 1, 1200.00, 1200.00, 4, 3),
(5, 1, 200.00, 200.00, 5, 4),
(6, 1, 60.00, 60.00, 6, 5),
(7, 1, 800.00, 800.00, 7, 6),
(8, 1, 300.00, 300.00, 8, 7),
(9, 1, 1500.00, 1500.00, 9, 8),
(10, 1, 900.00, 900.00, 10, 9);

UPDATE usuarios 
SET contrasena = '1234';