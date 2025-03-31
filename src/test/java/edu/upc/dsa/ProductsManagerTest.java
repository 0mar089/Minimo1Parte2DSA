package edu.upc.dsa;

import edu.upc.dsa.exceptions.ProductNotFoundException;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ProductsManagerTest {
    ProductsManager tm;

    @Before
    public void setUp() {
        this.tm = edu.upc.dsa.ProductsManagerImpl.getInstance();
        this.tm.addProduct("c1", "Carne", 7.00);
        this.tm.addProduct("c2", "Leche", 2.5);
        this.tm.addProduct("c3", "Pan", 1.00);
    }

    @After
    public void tearDown() {
        // És un Singleton
        this.tm.clear();
    }

    @Test
    public void addProductTest() {
        Assert.assertEquals(3, tm.size());

        this.tm.addProduct("c4", "Agua");

        Assert.assertEquals(4, tm.size());

    }

    @Test
    public void getProductTest() throws Exception {
        Assert.assertEquals(3, tm.size());

        Product t = this.tm.getProduct("c1");
        Assert.assertEquals("c1", t.getId());
        Assert.assertEquals("Carne", t.getName());

        t = this.tm.getProduct2("c2");
        Assert.assertEquals("c2", t.getId());
        Assert.assertEquals("Leche", t.getName());

        Assert.assertThrows(ProductNotFoundException.class, () ->
                this.tm.getProduct2("XXXXXXX"));

    }

    @Test
    public void getProductsTest() {
        Assert.assertEquals(3, tm.size());
        List<Product> products  = tm.findAll();

        Product t = products.get(0);
        Assert.assertEquals("c1", t.getId());
        Assert.assertEquals("Carne", t.getName());

        t = products.get(1);
        Assert.assertEquals("c2", t.getId());
        Assert.assertEquals("Leche", t.getName());

        t = products.get(2);
        Assert.assertEquals("c3", t.getId());
        Assert.assertEquals("Pan", t.getName());

        Assert.assertEquals(3, tm.size());

    }

    @Test
    public void updateProductTest() {
        Assert.assertEquals(3, tm.size());
        Product t = this.tm.getProduct("c1");
        Assert.assertEquals("c1", t.getId());
        Assert.assertEquals("Carne", t.getName());

        t.setName("carne");
        this.tm.updateProduct(t);

        t = this.tm.getProduct("c1");
        Assert.assertEquals("c1", t.getId());
        Assert.assertEquals("carne", t.getName());
    }


    @Test
    public void deleteProductTest() {
        Assert.assertEquals(3, tm.size());
        this.tm.deleteProduct("c1");
        Assert.assertEquals(2, tm.size());

        Assert.assertThrows(ProductNotFoundException.class, () ->
                this.tm.getProduct2("c1"));

    }
}
