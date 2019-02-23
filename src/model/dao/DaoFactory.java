package model.dao;

import model.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    // operações statics para instanciar os dados
    public static SellerDao createSellerDao(){ // retornar um SellerDao (Interface)
        return new SellerDaoJDBC();
        // vai me retornar uma implementação da minha interface SellerDao
        // Não precisa expor a implementação


    }
}

