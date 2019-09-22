import java.util.List;

public interface DAOinterface {
User foundByID(int id);
List<Account> allAccounts();
}
