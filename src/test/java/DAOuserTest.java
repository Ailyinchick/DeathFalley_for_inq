import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DAOuserTest {
    DAOuser us = new DAOuser();

    @Test
    public void foundByID() {
        Assert.assertEquals("Akim", us.foundByID(3).getName());
    }

}