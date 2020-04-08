package Login.Registration.ListAndMail;

import Login.Registration.Model.Users;
import LoginListAndMail.Registration.Hibernate.RetunrnResponse;

public interface RegistrationDAO 
{
	public Boolean insertUser(Users user) throws Exception;
	public Users getUser(String userName, String password) throws Exception;
	public RetunrnResponse getUserList() throws Exception;
	public RetunrnResponse getUsersById(Long userId) throws Exception;
}
