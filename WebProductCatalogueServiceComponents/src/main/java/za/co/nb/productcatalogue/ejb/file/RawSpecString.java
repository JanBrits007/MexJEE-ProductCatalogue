package za.co.nb.productcatalogue.ejb.file;

public class RawSpecString {

    private boolean juristic;
    private String xmlString;

    public RawSpecString(boolean juristic, String xmlString) {
        this.juristic = juristic;
        this.xmlString = xmlString;
    }

    public boolean isJuristic() {
        return juristic;
    }

    public void setJuristic(boolean juristic) {
        this.juristic = juristic;
    }

    public String getXmlString() {
        return xmlString;
    }

    public void setXmlString(String xmlString) {
        this.xmlString = xmlString;
    }
}
