package org.ctjava.shipping.dao;

import java.util.List;
import org.ctjava.shipping.account.Account;

/**
 * Account DAO
 * @author rcuprak
 */
public interface AccountDao {
    
    void saveAccount(Account account);
    List<Account> getAccounts();
    
}
