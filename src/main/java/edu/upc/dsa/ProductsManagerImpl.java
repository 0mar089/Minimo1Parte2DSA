package edu.upc.dsa;

import edu.upc.dsa.exceptions.ProductNotFoundException;
import edu.upc.dsa.models.Product;

import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class ProductsManagerImpl implements ProductsManager {

    private static ProductsManager instance;
    protected List<Product> Products;
    final static Logger logger = Logger.getLogger(ProductsManagerImpl.class);

    private ProductsManagerImpl() {
        this.Products = new LinkedList<>();
    }

    public static ProductsManager getInstance() {
        if (instance==null) instance = new ProductsManagerImpl();
        return instance;
    }

    public int size() {
        int ret = this.Products.size();
        logger.info("size " + ret);

        return ret;
    }

    public Product addProduct(Product t) {
        logger.info("new Product " + t);

        this.Products.add (t);
        logger.info("new Product added");
        return t;
    }

    public Product addProduct(String id, String name){
        return this.addProduct(id, name, 0.0);
    }

    public Product addProduct(String id, String name, Double price) {
        return this.addProduct(new Product(id, name, price));
    }

    public Product getProduct(String id) {
        logger.info("getProduct("+id+")");

        for (Product t: this.Products) {
            if (t.getId().equals(id)) {
                logger.info("getProduct("+id+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public Product getProduct2(String id) throws ProductNotFoundException {
        Product t = getProduct(id);
        if (t == null) throw new ProductNotFoundException();
        return t;
    }


    public List<Product> findAll() {
        return this.Products;
    }

    @Override
    public void deleteProduct(String id) {

        Product t = this.getProduct(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.Products.remove(t);

    }

    @Override
    public Product updateProduct(Product p) {
        Product t = this.getProduct(p.getId());

        if (t!=null) {
            logger.info(p+" rebut!!!! ");

            t.setId(p.getId());
            t.setPrice(p.getPrice());
            t.setName(p.getName());

            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return t;
    }

    public void clear() {
        this.Products.clear();
    }
}