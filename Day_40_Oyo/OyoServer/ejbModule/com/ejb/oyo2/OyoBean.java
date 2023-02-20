package com.ejb.oyo2;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * Session Bean implementation class OyoBean
 */
@Stateless
@Remote(OyoBeanRemote.class)
public class OyoBean implements OyoBeanRemote {

    /**
     * Default constructor. 
     */
    public OyoBean() {
        // TODO Auto-generated constructor stub
    }
    
    
	@Override
	public String addRoom(Room room) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		String roomId=roomIdGenerator();
		Transaction tx = session.beginTransaction();
		room.setRoomId(roomId);
		room.setStatus(Status.AVAILABLE);
		session.save(room);
		tx.commit();
		return "Room Added";
	}
	
	public String roomIdGenerator() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr=session.createCriteria(Room.class);
		List<Room> roomList=cr.list();
		if(roomList.size()==0) {
			return "R001";
		}
		int id=Integer.parseInt(roomList.get(roomList.size() - 1).getRoomId().substring(1));
		String rid=String.format("R%03d", ++id);
		return rid;
	}
	

}
