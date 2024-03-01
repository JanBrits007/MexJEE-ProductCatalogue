package za.co.nb.productcatalogue.service.substitution;

public class Banker extends Substitution {
    public Banker(String type) {
        setType(type);
    }

    @Override
    public String toString() {
        return "Banker{} " + super.toString();
    }
}
