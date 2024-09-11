package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public record Product(int productId, String name, double price, int quantity ) {

}
