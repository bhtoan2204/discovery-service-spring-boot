package gateway.productsservice.DataTransferObject;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

@Value
public class CreateProductDTO implements Serializable {
    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String title;

    @NotBlank(message = "Price is mandatory")
    @Min(value = 0, message = "Price must be greater than 0")
    private BigDecimal price;

    @NotBlank(message = "Quantity is mandatory")
    @Min(value = 0, message = "Quantity must be greater than 0")
    private Integer quantity;
}