/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 20/7/18
 */
package com.test.api.framework.exceptions;

import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServiceUnavailable implements ExceptionMapper<ServiceUnavailableException> {

    public Response toResponse(ServiceUnavailableException e) {
        return ErrorResponse.build(ErrorResponse.Keys.SERVICE_UNAVAILABLE);
    }

}
