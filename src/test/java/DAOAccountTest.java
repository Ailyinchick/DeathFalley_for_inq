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
        Assert.assertEquals("6400", ac.totalBank());
    }

    @Test
    public void findRichest() {
        Assert.assertEquals("Dima", ac.findRichest().getName());
    }

    @Test
    public void tableSummAcc() {
        ac.tableSummAcc();
    }
}