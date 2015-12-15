CREATE TABLE Usuario (IdEmail varchar(255) NOT NULL, IdApartamento int(11) NOT NULL, Nombre varchar(255), Apellido varchar(255), Contraseña varchar(255), NumeroTelefono int(11) NOT NULL, PRIMARY KEY (IdEmail));
CREATE TABLE Apartamento (IdApartamento int(11) NOT NULL AUTO_INCREMENT, IdEmail varchar(255) NOT NULL, TipoPropiedad varchar(255), NumeroHuespedes int(11) NOT NULL, Barrio varchar(255), Direccion varchar(255), Tarifa float NOT NULL, TipoCancelacion varchar(255), PRIMARY KEY (IdApartamento));
CREATE TABLE Reserva (IdReserva varchar(255) NOT NULL, IdEmail varchar(255) NOT NULL, IdApartamento int(11) NOT NULL, FechaInicio date NOT NULL, FechaFinal date NOT NULL, PRIMARY KEY (IdReserva));
CREATE TABLE CuentaBancaria (IdCuenta int(11) NOT NULL AUTO_INCREMENT, IdEmail varchar(255) NOT NULL, Saldo float NOT NULL, PRIMARY KEY (IdCuenta));
ALTER TABLE CuentaBancaria ADD INDEX FKCuentaBanc914323 (IdEmail), ADD CONSTRAINT FKCuentaBanc914323 FOREIGN KEY (IdEmail) REFERENCES Usuario (IdEmail);
ALTER TABLE Reserva ADD INDEX FKReserva349891 (IdApartamento), ADD CONSTRAINT FKReserva349891 FOREIGN KEY (IdApartamento) REFERENCES Apartamento (IdApartamento);
ALTER TABLE Reserva ADD INDEX FKReserva883948 (IdEmail), ADD CONSTRAINT FKReserva883948 FOREIGN KEY (IdEmail) REFERENCES Usuario (IdEmail);
ALTER TABLE Apartamento ADD INDEX FKApartament529612 (IdEmail), ADD CONSTRAINT FKApartament529612 FOREIGN KEY (IdEmail) REFERENCES Usuario (IdEmail);
