drop database if exists DB_tiendaConsony_in5cm;
create database DB_tiendaConsony_in5cm;
use DB_tiendaConsony_in5cm;

-- Tablas --

create table Producto(
id_producto int primary key auto_increment,
nombre_producto varchar(50) not null,
precio_producto decimal(10,2) not null,
stock_producto int not null
);

create table Clientes(
id_cliente int primary key auto_increment,
nombre_cliente varchar(50) not null,
apellido_cliente varchar(50) not null,
telefono_cliente varchar(15) not null,
correo_cliente varchar(50) not null,
direccion_cliente varchar(50) not null
);

create table Usuarios(
id_usuario int primary key auto_increment,
username varchar(50) not null,
contrasena varchar(50) not null,
rol varchar(50) not null
);

create table Ventas(
id_venta int primary key auto_increment,
fecha_venta datetime not null,
total_venta decimal(10,2),
fk_id_cliente int not null,
fk_id_usuario int not null,
constraint fk_venta_cliente foreign key (fk_id_cliente) references Clientes(id_cliente),
constraint fk_venta_usuario foreign key (fk_id_usuario) references Usuarios(id_usuario)
);

create table Detalle_Venta(
id_detalle int primary key auto_increment,
fk_id_venta int not null,
fk_id_producto int not null,
cantidad int not null,
precio_unitario decimal(10,2) not null,
constraint fk_detalle_venta foreign key (fk_id_venta) references Ventas(id_venta),
constraint fk_detalle_producto foreign key (fk_id_producto) references Producto(id_producto)
);

-- Procedimientos almacenados --
-- Producto --

delimiter $$

create procedure sp_insert_producto(
in p_nombre varchar(50),
in p_precio decimal(10,2),
in p_stock int
)
begin
insert into Producto(nombre_producto, precio_producto, stock_producto)
values (p_nombre, p_precio, p_stock);
end $$

create procedure sp_select_producto()
begin
select * from Producto;
end $$

create procedure sp_update_producto(
in p_id int,
in p_nombre varchar(50),
in p_precio decimal(10,2),
in p_stock int
)
begin
update Producto
set nombre_producto = p_nombre,
precio_producto = p_precio,
stock_producto = p_stock
where id_producto = p_id;
end $$

create procedure sp_delete_producto(in p_id int)
begin
delete from Producto where id_producto = p_id;
end $$

delimiter ;

-- Clientes --

delimiter $$

create procedure sp_insert_cliente(
in p_nombre varchar(50),
in p_apellido varchar(50),
in p_telefono varchar(15),
in p_correo varchar(50),
in p_direccion varchar(50)
)
begin
insert into Clientes(nombre_cliente, apellido_cliente, telefono_cliente, correo_cliente, direccion_cliente)
values (p_nombre, p_apellido, p_telefono, p_correo, p_direccion);
end $$

create procedure sp_select_cliente()
begin
select * from Clientes;
end $$

create procedure sp_update_cliente(
in p_id int,
in p_nombre varchar(50),
in p_apellido varchar(50),
in p_telefono varchar(15),
in p_correo varchar(50),
in p_direccion varchar(50)
)
begin
update Clientes
set nombre_cliente = p_nombre,
apellido_cliente = p_apellido,
telefono_cliente = p_telefono,
correo_cliente = p_correo,
direccion_cliente = p_direccion
where id_cliente = p_id;
end $$

create procedure sp_delete_cliente(in p_id int)
begin
delete from Clientes where id_cliente = p_id;
end $$

delimiter ;

-- usuarios --
delimiter $$

create procedure sp_insert_usuario(
in p_user varchar(50),
in p_pass varchar(50),
in p_rol varchar(50)
)
begin
insert into Usuarios(username, contrasena, rol)
values (p_user, p_pass, p_rol);
end $$

create procedure sp_select_usuario()
begin
select * from Usuarios;
end $$

create procedure sp_update_usuario(
in p_id int,
in p_user varchar(50),
in p_pass varchar(50),
in p_rol varchar(50)
)
begin
update Usuarios
set username = p_user,
contrasena = p_pass,
rol = p_rol
where id_usuario = p_id;
end $$

create procedure sp_delete_usuario(in p_id int)
begin
delete from Usuarios where id_usuario = p_id;
end $$

delimiter ;

-- Ventas --

delimiter $$

create procedure sp_insert_venta(
in p_fecha datetime,
in p_total decimal(10,2),
in p_cliente int,
in p_usuario int
)
begin
insert into Ventas(fecha_venta, total_venta, fk_id_cliente, fk_id_usuario)
values (p_fecha, p_total, p_cliente, p_usuario);
end $$

create procedure sp_select_venta()
begin
select * from Ventas;
end $$

create procedure sp_update_venta(
in p_id int,
in p_fecha datetime,
in p_total decimal(10,2),
in p_cliente int,
in p_usuario int
)
begin
update Ventas
set fecha_venta = p_fecha,
total_venta = p_total,
fk_id_cliente = p_cliente,
fk_id_usuario = p_usuario
where id_venta = p_id;
end $$

create procedure sp_delete_venta(in p_id int)
begin
delete from Ventas where id_venta = p_id;
end $$

delimiter ;

-- detalle venta --

delimiter $$

