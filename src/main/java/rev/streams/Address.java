package rev.streams;

import java.util.Objects;

/** Address record */
public record Address(String street, String city, String state, String zipCode, String country) {
  public Address {
    Objects.requireNonNull(city, "City cannot be null");
    Objects.requireNonNull(country, "Country cannot be null");
  }
}
