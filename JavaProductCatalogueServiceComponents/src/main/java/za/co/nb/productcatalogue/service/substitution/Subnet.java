package za.co.nb.productcatalogue.service.substitution;

public class Subnet extends Substitution {
    public Subnet(String type) {
        setType(type);
    }

    @Override
    public String toString() {
        return "Subnet{} " + super.toString();
    }
}
