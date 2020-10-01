package za.co.nb.productcatalogue.ejb.substitution;

public abstract class Substitution {

    private  String type;
    private  String productId;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Substitution{" +
                "type='" + type + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}
