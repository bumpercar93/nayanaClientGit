package nayana.boardNotice.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import nayana.vo.BoardNoticeVO;

public interface IBoardNoticeService extends Remote {

	/**
	 * BoardNoticeVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @author 김경호
	 * @param BoardNoticeVO DB에 insert할 자료가 저장된 BoardNoticeVO객체
	 * @return 작업성공 : 1 , 작업실패 : 0
	 */
	public int insertBoard(BoardNoticeVO noticevo) throws RemoteException;
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글 정보를 삭제하는 메서드
	 * @author 김경호
	 * @param bn_seq 삭제할 게시글 번호
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int deleteBoard(int bn_seq) throws RemoteException;
	
	/**
	 * 하나의 BoardNoticeVO자료를 이용하여 DB에 update하는 메서드
	 * @author 김경호
	 * @param BoardNoticeVO update할 게시글 정보가 들어있는 BoardNoticeVO객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int updateBoard(BoardNoticeVO noticevo) throws RemoteException;
	
	/**
	 * DB의 board_notice테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드
	 * @author 김경호
	 * @return BoardNoticeVO객체가 담긴 List객체
	 */
	public List<BoardNoticeVO> getAllBoardList() throws RemoteException;
	
	/**
	 * 게시글 제목을 이용하여 게시글을 검색하여 검색된 결과를 List에 담아서 반환하는 메서드
	 * @author 김경호
	 * @param bn_title 검색할 게시글 제목
	 * @return 검색한 결과를 담은 List객체
	 */
	public List<BoardNoticeVO> getSearchBoardList(Map<String, String> bn_title) throws RemoteException;
	
	/**
	 * 게시글 번호를 매개변수로 받아서 그 게시글 정보를 가져와 반환하는 메서드
	 * @author 김경호
	 * @param bn_seq 가져올 게시글 번호
	 * @return 게시글 번호에 맞는 자료가 있으면 해당 게시글 정보를 담고 있는
	 * 		   JdbcBoardVO객체, 자료가 없으면 null
	 */
	public BoardNoticeVO getBoard(int bn_seq) throws RemoteException;
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글의 조회수를 증가시키는 메서드
	 * @author 김경호
	 * @param bn_seq 조회수를 등가할 게시글 번호
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int setCountIncrement(int bn_seq) throws RemoteException;
	
}
