package com.example.happyfish;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import dao.IcmsDao;
import dao.PedidoDao;
import model.Icms;
import model.Pedido;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class PedidoDaoTest {
    @Test
    public void testeSalvarPedidoNoBancoDeDados(){
        Pedido p = new Pedido("Alan Pery", "Tucunare", "3");
        PedidoDao pDao = new PedidoDao();

        assertTrue(pDao.salvar(p));

    }

    @Test
    public void DeveriaSalvarPedidoMock(){
        Pedido p = new Pedido("Alan Pery Viana", "Tucunare", "3");
        PedidoDao DaoFalso = Mockito.mock(PedidoDao.class);
        Mockito.when(DaoFalso.salvar(p)).thenReturn(true);


    }
}
