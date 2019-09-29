import DAO_things.DAOAccount;
import org.junit.Assert;
import org.junit.Test;

public class DAOAccountTest {
    DAOAccount ac = new DAOAccount();

    @Test
    public void allAccounts() {
        Assert.assertEquals(11, ac.allAccounts().size());
    }

    @Test
    public void totalBank() {
        Assert.assertEquals("6800", ac.totalBank());
    }

    @Test
    public void findRichest() {
        System.out.println(ac.findRichest());
    }

    @Test
    public void tableSummAcc() {
        ac.tableSummAcc();
    }
}