package gateway.productsservice.Controller;

import gateway.productsservice.DataTransferObject.CreateProductDTO;
import gateway.productsservice.Command.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public ProductsController(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @GetMapping()
    public String getProducts() {
        return "Products Service running at port: " + env.getProperty("local.server.port");
    }

    @PostMapping
    public String createProduct(@RequestBody CreateProductDTO createProductDTO){
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(createProductDTO.getPrice())
                .quantity(createProductDTO.getQuantity())
                .title(createProductDTO.getTitle())
                .id(UUID.randomUUID().toString()).build();
        String returnValue = null;
        try {
            returnValue = commandGateway.sendAndWait(createProductCommand);
        }
        catch (Exception e) {
            returnValue = e.getLocalizedMessage();
        }

        return returnValue;
    }
}