package nayana.Prescription.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import nayana.vo.PrescriptionVO;

public interface IPrescriptionService extends Remote{
	
	/**
	 * 처방전 등록하는 메서드
	 * @author 김범휘
	 * @param 처방전VO
	 * @return 등록성공 : 1, 등록실패 : 0
	 * @throws RemoteException
	 */
	public int insertPrescription(PrescriptionVO pVO) throws RemoteException;
	
	public String getMedicine(String mem_id) throws RemoteException;
	
	public String getDosesMedi(String mem_id) throws RemoteException;
	
	public String getDosesNum(String mem_id) throws RemoteException;
	
	public String getAllDosesDay(String mem_id) throws RemoteException;
	
	public String getUsage(String mem_id) throws RemoteException;
	
}
