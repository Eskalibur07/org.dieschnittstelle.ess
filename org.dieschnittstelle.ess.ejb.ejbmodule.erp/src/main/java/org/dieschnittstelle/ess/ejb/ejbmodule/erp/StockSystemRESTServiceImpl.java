package org.dieschnittstelle.ess.ejb.ejbmodule.erp;

import org.dieschnittstelle.ess.ejb.ejbmodule.erp.crud.ProductCRUDRemote;
import org.dieschnittstelle.ess.entities.erp.AbstractProduct;
import org.dieschnittstelle.ess.entities.erp.IndividualisedProductItem;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ws.rs.BadRequestException;
import java.util.List;

@Stateless
public class StockSystemRESTServiceImpl implements StockSystemRESTService {

    @EJB
    private StockSystemLocal stockSystem;

    @EJB
    private ProductCRUDRemote productCRUD;

    @Override
    public void addToStock(long productId, long pointOfSaleId, int units) {
        AbstractProduct prod = productCRUD.readProduct(productId);
        stockSystem.addToStock((IndividualisedProductItem)prod,pointOfSaleId,units);
    }

    @Override
    public void removeFromStock(long productId, long pointOfSaleId, int units) {
        AbstractProduct prod = productCRUD.readProduct(productId);
        stockSystem.removeFromStock((IndividualisedProductItem)prod,pointOfSaleId,units);
    }

    // Ab hier muss gemacht werden
    @Override
    public List<IndividualisedProductItem> getProductsOnStock(long pointOfSaleId) {
        if (pointOfSaleId > 0){
            return stockSystem.getProductsOnStock(pointOfSaleId);
        }else{
            return stockSystem.getAllProductsOnStock();
        }
    }

    @Override
    public List<IndividualisedProductItem> getAllProductsOnStock() {
        return null;
    }

    @Override
    public int getUnitsOnStock(long productId, long pointOfSaleId) {
        if (productId > 0 && pointOfSaleId > 0){
            AbstractProduct prod = productCRUD.readProduct(productId);
            return stockSystem.getUnitsOnStock((IndividualisedProductItem)prod,pointOfSaleId);
        } else if (productId > 0) {
            AbstractProduct prod = productCRUD.readProduct(productId);
            return stockSystem.getTotalUnitsOnStock((IndividualisedProductItem)prod);
        } else{
            throw new BadRequestException("productId: "+productId+" dose not refer to an IndividualproductItem!");
        }
    }

    @Override
    public int getTotalUnitsOnStock(long productId) {
        return 0;
    }

    @Override
    public List<Long> getPointsOfSale(long productId) {
        AbstractProduct prod = productCRUD.readProduct(productId);
        if(prod instanceof IndividualisedProductItem){
            return stockSystem.getPointsOfSale((IndividualisedProductItem)prod);
        }else{
            throw new BadRequestException("At least productId must refer to an existing product.");
        }
    }
}
