package za.co.nb.productcatalogue.ejb;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DynamicPropertyBeanTest {

    DynamicPropertyBean bean;


    @Before
    public void init(){
        bean = new DynamicPropertyBean();
    }

    @Test
    public void parserTest(){

        String placeHolder ="${{property}}";
        String property = bean.parseProperty(placeHolder);
        Assert.assertNotEquals(!property.contains("{"), property.contains("{"));
        Assert.assertNotEquals(!property.contains("}"), property.contains("}"));
    }
}