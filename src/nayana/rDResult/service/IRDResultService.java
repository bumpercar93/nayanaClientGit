package nayana.rDResult.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import nayana.vo.RDResultVO;

public interface IRDResultService extends Remote {
	
	/**
	 * 맞춤식단 결과를 모두 출력하는 메서드
	 * @author 박서경
	 * @return
	 * @throws RemoteException
	 */
	public List<RDResultVO> getAllList() throws RemoteException;
	
	/**
	 * 관리자에서 식단을 등록할 수 있는 메서드
	 * @author 박서경
	 * @param 관리자 맞춤식단 등록창에서 입력한 정보들을 담은 RDResultVO객체
	 * @return 현재 등록한 글의 시퀀스를 반환
	 * @throws RemoteException
	 */
	public int insertResult(RDResultVO rdrVo) throws RemoteException;
	
	/**
	 * 맞춤식단에서 선택한 결과를 가져오는 메서드
	 * @author 박서경
	 * @param 각 controller에서 선택한 3가지 코드들이 들어있는 메서드
	 * @return 
	 * @throws RemoteException
	 */
	public List<RDResultVO> rdResult(Map<String, String> map) throws RemoteException;
	
	/**
	 * 맞춤식단 업데이트 메서드
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public int updateResult(RDResultVO vo) throws RemoteException;
	
	public int getSeq(Map<String, String> map) throws RemoteException;
}
