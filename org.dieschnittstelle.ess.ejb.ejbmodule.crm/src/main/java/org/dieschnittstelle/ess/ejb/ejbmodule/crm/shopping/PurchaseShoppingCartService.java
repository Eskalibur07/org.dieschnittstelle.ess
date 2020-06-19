package org.dieschnittstelle.ess.ejb.ejbmodule.crm.shopping;

import org.dieschnittstelle.ess.ejb.ejbmodule.crm.ShoppingException;

import javax.ejb.Remote;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/purchase")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Remote
public interface PurchaseShoppingCartService {

    @POST
    public void purchase(@QueryParam("shoppingCartId") long shoppingCartId, @QueryParam("touchpointId") long touchpointId, @QueryParam("customerId") long customerId) throws ShoppingException;
}

// SIOKI - ShoppingException ´ Hata veriyor