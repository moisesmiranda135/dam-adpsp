package com.salesianostriana.dam.ejerciciotesting;


import com.salesianostriana.dam.ejerciciotesting.model.Cliente;
import com.salesianostriana.dam.ejerciciotesting.model.LineaDeVenta;
import com.salesianostriana.dam.ejerciciotesting.model.Producto;
import com.salesianostriana.dam.ejerciciotesting.model.Venta;
import com.salesianostriana.dam.ejerciciotesting.repos.ProductoRepositorio;
import com.salesianostriana.dam.ejerciciotesting.repos.VentaRepositorio;
import com.salesianostriana.dam.ejerciciotesting.services.VentaServicio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;


@ExtendWith(MockitoExtension.class)
public class AppTest {

    @Mock
    VentaRepositorio ventaRepositorio;

    @Mock
    ProductoRepositorio productoRepositorio;

    @InjectMocks
    VentaServicio ventaServicio;

    @Test
    public void whenNewSale_thenReturnSale(){

        //Creamos un cliente y le seteamos un nombre para que no este vacío
        Cliente cliente = new Cliente();
        cliente.setNombre("Moisés");

        // He intentado haciendolo añadiendo directamente el nuevo producto al repositorio pero no se porque no funciona no lo acabo de entender
        //productoRepositorio.save(new Producto("5", "Monitor 144Hz", 200.0));

        //Creamos una linea de centa y le añadimos un producto para realizar el test
        LineaDeVenta lineaDeVenta = new LineaDeVenta(new Producto("1","Ordenador Portátil",699.0),10,6990.0);
        List<LineaDeVenta> lista = new ArrayList<>();
        lista.add(lineaDeVenta);
        Venta v2 = new Venta(1L, LocalDate.now(),lista,cliente);

        //Compruebo que el producto encontrado en el repsoitorio coincida con el creado
        lenient().when(productoRepositorio.findOne("1")).thenReturn(new Producto("1", "Ordenador portátil", 699.0));

        //Compruebo también que cuando lo guarde en el repositorio me devuelva ese objeto
        lenient().when(ventaRepositorio.save(v2)).thenReturn(v2);

        Venta v = ventaServicio.nuevaVenta(Map.of("1", 10), cliente);

        //Realizo assert para comprobar que ambos son iguales
        assertEquals(v2.getId(),v.getId());
    }

    @Test
    public void whenAddProductoToVenta_thenReturnVenta(){
        Cliente cliente = new Cliente();
        cliente.setNombre("Alejandro");
        LineaDeVenta lineaDeVenta = new LineaDeVenta(new Producto("1","Ordenador Portátil",699.0),10,6990.0);
        LineaDeVenta lineaDeVenta2 = new LineaDeVenta(new Producto("2","Ordenador de sobremesa",499.0),10,4990.0);
        List<LineaDeVenta> lista = new ArrayList<>();
        lista.add(lineaDeVenta);
        Optional<Venta> optionalVenta= Optional.of(new Venta(1L, LocalDate.of(2022, 01, 18), lista, cliente));
        lista.add(lineaDeVenta2);
        Venta venta =new Venta(1L, LocalDate.of(2022, 01, 18), lista, cliente);

        lenient().when(productoRepositorio.findOne("2")).thenReturn(new Producto("2", "Ordenador portátil", 699.0));
        lenient().when(ventaRepositorio.findOneOptional(1L)).thenReturn(optionalVenta);
        lenient().when(ventaRepositorio.edit(optionalVenta.get())).thenReturn(venta);

        Venta v2 = ventaServicio.addProductoToVenta(1L,"2",10);
        assertEquals(venta,v2);
    }



}
