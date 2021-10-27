package com.salesianos.triana.Dam.Ejercicio08;

import com.salesianos.triana.Dam.Ejercicio08.models.ClienteCorporativo;
import com.salesianos.triana.Dam.Ejercicio08.models.ClienteParticular;
import com.salesianos.triana.Dam.Ejercicio08.models.Empleado;
import com.salesianos.triana.Dam.Ejercicio08.models.Pedido;
import com.salesianos.triana.Dam.Ejercicio08.services.ClienteService;
import com.salesianos.triana.Dam.Ejercicio08.services.EmpleadoService;
import com.salesianos.triana.Dam.Ejercicio08.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final ClienteService clienteService;
    private final EmpleadoService empleadoService;
    private final PedidoService pedidoService;

    @PostConstruct
    public void test() {



        ClienteCorporativo clientecorporativo= ClienteCorporativo.builder()
                .nombre("paco")
                .apellidos("de lucía")
                .email("pacodelucia69@gmail.com")
                .build();

        clienteService.edit(clientecorporativo);


        Empleado empleado= Empleado.builder()
                .nombre("Miguel")
                .departamento("Hardware")
                .sueldo(1500.00)
                .build();

        empleadoService.edit(empleado);

        empleado.addClienteCorporativo(clientecorporativo);



        Pedido pedido= Pedido.builder()
                .conIva(false)
                .total(123.21)
                .c(clientecorporativo)
                .build();

        pedidoService.edit(pedido);


        ClienteParticular clienteparticular= ClienteParticular.builder()
                .nombre("Luismi")
                .apellidos("López")
                .email("LuismiElmáquina@gmail.com")
                .build();

        clienteService.edit(clienteparticular);



        System.out.println("El nuevo cliente corporativo se llama: " + clientecorporativo.getNombre()
        + " y es repredentado por el empleado " + clientecorporativo.getEmpleado().getNombre());
        System.out.println("El total del nuevo pedido es de: " + pedido.getTotal() +
                " y el pedido pertenece a " + pedido.getC().getNombre());
        System.out.println("El nuevo cliente particular se llama: " + clienteparticular.getNombre());

    }
}