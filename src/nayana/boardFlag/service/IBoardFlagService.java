package nayana.boardFlag.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import nayana.vo.BoardFlagVO;

public interface IBoardFlagService extends Remote{
	
	/**
	 * 게시판 구분할 수 있는 리스트를 가져오는 메서드
	 * @author 박서경
	 * @return 게시판 구분을 할수 있는 리스트
	 */
	public List<BoardFlagVO> getAllList() throws RemoteException;
}
