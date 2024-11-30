package gateway.productsservice.Command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Builder
@Value
public class CreateProductCommand {
    @TargetAggregateIdentifier
    private final String id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private final String title;

    @NotBlank(message = "Price is mandatory")
    @Min(value = 0, message = "Price must be greater than 0")
    private final BigDecimal price;

    @NotBlank(message = "Quantity is mandatory")
    @Min(value = 0, message = "Quantity must be greater than 0")
    private final Integer quantity;
}