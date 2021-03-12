package za.co.nb.productcatalogue.dao.dto;

import java.util.Date;

public class CachedCatalogueDetails {
    private String catalogueContent;
    private Date cacheDateTime;

    public String getCatalogueContent()
    {
        return catalogueContent;
    }

    public void setCatalogueContent(String catalogueContent)
    {
        this.catalogueContent = catalogueContent;
    }

    public Date getCacheDateTime()
    {
        return cacheDateTime;
    }

    public void setCacheDateTime(Date cacheDateTime)
    {
        this.cacheDateTime = cacheDateTime;
    }

}
