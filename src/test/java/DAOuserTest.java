import org.junit.Test;

import static org.junit.Assert.*;

public class DAOuserTest {

    @Test
    public void foundByID() {
        DAOuser us = new DAOuser();
        System.out.println(us.foundByID(7));
    }
}