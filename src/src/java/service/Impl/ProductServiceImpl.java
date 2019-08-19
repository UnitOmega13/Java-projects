package service.Impl;

import dao.ProductDAO;
import factories.ProductDAOFactory;
import model.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO = new ProductDAOFactory.getInstance();

    @Override
    public void add(Product product) {
        productDAO.add(product);
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }
}
