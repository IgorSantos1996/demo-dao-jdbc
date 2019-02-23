package aplication;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department obj = new Department(1, "Books");
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);


        SellerDao sellerDao = DaoFactory.createSellerDao();
        //dessa forma meu programa não conhece a implementação, conhece somente a interface
        // é uma forma de fazer injeção de dependência sem explicitar a implementação
        System.out.println(seller);
    }

}
