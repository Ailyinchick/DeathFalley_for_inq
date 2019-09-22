import org.junit.Test;

import static org.junit.Assert.*;

public class DAOAccountTest {
    DAOAccount ac = new DAOAccount();
    @Test
    public void allAccounts() {
        System.out.println(ac.allAccounts());
    }

    @Test
    public void totalBank() {
        System.out.println("Total bank - "+ac.totalBank());
    }

    @Test
    public void findRichest() {
        System.out.println(ac.findRichest());
    }
}