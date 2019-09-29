import DAO_things.DAOuser;
import org.junit.Assert;
import org.junit.Test;

public class DAOuserTest {
    DAOuser us = new DAOuser();

    @Test
    public void foundByID() {
        Assert.assertEquals("Akim", us.foundByID(3).getName());
    }

}