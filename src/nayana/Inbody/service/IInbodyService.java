package nayana.Inbody.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import nayana.vo.InbodyVO;

public interface IInbodyService extends Remote{

	/**
	 * 회원아이디에 맞는 인바디 정보 가져오기
	 * @param memId
	 * @return
	 * @throws SQLException
	 */
	public InbodyVO callData(String memId) throws RemoteException;
	 
	/**
	 * 인바디 등록하는 메서드
	 * @author 김범휘
	 * @param 인바디VO
	 * @return 등록성공 : 1, 등록실패 : 0
	 * @throws RemoteException
	 */
	public int insertInbody(InbodyVO ibVO) throws RemoteException;
	
	public String getHeight(String mem_id) throws RemoteException;
	
	public String getWeight(String mem_id) throws RemoteException;
	
	public String getMuscle(String mem_id) throws RemoteException;
	
	public String getFat(String mem_id) throws RemoteException;
	
	public String getBmi(String mem_id) throws RemoteException;
	
	public String getFatRate(String mem_id) throws RemoteException;
	
	public String getAbdRate(String mem_id) throws RemoteException;
	
	public String getScore(String mem_id) throws RemoteException;
	
	public String getMbRate(String mem_id) throws RemoteException;
}
