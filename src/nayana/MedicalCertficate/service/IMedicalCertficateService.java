package nayana.MedicalCertficate.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import nayana.vo.MedicalCertificateVO;

public interface IMedicalCertficateService extends Remote {
	/**
	 * 진단서 등록하는 메서드
	 * @author 김범휘
	 * @param 진단서VO
	 * @return 등록 성공 : 1, 등록 실패 : null;
	 * @throws RemoteException
	 */
	public int insertMedcalCertficate(MedicalCertificateVO mcVO) throws RemoteException;
	
	public String getName(String mem_id) throws RemoteException;
	
	public String getGender(String mem_id) throws RemoteException;
	
	public String getAge(String mem_id) throws RemoteException;
	
	public String getAddr(String mem_id) throws RemoteException;
	
	public String getTel(String mem_id) throws RemoteException;
	
	public String getDssName(String mem_id) throws RemoteException;
	
	public String getAfterOpinion(String mem_id) throws RemoteException;
	
	public String getOnsetDate(String mem_id) throws RemoteException;
	
}
