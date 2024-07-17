package com.hugodev.ApiGraphQL.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductRequest(String name, BigDecimal price, UUID categoryId) {
}
