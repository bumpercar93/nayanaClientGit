package nayana.SelfTestInfo.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import nayana.vo.SelfTestInfoVO;

public interface ISelfTestInfoService extends Remote {
	
	public int insertSelfTestInfo(SelfTestInfoVO stiVO) throws RemoteException;
	
	public int updateSelfTestInfo(Map<String, Object> map) throws RemoteException;
	
	public int selectSelfTestInfo(Map<String, Object> map) throws RemoteException;
	
	public String getMyTestDate(Map<String, Object> map) throws RemoteException;
}
