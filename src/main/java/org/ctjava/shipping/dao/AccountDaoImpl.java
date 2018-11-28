package org.ctjava.shipping.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.ctjava.shipping.account.Account;

/**
 *
 * @author rcuprak
 */
public class AccountDaoImpl implements AccountDao {
    
    /**
     * Entity Manager
     */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Saves a new account
     * @param account 
     */
    @Override
    public void saveAccount(Account account) {
        em.persist(account);
    }
    
    /**
     * Returns a list of all of the accounts
     * @return accounts
     */
    @Override
    public List<Account> getAccounts() {
        TypedQuery<Account> tq = em.createQuery("SELECT a FROM Account a",Account.class);
        return tq.getResultList();
    }   
}
