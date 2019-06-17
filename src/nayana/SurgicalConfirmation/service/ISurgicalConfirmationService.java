package nayana.SurgicalConfirmation.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import nayana.vo.SurgicalConfirmationVO;

public interface ISurgicalConfirmationService extends Remote {
	
	/**
	 * 수술확인서 등록하는 메서드
	 * @author 김범휘
	 * @param 수술확인서VO
	 * @return 등록완료 : 1, 등록실패 : 0
	 * @throws RemoteException
	 */
	public int insertSurgicalConfirmation(SurgicalConfirmationVO scVO) throws RemoteException;
	
	public String getHzPart(String mem_id) throws RemoteException;
	
	public String getHzDate(String mem_id) throws RemoteException;
	
	public String getDgsName(String mem_id) throws RemoteException;
	
	public String getDgsCon(String mem_id) throws RemoteException;
	
	public String getOpDate(String mem_id) throws RemoteException;
	
	public String getDrName(String mem_id) throws RemoteException;
}
