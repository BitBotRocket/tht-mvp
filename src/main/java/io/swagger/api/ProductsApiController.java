package io.swagger.api;

import io.swagger.model.Product;
import io.swagger.service.ProductService;

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
public class ProductsApiController implements ProductsApi {

    private static final Logger log = LoggerFactory.getLogger(ProductsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final ProductService productService;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductsApiController(ObjectMapper objectMapper, HttpServletRequest request, ProductService productService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.productService = productService;
    }

    public ResponseEntity<Product> createProduct(
            @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            System.out.println("Storing product: " + body);

            Product response = productService.createProduct(body);

            if (response != null) {
                return new ResponseEntity<Product>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<Void> deleteAllProducts() {

        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {
            productService.clearAllProducts();
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Product> getProductById(
            @Parameter(in = ParameterIn.PATH, description = "product identifier", required = true, schema = @Schema()) @PathVariable("productId") String productId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {

            Product product = productService.retrieveProductById(productId);

            if (product != null) {
                return new ResponseEntity<Product>(product, HttpStatus.OK);
            } else {
                return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
    }

}
