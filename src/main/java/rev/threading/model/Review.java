package rev.threading.model;

public record Review(
    int rating, String comment, String date, String reviewerName, String reviewerEmail) {}
