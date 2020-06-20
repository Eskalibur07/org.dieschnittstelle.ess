package org.dieschnittstelle.ess.ejb.ejbmodule.erp.crud;

import org.dieschnittstelle.ess.entities.erp.AbstractProduct;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProductCRUDStateless implements ProductCRUDRemote {

    @PersistenceContext(unitName = "erp_PU")
    private EntityManager em;

    @Override
    public AbstractProduct createProduct(AbstractProduct prod) {
        em.persist(prod);
        return prod;
    }

    @Override
    public List<AbstractProduct> readAllProducts() {
        Query qu =  em.createQuery("SELECT e FROM AbstractProduct e");
        return qu.getResultList();
    }

    @Override
    public AbstractProduct updateProduct(AbstractProduct update) {
        return null;
    }

    @Override
    public AbstractProduct readProduct(long productID) {
       // Todo Sioki - productID bulunamyior
        //return em.find(AbstractProduct.class.pruductID);
        return null;
    }

    @Override
    public boolean deleteProduct(long productID) {
        return false;
    }
}
