package service.Impl;

import dao.ProductDAO;
import factories.ProductDAOFactory;
import model.Product;
import service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO = ProductDAOFactory.getInstance();

    @Override
    public void add(Product product) {
        productDAO.add(product);
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public Optional<Product> getProduct(long productID) {
        return productDAO.getProduct(productID);
    }


    @Override
    public void removeProduct(long productID) {
        productDAO.removeProduct(productID);
    }
}
