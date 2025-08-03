package rev.threading.model;

import java.util.List;

public record Product(
    int id,
    String title,
    String description,
    String category,
    double price,
    double discountPercentage,
    double rating,
    int stock,
    List<String> tags,
    String sku,
    int weight,
    Dimensions dimensions,
    String warrantyInformation,
    String shippingInformation,
    String availabilityStatus,
    List<Review> reviews,
    String returnPolicy,
    int minimumOrderQuantity,
    Meta meta,
    List<String> images,
    String thumbnail) {}
