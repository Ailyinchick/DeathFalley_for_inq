package SourcePack;

import java.util.Objects;

public class userWallet {
    public int cash;
    int userid;

    @Override
    public String toString() {
        return "userWallet{" +
                "cash=" + cash +
                ", userid=" + userid +
                '}';
    }

    public userWallet() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        userWallet that = (userWallet) o;
        return userid == that.userid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid);
    }

    public userWallet(int id) {
        this.userid = id;
        this.cash = 0;
    }

    public userWallet(int cash, int userid) {
        this.cash = cash;
        this.userid = userid;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
