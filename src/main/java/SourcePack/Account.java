package SourcePack;

public class Account {
    int accountID;
    int account;
    int userID;

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", account=" + account +
                ", userID=" + userID +
                '}';
    }

    public Account(int accountID, int account, int userID) {
        this.accountID = accountID;
        this.account = account;
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
