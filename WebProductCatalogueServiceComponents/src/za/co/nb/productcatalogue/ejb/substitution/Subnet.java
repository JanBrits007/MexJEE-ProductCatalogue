package za.co.nb.productcatalogue.ejb.substitution;

public class Subnet extends Substitution {
    public Subnet(String type) {
        setType(type);
    }

    @Override
    public String toString() {
        return "Subnet{} " + super.toString();
    }
}
