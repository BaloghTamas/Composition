package hu.aut.example.composition.model;


public class Delivery implements Listable {
    private Long id;
    private String name;
    private String description;
    private String status;
    private String imageUrl;
    private String from;
    private String to;
    private boolean isReceive;
    private String when;
    private double fee;

    public Delivery(Long id, String name, String description, String status, String imageUrl, String from, String to, boolean isReceive, String when, double fee) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.imageUrl = imageUrl;
        this.from = from;
        this.to = to;
        this.isReceive = isReceive;
        this.when = when;
        this.fee = fee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public boolean isReceive() {
        return isReceive;
    }

    public void setReceive(boolean receive) {
        isReceive = receive;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
