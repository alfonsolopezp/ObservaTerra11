package business.impl.employee;


import java.util.List;

import models.UploadDocs;
import models.User;
import models.exception.BusinessException;
import persistence.EmployeeFinder;
import business.impl.Command;

public class ListUploadDocs implements Command {


	 User user;

	 public ListUploadDocs(User user) {
	 this.user = user;
	 }

	@Override
	public Object execute() throws BusinessException {
		
		 List<UploadDocs> docs = EmployeeFinder.loadUpDocs(user);
		 return docs;

	}
}