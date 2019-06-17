package nayana.myFile.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import nayana.vo.MyFileVO;

public interface IMyFileService extends Remote{
	
	/**
	 * 첨부파일 리스트를 가져오는 메서드
	 * @author 박서경
	 * @return 첨부파일 리스트
	 * @throws SQLException
	 */
	public List<MyFileVO> getAllList() throws RemoteException;
	
	/**
	 * 첨부파일 속성을 담은 객체를 insert하는 메서드
	 * @param vo 첨부파일 속성을 담은 객체
	 * @return 1이면 insert 성공 / 0이면 insert 실패
	 * @throws SQLException
	 */
	public int insertFile(MyFileVO vo) throws RemoteException;
	
	/**
	 * 첨부파일 속성을 담을 객체를 update하는 메서드
	 * @param vo 첨부파일 속성을 담은 객체
	 * @return
	 * @throws SQLException
	 */
	public int updateFile(MyFileVO vo) throws RemoteException;
	
	public MyFileVO getFileName(Map<String, Object> map) throws RemoteException;
}
