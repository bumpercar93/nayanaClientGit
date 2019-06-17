package nayana.boardHealth.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import nayana.vo.BoardHealthVO;

public interface IBoardHealthService extends Remote {

	/**
	 * 전체 게시물을 출력하기 위해 게시글 리스트를 가져오는 메서드
	 * @author 박서경
	 * @return 전체 게시글 리스트
	 */
	public List<BoardHealthVO> getAllBoard() throws RemoteException;
	
	/**
	 * 게시물을 등록하기 위한 메서드
	 * @author 박서경
	 * @param vo 게시글의 속성을 담는 객체
	 * @return 1이면 insert 성공 / 0이면 insert 실패
	 * @throws SQLException
	 */
	public int insertBoard(BoardHealthVO vo) throws RemoteException;
	
	/**
	 * 게시글을 선택해서 조회하기 위한 메서드
	 * @author 박서경
	 * @param bh_seq 게시글 시퀀스
	 * @return 해당 게시글의 객체
	 * @throws SQLException
	 */
	public BoardHealthVO viewBoard(int bh_seq) throws RemoteException;
	
	/**
	 * 게시글 조회시 조회수를 1씩 증가 시키기 위한 메서드
	 * @author 박서경
	 * @param bh_seq 게시글 시퀀스
	 * @return 해당 게시글의 조회수
	 * @throws SQLException
	 */
	public int boardCnt(int bh_seq) throws RemoteException;
	
	
	/**
	 * 게시글을 수정하기위한 메서드
	 * @author 박서경
	 * @param vo 수정한 게시글의 속성을 담는 객체
	 * @return 1이상이면 update성공 / 0이면 update실패
	 * @throws SQLException
	 */
	public int updateBoard(BoardHealthVO vo) throws RemoteException;
	
	/**
	 * 게시글을 삭제하기 위한 메서드
	 * @author 박서경
	 * @param bh_seq 게시글 시퀀스
	 * @return 1이상이면 update성공 / 0이면 update실패 (게시글을 삭제하지 않고 숨길것)
	 * @throws SQLException
	 */
	public int deleteBoard(int bh_seq) throws RemoteException;
	
	/**
	 * 검색 키워드로 해당 키워드에 맞는 게시글의 리스트를 출력해주는 메서드
	 * @param params 검색할 키워드
	 * @return 검색한 게시물 리스트
	 * @throws SQLException
	 */
	public List<BoardHealthVO> searchBoard(String params) throws RemoteException;
	
	/**
	 * 첨부파일 테이블에 등록할 글의 시퀀스 값을 가져가기 위한 메서드
	 * @param params 시퀀스를 판별하기 위한 mem_id, title
	 * @return 현재 게시글의 시퀀스 값
	 * @throws SQLException
	 */
	public int getSeq(Map<String, String> params) throws RemoteException;
	
	/**
	 * 최근의 정보 가져오기
	 * @return
	 * @throws SQLException
	 */
	public List<BoardHealthVO> recentData() throws RemoteException;
}
