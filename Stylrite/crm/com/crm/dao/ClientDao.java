package com.crm.dao;

import java.util.List;

import com.crm.pojo.Client;
import com.crm.pojo.ClientAddress;
import com.crm.pojo.ClientContactPerson;
import com.crm.pojo.DetailedClientInfo;

public interface ClientDao 
{

 public	List<DetailedClientInfo> getClientList();

public boolean addClient(Client client);

public boolean addClientAddress(ClientAddress caddress);

public boolean addClientContactPerson(ClientContactPerson cperson);

public boolean updateClient(Client client);

public boolean updateClientAddressDetails(ClientAddress caddress);

public boolean updateClientContactDetail(ClientContactPerson cperson);

public List getAllClientAddressList(String clientId);

public List getAllClientContactPersonList(String clientId);

public boolean addNewClientContactPersonDetails(ClientContactPerson cperson);

public boolean addNewClientAddressDetails(ClientAddress caddress);

public boolean updateIsDefaultOfClientContactPerson(String clientId);

public boolean updateIsDefaultOfClientAddress(String clientId);

public List getAllCustomerInfo(int rowNo);



}
