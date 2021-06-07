INSERT INTO cajeros VALUES(1, 'Felipe Ortega');
INSERT INTO cajeros VALUES(2, 'Juan Nuñez');

INSERT INTO maquinas_Registradoras VALUES(1,4);
INSERT INTO maquinas_Registradoras VALUES(2,1);

INSERT INTO productos VALUES(1,'Pepsi', 9);
INSERT INTO productos VALUES(2,'Coca-Cola', 10);

INSERT INTO venta VALUES(1,2,1);
INSERT INTO venta VALUES(2,1,2);
INSERT INTO venta VALUES(1,1,2);

SELECT nomapls as "Vendedor", nombre as "Producto Vendido", precio as "Precio", piso FROM venta 
JOIN maquinas_registradoras ON venta.maquina = maquinas_registradoras.maquina
JOIN cajeros ON venta.cajero = cajeros.cajero
JOIN productos ON venta.producto = productos.producto ORDER BY precio DESC;

SELECT piso, COUNT(productos.producto) AS "Productos Vendidos" FROM venta 
JOIN maquinas_registradoras ON venta.maquina = maquinas_registradoras.maquina 
JOIN productos ON venta.producto = productos.producto Group BY piso ORDER BY piso ASC;

SELECT cajeros.cajero, nomapls, SUM(precio) AS "Importe total" FROM venta
JOIN cajeros ON venta.cajero = cajeros.cajero 
JOIN productos ON venta.producto = productos.producto GROUP BY cajeros.cajero 
ORDER BY cajeros.cajero ASC;

SELECT DISTINCT cajeros.cajero, nomapls FROM venta
JOIN cajeros ON venta.cajero = cajeros.cajero
JOIN productos ON venta.producto = productos.producto
JOIN maquinas_registradoras ON venta.maquina = maquinas_registradoras.maquina
WHERE (maquinas_registradoras.maquina IN (SELECT maquina FROM maquinas_registradoras AS ma WHERE (
	piso IN (
		SELECT ma.piso FROM venta AS v 
		JOIN productos AS product ON v.producto = product.producto 
		CROSS JOIN maquinas_registradoras as maq WHERE (v.maquina = maq.maquina) GROUP BY maq.piso
	HAVING SUM(maq.piso)<500.000))));