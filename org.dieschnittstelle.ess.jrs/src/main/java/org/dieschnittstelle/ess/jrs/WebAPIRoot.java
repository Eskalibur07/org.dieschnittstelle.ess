package org.dieschnittstelle.ess.jrs;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class WebAPIRoot extends Application {

    @Override
    public  Set<Class<?>> getClasses() {
        Set klasses = new HashSet();
        // /api/touchpoints/{id}
        klasses.add(TouchpointCRUDServiceImpl.class);
        klasses.add(JacksonJaxbJsonProvider.class);

        return klasses;
    }
}
