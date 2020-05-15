package org.dieschnittstelle.ess.jrs;

import org.dieschnittstelle.ess.entities.erp.IndividualisedProductItem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/*
 * UE JRS2: 
 * deklarieren Sie hier Methoden fuer:
 * - die Erstellung eines Produkts
 * - das Auslesen aller Produkte
 * - das Auslesen eines Produkts
 * - die Aktualisierung eines Produkts
 * - das Loeschen eines Produkts
 * und machen Sie diese Methoden mittels JAX-RS Annotationen als WebService verfuegbar
 */
@Path("/products")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})

/*
 * UE JRS3: aendern Sie Argument- und Rueckgabetypen der Methoden von IndividualisedProductItem auf AbstractProduct
 */
public interface IProductCRUDService {

	@POST
	public IndividualisedProductItem createProduct(IndividualisedProductItem prod);
	@GET
	public List<IndividualisedProductItem> readAllProducts();
	@PUT
	public IndividualisedProductItem updateProduct(long id,
												   IndividualisedProductItem update);
	@DELETE
	@Path("/{productId")
	boolean deleteProduct(long id);

	@GET
	@Path("/{productId")
	public IndividualisedProductItem readProduct(long id);
			
}
