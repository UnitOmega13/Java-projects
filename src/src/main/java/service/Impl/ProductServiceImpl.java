package service.Impl;

import dao.ProductDAO;
import factories.ProductDAOFactory;
import model.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService<Product> {

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
    public Product getProduct(Long productId) {
        return (Product) productDAO.getProduct(productId);
    }

    @Override
    public void removeProduct(Long productId) {
        productDAO.removeProduct(productId);
    }
}
