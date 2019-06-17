package nayana.docDown.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import nayana.vo.DocDownVO;

public interface IDocDownService extends Remote {
	
	public int insertDocDown(DocDownVO ddVO) throws RemoteException;
	
	public int updateDocDown(Map<String, String> map) throws RemoteException;
	
	public String selectDocDown(Map<String, String> map) throws RemoteException;

}
