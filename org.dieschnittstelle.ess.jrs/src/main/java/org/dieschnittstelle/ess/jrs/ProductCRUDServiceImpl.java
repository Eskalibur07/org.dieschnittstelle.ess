package org.dieschnittstelle.ess.jrs;

import java.util.List;

import org.dieschnittstelle.ess.entities.erp.AbstractProduct;
import org.dieschnittstelle.ess.entities.erp.IndividualisedProductItem;

/*
UE JRS2: implementieren Sie hier die im Interface deklarierten Methoden
 */

public class ProductCRUDServiceImpl implements IProductCRUDService {

	@Override
	public AbstractProduct createProduct(
			AbstractProduct prod) {
		// TODO Auto-generated method stub
		return prod;
	}

	// Sioki - Düzeltilmeli!!!! - hier mikalenjelo

	@Override
	public List<AbstractProduct> readAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractProduct updateProduct(long id, AbstractProduct update) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProduct(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AbstractProduct readProduct(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
