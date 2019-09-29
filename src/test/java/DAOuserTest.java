import DAO_things.DAOuser;
import SourcePack.Account;
import SourcePack.User;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import utils.HibernateSessionFactoryUtil;

public class DAOuserTest {
    DAOuser us = new DAOuser();


    @Test
    public void findAll() {
        System.out.println(us.findAll());
    }

    @Test
    public void foundByID() {
        Assert.assertEquals("Akim", us.foundByID(3).getName());
    }


}