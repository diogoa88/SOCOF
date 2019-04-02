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
public class Ex4 {
    
    public static void run(){
        Bank bank = new Bank();
        int nAccounts = 100;
        for (int i = 0; i < nAccounts; i++) {  
            EuroAmount amount = new EuroAmount((int)(Math.random() * 100000 + 1));
            Account account = new Account(i,amount);
            
        }
    }

        
    
}
