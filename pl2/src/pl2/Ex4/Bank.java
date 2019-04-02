/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2.Ex4;

import java.util.ArrayList;

/**
 *
 * @author Araújo
 */
public class Bank{

    private ArrayList<Account> list;

    public Bank() {
        list = new ArrayList<Account>();
    }

    public void addAccount(Account account) {
        list.add(account);
    }

    public boolean transferMoney(Account fromAcct,
            Account toAcct,
            EuroAmount amount,
            long timeout) {
        
        
        
        return true;
    }

}
