package com.java.bank;

import java.sql.SQLException;
import java.util.List;

public interface BankDAO {

	String createAccount(Bank bank) throws SQLException, ClassNotFoundException;
	Bank searchAccount(int accountNo) throws ClassNotFoundException, SQLException;
	String closeAccount(int accountNo) throws ClassNotFoundException, SQLException;
	String depositAccount(int accountNo, int depositAmount) throws ClassNotFoundException, SQLException;
	String withdrawAccount(int accountNo, int withdrawAmount) throws ClassNotFoundException, SQLException;
	Transaction getMiniStatement(int accountNo) throws SQLException, ClassNotFoundException;
}
