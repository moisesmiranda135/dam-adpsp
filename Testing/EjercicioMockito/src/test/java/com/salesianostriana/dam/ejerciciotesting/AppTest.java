package com.salesianostriana.dam.ejerciciotesting;


import com.salesianostriana.dam.ejerciciotesting.model.Cliente;
import com.salesianostriana.dam.ejerciciotesting.model.LineaDeVenta;
import com.salesianostriana.dam.ejerciciotesting.model.Producto;
import com.salesianostriana.dam.ejerciciotesting.model.Venta;
import com.salesianostriana.dam.ejerciciotesting.repos.ProductoRepositorio;
import com.salesianostriana.dam.ejerciciotesting.repos.VentaRepositorio;
import com.salesianostriana.dam.ejerciciotesting.services.VentaServicio;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        Cliente cliente = new Cliente();
        cliente.setNombre("Moisés");
       //productoRepositorio.save(new Producto("5", "Monitor 144Hz", 200.0));
        LineaDeVenta lineaDeVenta = new LineaDeVenta(new Producto("5", "Monitor 144Hz", 200.0),2,350);
        List<LineaDeVenta> lista = new ArrayList<>();
        lista.add(lineaDeVenta);
        Venta v2 = new Venta(1L, LocalDate.now(),lista,cliente);

        lenient().when(productoRepositorio.findOne("5")).thenReturn(new Producto("5", "Monitor 144Hz", 200.0));

        lenient().when(ventaRepositorio.save(v2)).thenReturn(v2);

        Venta v = ventaServicio.nuevaVenta(Map.of("5", 2), cliente);
        assertEquals(v2.getId(),v.getId());
    }

}
