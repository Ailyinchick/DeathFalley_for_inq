package DAO_things;

import SourcePack.Account;
import SourcePack.User;

import java.util.List;

public interface DAOinterface {
    User foundByID(int id);

    List<Account> allAccounts();
}

