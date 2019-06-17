package nayana.SelfTestResult.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import nayana.vo.SelfTestResultVO;

public interface ISelfTestResultService extends Remote {
	
	public int insertSelfTestResult(SelfTestResultVO strVO) throws RemoteException;
	
	public int updateSelfTestResult(Map<String, Object> map) throws RemoteException;
	
	public String selectSelfTestResult(Map<String, Integer> map) throws RemoteException;
}
