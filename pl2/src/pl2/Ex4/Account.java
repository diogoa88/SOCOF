/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2.Ex4;

/**
 *
 * @author Araújo
 */
public class Account extends Thread{
    
    private int AccountId;
    
    public EuroAmount amount;

    public Account(int AccountId, EuroAmount amount) {
        this.AccountId = AccountId;
        this.amount = amount;
    }

    public void credit(int amountValue){
        int amount = this.amount.getAmount();
        amount += amountValue;
        this.amount.setAmount(amount);
    }
    
        public void debit(int amountValue){
        int amount = this.amount.getAmount();
        amount -= amountValue;
        this.amount.setAmount(amount);
    }
    
}
