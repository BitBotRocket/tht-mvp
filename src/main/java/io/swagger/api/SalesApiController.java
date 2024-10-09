package io.swagger.api;

import io.swagger.model.Sale;
import io.swagger.model.SaleProducts;
import io.swagger.model.SaleReceipt;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-09T18:44:33.080945746Z[GMT]")
@RestController
public class SalesApiController implements SalesApi {

    private static final Logger log = LoggerFactory.getLogger(SalesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SalesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<SaleReceipt> submitSalesRequest(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Sale body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SaleReceipt>(objectMapper.readValue("{\n  \"summary\" : {\n    \"totalBeforeTaxes\" : 2.302136,\n    \"taxRate\" : 7.0614014,\n    \"taxes\" : 9.301444,\n    \"totalAfterTaxes\" : 3.6160767\n  },\n  \"discounts\" : [ {\n    \"code\" : \"code\",\n    \"discountUnit\" : \"fixed\",\n    \"discount\" : 0.8008282\n  }, {\n    \"code\" : \"code\",\n    \"discountUnit\" : \"fixed\",\n    \"discount\" : 0.8008282\n  } ],\n  \"products\" : [ {\n    \"unitPrice\" : 1.4658129,\n    \"totalBeforeTax\" : 5.637377,\n    \"quantity\" : 6.027456183070403,\n    \"id\" : \"100\",\n    \"appliedDiscount\" : 5.962134\n  }, {\n    \"unitPrice\" : 1.4658129,\n    \"totalBeforeTax\" : 5.637377,\n    \"quantity\" : 6.027456183070403,\n    \"id\" : \"100\",\n    \"appliedDiscount\" : 5.962134\n  } ]\n}", SaleReceipt.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SaleReceipt>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SaleReceipt>(HttpStatus.NOT_IMPLEMENTED);
    }

}
