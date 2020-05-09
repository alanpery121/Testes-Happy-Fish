package com.example.happyfish;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;


import dao.IcmsDao;
import model.Icms;

@RunWith(JUnit4.class)
public class IcmsDaoTest {
    @Test
    public void testeSalvarIcmsNoBancoDeDados(){
        Icms i = new Icms("Ceará", 12);
        IcmsDao iDao = new IcmsDao();

        assertTrue(iDao.salvar(i));

    }
    @Test
    public void DeveriaSalvarIcmsMock(){
        Icms i = new Icms("Ceará", 12);
        IcmsDao iDaoFalso = Mockito.mock(IcmsDao.class);
        Mockito.when(iDaoFalso.salvar(i)).thenReturn(true);


    }


}
