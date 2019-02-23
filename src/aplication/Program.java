package aplication;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        //dessa forma meu programa não conhece a implementação, conhece somente a interface
        // é uma forma de fazer injeção de dependência sem explicitar a implementação
        System.out.println("=== Test #1: Seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("\n");
        System.out.println("=== Test #2: Seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }
    }
}
