package com.jsf.lib;

import java.util.List;

public interface LibraryDAO {
	
	List<Books> searchBooks();
	public String authenticate(LibUsers libUsers);

}
