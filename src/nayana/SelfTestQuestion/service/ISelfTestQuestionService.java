package nayana.SelfTestQuestion.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import nayana.vo.SelfTestQuestionVO;

public interface ISelfTestQuestionService extends Remote{
	
	public int insertSelfTestQuestion(SelfTestQuestionVO stqVO) throws RemoteException;
	
	public int updateSelfTestQuestion(Map<String, Object> map) throws RemoteException;
	
	public List<String> getAllSelfTestQuestion(int self_seq) throws RemoteException;
	
}
