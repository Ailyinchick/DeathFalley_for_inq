import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DAOAccountTest {
    DAOAccount ac = new DAOAccount();

    @Test
    public void allAccounts() {
        Assert.assertEquals(10, ac.allAccounts().size());
    }

    @Test
    public void totalBank() {
        Assert.assertEquals("4900", ac.totalBank());
    }

    @Test
    public void findRichest() {
        Assert.assertEquals("Alex", ac.findRichest().getName());
    }
}