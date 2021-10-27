package com.salesianos.triana.Dam.Ejercicio08.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
/*
No he elegido una asociación bidireccional entre pedido y cliente ya que pienso que no es necesario
traeme de un cliente todos los pedidos del mismo.
 */
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String codPedido;

    private boolean conIva;

    private double total;

    @ManyToOne
    @JoinColumn(name = "cliente", foreignKey = @ForeignKey(name = "FK_PEDIDO_CLIENTE"))
    private Cliente c;

}


