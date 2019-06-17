package nayana.MedicalReport.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import nayana.vo.MedicalReportVO;

public interface IMedicalReportService extends Remote {
	
	/**
	 * 소견서 등록하는 메서드
	 * @author 김범휘
	 * @param 소견서VO
	 * @return 등록성공 : 1, 등록실패 : 2
	 * @throws RemoteException
	 */
	public int insertMedicalReport(MedicalReportVO mrVO) throws RemoteException;
	
	public String getRegNo(String mem_id) throws RemoteException;
}
