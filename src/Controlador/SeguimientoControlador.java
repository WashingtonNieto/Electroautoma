/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Seguimiento;

/**
 *
 * @author washi
 */
public class SeguimientoControlador {

    public boolean insertCliente(int id_cliente,
            int id_muestra,
            int num_dias_entrega,
            String fecha_ingreso_muestras,
            int num_nota_pedido,
            String fecha_objetivo_informe,
            int num_informe,
            String hilo_incandescente,
            String hi_nom_doc_normativo,
            String choque_electrico,
            String ce_nom_doc_normativo,
            String corrocion_oxidacion,
            String co_nom_doc_normativo,
            String adherencia,
            String a_nom_doc_normativo,
            String seccion_trasversal,
            String st_nom_doc_normativo){
        
        Seguimiento seguimiento = new Seguimiento();
        seguimiento.id_cliente = id_cliente;
        seguimiento.id_muestra = id_muestra;
        seguimiento.num_dias_entrega = num_dias_entrega;
        seguimiento.fecha_ingreso_muestras = fecha_ingreso_muestras;
        seguimiento.num_nota_pedido = num_nota_pedido;
        seguimiento.fecha_objetivo_informe = fecha_objetivo_informe;
        seguimiento.num_informe = num_informe;
        seguimiento.hilo_incandescente = hilo_incandescente;
        seguimiento.hi_nom_doc_normativo = hi_nom_doc_normativo;
        seguimiento.choque_electrico = choque_electrico;
        seguimiento.ce_nom_doc_normativo = ce_nom_doc_normativo;
        seguimiento.corrocion_oxidacion = corrocion_oxidacion;
        seguimiento.co_nom_doc_normativo = co_nom_doc_normativo;
        seguimiento.adherencia = adherencia;
        seguimiento.a_nom_doc_normativo = a_nom_doc_normativo;
        seguimiento.seccion_trasversal = seccion_trasversal;
        seguimiento.st_nom_doc_normativo = st_nom_doc_normativo;
        
        return seguimiento.insert();
    }    
}

