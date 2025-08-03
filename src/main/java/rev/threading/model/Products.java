package rev.threading.model;

import java.util.List;

public record Products(List<Product> products, int total, int skip, int limit) {}
