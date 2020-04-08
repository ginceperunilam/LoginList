package Login.Registration.ListAndMail;

import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;

import Login.Registration.Model.TablesDet;
import Login.Registration.Model.Users;
import LoginListAndMail.Registration.Hibernate.HibernateUtil;
import LoginListAndMail.Registration.Hibernate.RetunrnResponse;

public class RegistrationDAOImpl implements RegistrationDAO
{
	@Override
	public Boolean insertUser(Users user) throws Exception 
	{
		Session session = null;
		Transaction tr = null;
		try 
		{
			SessionFactory sessFact = HibernateUtil.getSessionFactory();
			session = sessFact.getCurrentSession();
			tr = session.beginTransaction();
			session.save(user);
			tr.commit();
			return true;
		} 
		catch (Exception e)
		{
			tr.rollback();
			System.out.println("Failed insertUser in RegistrationDAOImpl :"+e);
			throw e;
 		}
		finally
		{
			session.close();
		}
	}

	@Override
	public Users getUser(String userName, String password) throws Exception 
	{
		Users users = new Users();
		Session session = null;
		Transaction tr = null;
		try 
		{
			SessionFactory sessFact = HibernateUtil.getSessionFactory();
			session = sessFact.getCurrentSession();
			
			tr = session.beginTransaction();
			
//			users = session.get(Users.class, 1l);
			System.out.println("RegistrationDAOImpl getUser 1");
			
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.eq("userName", userName));
			criteria.add(Restrictions.eq("password", password));
			criteria.setMaxResults(1);
			users=(Users)criteria.uniqueResult();
			
			tr.commit();
		} 
		catch (Exception e) 
		{
			System.out.println("Failed getUser in RegistrationDAOImpl :"+e);
			throw e;		
		}
		finally
		{
			session.close();
		}
		return users;
	}

	@Override
	public RetunrnResponse getUserList() throws Exception 
	{
		ArrayList<TablesDet> tablesDets = new ArrayList<TablesDet>();
		HashMap<String, ArrayList> map = new HashMap<String, ArrayList>();
		RetunrnResponse response = new RetunrnResponse();
		Session session = null;
		Transaction tr = null;
		try 
		{
			SessionFactory sessFact = HibernateUtil.getSessionFactory();
			session = sessFact.getCurrentSession();
			
			tr = session.beginTransaction();
			
			System.out.println("RegistrationDAOImpl getUserList 1");
			
			Criteria criteria = session.createCriteria(TablesDet.class);
			criteria.add(Restrictions.eq("tablesId", 3l));
			criteria.add(Restrictions.eq("showInList", "Y"));
			criteria.addOrder(Order.asc("listOrder"));
			tablesDets = (ArrayList<TablesDet>) criteria.list();
			System.out.println("RegistrationDAOImpl getUserList 2:"+tablesDets.size());
			
			criteria = session.createCriteria(Users.class);
			ProjectionList projections = Projections.projectionList();
			projections.add(Projections.property("id").as("id"));
			for(TablesDet tablesDet : tablesDets)
			{
				String name = tablesDet.getName();
				String propertyname = name.replaceAll("_", "");
				propertyname = propertyname.replaceFirst(propertyname.substring(0,1), propertyname.substring(0,1).toLowerCase());

				projections.add(Projections.property(propertyname).as(propertyname));
			}
			 criteria.setProjection(projections);
			 criteria.setResultTransformer(new AliasToBeanResultTransformer(Users.class));
			 
			 ArrayList<Users> users = (ArrayList<Users>) criteria.list();
			 System.out.println("RegistrationDAOImpl getUserList 3:"+users);
			 
			 System.out.println("RegistrationDAOImpl grid jsp class 3:"+users);
			 System.out.println("RegistrationDAOImpl grid jsp response.getListResponse() 3:"+response.getListResponse());
			 
			 map.put("listValues", users);
			 map.put("tableValues", tablesDets);
			 response.setMapResponse(map);
			 
			tr.commit();
		} 
		catch (Exception e) 
		{
			System.out.println("Failed getUserList in RegistrationDAOImpl :"+e);
			throw e;		
		}
		finally
		{
			session.close();
		}
		return response;
	}

	@Override
	public RetunrnResponse getUsersById(Long userId) throws Exception 
	{
		Users users = new Users();
		RetunrnResponse retunrnResponse = new RetunrnResponse();
		Session session = null;
		Transaction tr = null;
		try 
		{
			SessionFactory sessFact = HibernateUtil.getSessionFactory();
			session = sessFact.getCurrentSession();
			
			tr = session.beginTransaction();
			
//			users = session.get(Users.class, 1l);
			System.out.println("RegistrationDAOImpl getUsersById 1");
			
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.eq("id", userId));
			criteria.setMaxResults(1);
			users=(Users)criteria.uniqueResult();
			
			tr.commit();
			retunrnResponse.setObjectResponse(users);
		} 
		catch (Exception e) 
		{
			System.out.println("Failed getUser in getUsersById :"+e);
			throw e;		
		}
		finally
		{
			session.close();
		}
		return retunrnResponse;
	}

}