create procedure sp_insert_detalle(
in p_venta int,
in p_producto int,
in p_cantidad int,
in p_precio decimal(10,2)
)
begin
insert into Detalle_Venta(fk_id_venta, fk_id_producto, cantidad, precio_unitario)
values (p_venta, p_producto, p_cantidad, p_precio);
end $$

create procedure sp_select_detalle()
begin
select * from Detalle_Venta;
end $$

create procedure sp_update_detalle(
in p_id int,
in p_venta int,
in p_producto int,
in p_cantidad int,
in p_precio decimal(10,2)
)
begin
update Detalle_Venta
set fk_id_venta = p_venta,
fk_id_producto = p_producto,
cantidad = p_cantidad,
precio_unitario = p_precio
where id_detalle = p_id;
end $$

create procedure sp_delete_detalle(in p_id int)
begin
delete from Detalle_Venta where id_detalle = p_id;
end $$

delimiter ;

-- registros --

-- productos
call sp_insert_producto('teclado', 150.00, 10);
call sp_insert_producto('mouse', 80.00, 25);
call sp_insert_producto('monitor', 1200.00, 5);
call sp_insert_producto('laptop', 5500.00, 3);
call sp_insert_producto('audifonos', 200.00, 15);
call sp_insert_producto('webcam', 300.00, 8);
call sp_insert_producto('microfono', 450.00, 6);
call sp_insert_producto('usb 32gb', 50.00, 40);
call sp_insert_producto('silla gamer', 1800.00, 2);
call sp_insert_producto('alfombrilla', 60.00, 30);

-- clientes
call sp_insert_cliente('juan', 'perez', '11111111', 'juan1@gmail.com', 'zona 1');
call sp_insert_cliente('ana', 'lopez', '22222222', 'ana@gmail.com', 'zona 2');
call sp_insert_cliente('carlos', 'ramirez', '33333333', 'carlos@gmail.com', 'zona 3');
call sp_insert_cliente('maria', 'gomez', '44444444', 'maria@gmail.com', 'zona 4');
call sp_insert_cliente('luis', 'hernandez', '55555555', 'luis@gmail.com', 'zona 5');
call sp_insert_cliente('sofia', 'martinez', '66666666', 'sofia@gmail.com', 'zona 6');
call sp_insert_cliente('diego', 'castro', '77777777', 'diego@gmail.com', 'zona 7');
call sp_insert_cliente('laura', 'ruiz', '88888888', 'laura@gmail.com', 'zona 8');
call sp_insert_cliente('pedro', 'flores', '99999999', 'pedro@gmail.com', 'zona 9');
call sp_insert_cliente('elena', 'morales', '10101010', 'elena@gmail.com', 'zona 10');

-- usuario
call sp_insert_usuario('admin', '1234', 'admin');
call sp_insert_usuario('vendedor1', '1234', 'vendedor');
call sp_insert_usuario('vendedor2', '1234', 'vendedor');
call sp_insert_usuario('vendedor3', '1234', 'vendedor');
call sp_insert_usuario('vendedor4', '1234', 'vendedor');
call sp_insert_usuario('vendedor5', '1234', 'vendedor');
call sp_insert_usuario('user6', '1234', 'vendedor');
call sp_insert_usuario('user7', '1234', 'vendedor');
call sp_insert_usuario('user8', '1234', 'vendedor');
call sp_insert_usuario('user9', '1234', 'vendedor');

-- ventas
call sp_insert_venta(now(), 300.00, 1, 1);
call sp_insert_venta(now(), 160.00, 2, 2);
call sp_insert_venta(now(), 1200.00, 3, 3);
call sp_insert_venta(now(), 5500.00, 4, 4);
call sp_insert_venta(now(), 200.00, 5, 5);
call sp_insert_venta(now(), 300.00, 6, 6);
call sp_insert_venta(now(), 450.00, 7, 7);
call sp_insert_venta(now(), 100.00, 8, 8);
call sp_insert_venta(now(), 1800.00, 9, 9);
call sp_insert_venta(now(), 60.00, 10, 10);

-- detalle_venta
call sp_insert_detalle(1, 1, 2, 150.00);
call sp_insert_detalle(2, 2, 2, 80.00);
call sp_insert_detalle(3, 3, 1, 1200.00);
call sp_insert_detalle(4, 4, 1, 5500.00);
call sp_insert_detalle(5, 5, 1, 200.00);
call sp_insert_detalle(6, 6, 1, 300.00);
call sp_insert_detalle(7, 7, 1, 450.00);
call sp_insert_detalle(8, 8, 2, 50.00);
call sp_insert_detalle(9, 9, 1, 1800.00);
call sp_insert_detalle(10, 10, 1, 60.00);

-- usuario
call sp_insert_usuario('admin', '1234', 'admin');
call sp_insert_usuario('vendedor1', '1234', 'vendedor');
call sp_insert_usuario('vendedor2', '1234', 'vendedor');
call sp_insert_usuario('vendedor3', '1234', 'vendedor');
call sp_insert_usuario('vendedor4', '1234', 'vendedor');
call sp_insert_usuario('vendedor5', '1234', 'vendedor');
call sp_insert_usuario('user6', '1234', 'vendedor');
call sp_insert_usuario('user7', '1234', 'vendedor');
call sp_insert_usuario('user8', '1234', 'vendedor');
call sp_insert_usuario('user9', '1234', 'vendedor');