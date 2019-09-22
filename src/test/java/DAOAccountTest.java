import org.junit.Test;

import static org.junit.Assert.*;

public class DAOAccountTest {

    @Test
    public void allAccounts() {
        DAOAccount ac = new DAOAccount();
        System.out.println(ac.allAccounts());
    }
}