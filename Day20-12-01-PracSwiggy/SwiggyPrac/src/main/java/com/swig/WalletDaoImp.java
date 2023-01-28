package com.swig;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "wDao")
@SessionScoped
public class WalletDaoImp implements WalletDAO{

	@Override
	public List<Wallet> showWallet(int custId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Wallet.class);
		cr.add(Restrictions.eq("custId", custId));
		List<Wallet> list = cr.list();
		
		return list;
	}

}
