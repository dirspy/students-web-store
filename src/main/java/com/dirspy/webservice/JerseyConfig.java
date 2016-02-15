package com.dirspy.webservice;

import com.dirspy.webservice.endpoints.StudentEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @author Victor Moskvych
 */

@Component
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig() {
        register(StudentEndpoint.class);
    }

}
