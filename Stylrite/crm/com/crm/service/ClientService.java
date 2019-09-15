package com.crm.service;

import java.util.List;

import com.crm.pojo.Client;
import com.crm.pojo.ClientAddress;
import com.crm.pojo.ClientContactPerson;

public interface ClientService 
{

/*public  int addClient(Client client, ClientAddress caddress, ClientContactPerson cperson, String action);*/

public List getAllClientList();

public int addClient(Client client, String action);

public int addClientAddress(ClientAddress caddress, boolean isDefault);

public int addClientContactPerson(ClientContactPerson cperson, boolean isDefault);

public int updateClient(Client client, String action);

public int updateClientAddressDetails(ClientAddress caddress, String action, boolean isDefault);

public int updateClientContactDetail(ClientContactPerson cperson, String action, boolean isDefault);

public List getAllClientAddressList(String clientId);

public List getAllClientContactPersonList(String clientId);

public int addNewClientContactPersonDetails(ClientContactPerson cperson, String action, boolean isDefault);

public int addNewClientAddressDetails(ClientAddress caddress, String action, boolean isDefault);

public List getAllCustomerInfo(int rowNo);

}
