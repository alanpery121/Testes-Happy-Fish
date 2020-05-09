package dao;

import model.Pedido;
import model.Venda;

public class VendaDao {
    public boolean salvar(Venda venda){
        System.out.println("Venda salva com sucesso"+"\nFuncionario "+venda.getNomeFuncionario()+"\nComissão "+venda.getComissao()+"%");
        return  true;
    }
}
