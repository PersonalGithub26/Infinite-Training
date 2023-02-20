package com.ejb.oyo2;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@SessionScoped
@ManagedBean(name = "rDao")
public class RoomDaoImp {
	
	private List<Room> showAvailRooms;
	

	




	public List<Room> getShowAvailRooms() {
		return showAvailRooms;
	}
	


	public void setShowAvailRooms(List<Room> showAvailRooms) {
		this.showAvailRooms = showAvailRooms;
	}


	public RoomDaoImp() throws NamingException
	{
		Room room = new Room();
		OyoBeanRemote remote = (OyoBeanRemote) new InitialContext().lookup("OyoBean/remote");
		this.showAvailRooms=remote.showAvailableRooms();
	}

}
