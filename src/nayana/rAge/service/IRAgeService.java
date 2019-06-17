package nayana.rAge.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import nayana.vo.RAgeVO;

public interface IRAgeService extends Remote{
	
	/**
	 * 맞춤식단에서 나이별 컬럼을 모두 가져오는 메서드
	 * @author 박서경
	 * @return RAgeVO 리스트
	 * @throws SQLException
	 */
	public List<RAgeVO> getAllList() throws RemoteException;
	
	/**
	 * 나이 선택 메서드
	 * @author 박서경
	 * @param ra_code_age
	 * @return
	 * @throws SQLException
	 */
	public String ageCode(String ra_code_age) throws RemoteException;
}
