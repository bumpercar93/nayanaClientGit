package nayana.SelfTest.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import nayana.vo.SelfTestVO;

public interface ISelfTestService extends Remote{
	
	public int insertSelfTest(SelfTestVO stVO) throws RemoteException;
	
	public int updateSelfTest(Map<String, Object> map) throws RemoteException;
	
	public int deleteSelfTest(int self_seq) throws RemoteException;
	
	public List<SelfTestVO> getAllSelfTest() throws RemoteException;
	
	public SelfTestVO getSelfTestVO(int self_seq) throws RemoteException;
	
	public int getSeq(Map<String, String> map) throws RemoteException;
	
}
