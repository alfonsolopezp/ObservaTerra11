package persistence;

import java.util.List;

import persistence.util.Jpa;
import models.UploadDocs;
import models.User;

public class EmployeeFinder {

	@SuppressWarnings("unchecked")
	public static List<UploadDocs> loadUpDocs(User user) {
		return Jpa.getManager().createNamedQuery("User.listUploads")
				.setParameter(1, user.getId()).getResultList();
	}

}
