package gateway.productsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private Environment env;

    @GetMapping()
    public String getProducts() {
        return "Products Service running at port: " + env.getProperty("local.server.port");
    }
}