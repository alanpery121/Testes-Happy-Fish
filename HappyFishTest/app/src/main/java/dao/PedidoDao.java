package dao;

import model.Icms;
import model.Pedido;

public class PedidoDao {

    public boolean salvar(Pedido pedido){
        System.out.println("Pedido salvo com sucesso"+"\nCliente "+pedido.getNomeCliente()+" comprou "+pedido.getQtdKg()+"kg de "+pedido.getTipoPeixe());
        return  true;
    }

}
