package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.model.BankAccount;
import com.revature.model.BankUser;
import com.revature.util.HibernateConnectionUtil;

public class BankDaoImpl implements Dao {

	public BankUser getBankUserById(BankUser user) {
		/*
		 * Get a session and use that session to retrieve an object(table record)
		 */
		Session session = HibernateConnectionUtil.getSession();

		BankUser returnedUser = (BankUser) session.get(BankUser.class, 30);

		/*
		 * calling a 2nd time with the same primary key will result in pulling the
		 * record from level 1 cache, the session cache, not hitting the database a 2nd
		 * time BankUser returnedUser2 = (BankUser) session.get(BankUser.class, 1);
		 */
		session.close();

		return returnedUser;
	}

	public void createUser(BankUser user) {

		/*
		 * Hibernate Objects (pojos) have 3 states -transient: the pojo has never been
		 * connected to the database (in this method) -persistent: the pojo is currently
		 * in a connection with the database -detached: the pojo was connected but is no
		 * longer
		 */

		Session session = HibernateConnectionUtil.getSession();

		// About to do a change to the database? start a tansaction
		Transaction tx = session.beginTransaction();

		// save - insert/create NOT update
		session.save(user); // the user pojo is now in the persistent state after this line of execution

		// Automatic Dirty Checking:
		// The benefit of an object being in the persistent state,
		// Hibernate will compare the Java Object to the Table Record and update the
		// table record
		// if the two don't match
		user.setFirstName("I HAVE CHANGED!");

		// commit
		tx.commit();

		session.close(); // now the user pojo has lost the connection and is considered detached
		System.out.println(user);
	}

	public BankAccount getBankAccountById(BankAccount account) {

		Session session = HibernateConnectionUtil.getSession();
		System.out.println(account.getBaNumber());
		BankAccount returnedAccount = (BankAccount) session.get(BankAccount.class, account.getBaNumber());
		System.out.println(returnedAccount);
		session.close();

		return returnedAccount;
	}

	public BankUser getBankUserByGetOrLoad() {
		Session session = HibernateConnectionUtil.getSession();
		/*
		 * get() returns null if the record isn't found load() returns
		 * ObjectNotFoundException if the record isn't found
		 * 
		 * get() directly hits the database as it is called load() will create a proxy
		 * object first, then hit the database when needed
		 */
		// BankUser user = (BankUser) session.get(BankUser.class, 150);
		BankUser user = (BankUser) session.load(BankUser.class, 1); // its "lazy" but is not a strategy

		// System.out.println(user.getClass() + ": is this the bank user class?");
		System.out.println(user.getUsername() + ": bankuser");

		session.close();

		return user;
	}

	@SuppressWarnings("unchecked")
	public List<BankUser> getBankUsersByUsingCriteria() {
		// Criteria is a READ-ONLY API, read as in the the CRUD read
		Session session = HibernateConnectionUtil.getSession();

		Criteria crit = session.createCriteria(BankUser.class);
		crit.add(Restrictions.and(Restrictions.isNotNull("lastName"), Restrictions.ilike("firstName", "mary")));
		List<BankUser> userList = crit.list();

		return userList;
	}

	public BankUser updateVsMerge() {
//		BankUser john = new BankUser(2, "john1", "123", "jupdate1", "jj");
//		BankUser john2 = new BankUser(2, "john2", "123", "jmerge2", "jj");
//
//		Session session = HibernateConnectionUtil.getSession();
//
//		Transaction tx = session.beginTransaction();
//
//		/*
//		 * update - brings the object passed in, into the persistent state
//		 * 
//		 * merge - doesn't change the hibernate state of the object passed in but copies
//		 * the variable states onto another object that is in the hibernate persistent
//		 * state *Note* if there isn't an object in the persistent state, hibernate will
//		 * fetch from the database and instantiate one
//		 * 
//		 * 
//		 * org.hibernate.NonUniqueObjectException with there is another object with the
//		 * same id
//		 * 
//		 * User merge to update already persistent org.hibernate.ObjectNotFoundException
//		 * 
//		 */
//		BankUser anotherJohn = (BankUser) session.merge(john2);
//		session.update(john);
//		anotherJohn.setFirstName("another john");
//		System.out.println(john);
//
//		System.out.println("--------BEFORE COMMIT------------");
//
//		tx.commit();
//
//		System.out.println("---------AFTER COMMIT------------");
//
//		session.close();
//
		return null;
	}

	public static void main(String[] args) {
		new BankDaoImpl().updateVsMerge();
	}

}