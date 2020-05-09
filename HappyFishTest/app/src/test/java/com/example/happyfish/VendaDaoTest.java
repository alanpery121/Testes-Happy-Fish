package com.example.happyfish;

import org.junit.Test;
import org.mockito.Mockito;

import dao.IcmsDao;
import dao.PedidoDao;
import dao.VendaDao;
import model.Icms;
import model.Pedido;
import model.Venda;

import static org.junit.Assert.assertTrue;

public class VendaDaoTest {
    @Test
    public void testeSalvarVendaNoBancoDeDados(){
        Venda v = new Venda("Victor Emanuel", 10);
        VendaDao vDao = new VendaDao();

        assertTrue(vDao.salvar(v));

    }

    @Test
    public void DeveriaSalvarVendaMock(){
        Venda v = new Venda("Victor Emanuel", 10);
        VendaDao vDaoFalso = Mockito.mock(VendaDao.class);
        Mockito.when(vDaoFalso.salvar(v)).thenReturn(true);


    }
}
