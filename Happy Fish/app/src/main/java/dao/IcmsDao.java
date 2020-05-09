package dao;

import model.Icms;

public class IcmsDao {

    public boolean salvar(Icms icms){
        System.out.println("Icms salvo com sucesso"+"\nO estado "+icms.getEstado()+" tem uma aliquota de: "+icms.getAliquota()+"%");
        return  true;
    }

}
