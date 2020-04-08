package LoginListAndMail.Registration.Hibernate;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("rawtypes")
public class RetunrnResponse 
{
	private ArrayList			      listResponse;
	private HashMap			      mapResponse;
	private Object			      objectResponse;
	
	public ArrayList getListResponse() 
	{
		return listResponse;
	}
	public void setListResponse(ArrayList listResponse) 
	{
		this.listResponse = listResponse;
	}
	
	public HashMap getMapResponse() 
	{
		return mapResponse;
	}
	public void setMapResponse(HashMap mapResponse) 
	{
		this.mapResponse = mapResponse;
	}
	
	public Object getObjectResponse() 
	{
		return objectResponse;
	}
	public void setObjectResponse(Object objectResponse) 
	{
		this.objectResponse = objectResponse;
	}
}
