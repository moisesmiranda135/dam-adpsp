package com.salesianostriana.dam;

import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.model.LineaDeVenta;
import com.salesianostriana.dam.model.Producto;
import com.salesianostriana.dam.model.Venta;
import com.salesianostriana.dam.repos.ProductoRepositorio;
import com.salesianostriana.dam.repos.VentaRepositorio;
import com.salesianostriana.dam.service.VentaServicio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {

	@Mock
	VentaRepositorio ventaRepositorio;

	@Mock
	ProductoRepositorio productoRepositorio;

	@InjectMocks
	VentaServicio ventaServicio;


	@Test //Comprobar producto que no existe
	void NewSaleFailsWithNotExistingProductId(){

		Cliente c = Cliente.builder()
				.dni("54182255F")
				.nombre("Moisés Miranda Corrales")
				.email("miranda.comoi20.2triana.salesianos.edu")
				.build();

		Optional<Producto> empty= Optional.empty();

		lenient().when(productoRepositorio.findById(1L)).thenReturn(empty);

		assertThrows(NoSuchElementException.class,()->ventaServicio.nuevaVenta(Map.of(1L,1),c));

	}


	@Test
	public void whenNewSale_thenReturnSale(){

		Cliente c = Cliente.builder()
				.dni("54182255F")
				.nombre("Moisés Miranda Corrales")
				.email("miranda.comoi20.2triana.salesianos.edu")
				.build();

		Producto p = Producto.builder()
				.id(1L)
				.codigoProducto("1")
				.nombre("Ordenador Portátil")
				.precio(699.0)
				.build();

		LineaDeVenta l = LineaDeVenta.builder()
				.id(1L)
				.producto(p)
				.cantidad(2)
				.pvp(699.0)
				.build();

		Venta v = new Venta();
		v.setCliente(c);
		v.setId(1L);
		v.addLineaVenta(l);

		Map<Long, Integer> venta = Map.of(1L,2);


		lenient().when(productoRepositorio.findById(1L)).thenReturn(Optional.of(p));

		Venta v2 = ventaServicio.nuevaVenta(venta,c);

		v2.getLineasDeVenta().forEach(l2 -> assertTrue(l2.getProducto().equals(p)));
	}



	@Test
	public void whenAddProductToSale_thenReturnSale(){

		Optional<Producto> p = Optional.of(Producto.builder()
				.id(1L)
				.codigoProducto("1")
				.nombre("Ordenador Portátil")
				.precio(699.0)
				.build());


		Optional<Venta> v1 = Optional.of(new Venta());
		v1.get().setId(1L);

		lenient().when(ventaRepositorio.findById(1L)).thenReturn(v1);
		lenient().when(productoRepositorio.findById(1L)).thenReturn(p);

		Venta v2 = ventaServicio.addProductoToVenta(1L,1L,1);

		v2.getLineasDeVenta().forEach(l -> assertTrue(l.getProducto().equals(p.get())));
	}


	@Test
	public void whenRemoveSaleLine_thenReturnSale(){

		Optional<Producto> p = Optional.of(Producto.builder()
				.id(1L)
				.codigoProducto("1")
				.nombre("Ordenador Portátil")
				.precio(699.0)
				.build());

		Optional<Venta> v1 = Optional.of(new Venta());
		v1.get().setId(1L);

		LineaDeVenta l1 = LineaDeVenta.builder()
				.producto(p.get())
				.cantidad(1)
				.pvp(2.50)
				.build();

		LineaDeVenta l2 = LineaDeVenta.builder()
				.producto(p.get())
				.cantidad(1)
				.pvp(2.50)
				.build();

		v1.get().addLineaVenta(l1);
		v1.get().addLineaVenta(l2);

		lenient().when(ventaRepositorio.findById(1L)).thenReturn(v1);
		lenient().when(productoRepositorio.findById(1L)).thenReturn(p);

		Venta v2 = ventaServicio.removeLineaVenta(1L,1L);

		v2.getLineasDeVenta().forEach(l -> assertTrue(l.getProducto().equals(p.get())));
	}



}
