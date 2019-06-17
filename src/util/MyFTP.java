package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class MyFTP {
	public void FtpDownLoad(String regNo1, String regNo2, String fileName) {
		
		FTPClient ftp = null;

		try {
			ftp = new FTPClient();
			ftp.setControlEncoding("UTF-8");
			ftp.connect("192.168.0.102");
			ftp.login("admin", "admin");
			
			File f2 = new File("D:\\MDMS\\" + regNo1 + "-" + regNo2);
			f2.mkdir();

			File f = new File("D:\\MDMS\\" + regNo1 + "-" + regNo2 + "\\", fileName);
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(f);
				boolean isSuccess = ftp.retrieveFile("/"+ regNo1 + "-" + regNo2 + "/" + fileName, fos);
				if (isSuccess) {
					// 다운로드 성공
					System.out.println("다운로드 성공");
				} else {
					// 다운로드 실패
					System.out.println("다운로드 실패");
				}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException ex) {
					}
				}
			}
			ftp.logout();
		} catch (SocketException e) {
			System.out.println("Socket:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		} finally {
			if (ftp != null && ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException e) {
				}
			}
		}
	}//FtpDownLoad
	
	public boolean myDataDownload(String regNo1, String regNo2, String fileName) {
		FTPClient mdms = null;
		boolean result = false;
		
		try {
			mdms = new FTPClient();
			mdms.setControlEncoding("UTF-8");
			mdms.connect("192.168.0.124");
			mdms.login("MDMS", "MDMS");
			
			File f2 = new File("c:\\NAYANA");
			f2.mkdir();
			
			File f = new File("c:\\NAYANA\\" + fileName);
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(f);
				boolean isSuccess = mdms.retrieveFile("/"+ regNo1 + "-" + regNo2 + "/" + regNo1 + "-" + regNo2 + "_" + fileName, fos);
				if (isSuccess) {
					// 다운로드 성공
					result = true;
				} else {
					// 다운로드 실패
					result = false;
				}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			} finally {
				if (fos != null)
					try {
						fos.close();
					} catch (IOException ex) {
					}
			}
			mdms.logout();
		} catch (SocketException e) {
			System.out.println("Socket:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		} finally {
			if (mdms != null && mdms.isConnected()) {
				try {
					mdms.disconnect();
				} catch (IOException e) {
				}
			}
		}
		return result;
	}
	
//	public int myDataAllDownload(String regNo1, String regNo2) {
//		FTPClient mdms = null;
//		int result = 0;
//		
//		try {
//			mdms = new FTPClient();
//			mdms.setControlEncoding("UTF-8");
//			mdms.connect("192.168.0.124");
//			mdms.login("MDMS", "MDMS");
//			
//			File fd = new File("c:\\NAYANA");
//			fd.mkdir();
//			
//			File f = new File("c:\\NAYANA\\진료확인서.xlsx");
//			FileOutputStream fos = null;
//			try {
//				fos = new FileOutputStream(f);
//				boolean isSuccess = mdms.retrieveFile("/"+ regNo1 + "-" + regNo2 + "/" + fileName, fos);
//				if (isSuccess) {
//					// 다운로드 성공
//					result = 1;
//				} else {
//					// 다운로드 실패
//					result = 0;
//				}
//			} catch (IOException ex) {
//				System.out.println(ex.getMessage());
//			} finally {
//				if (fos != null)
//					try {
//						fos.close();
//					} catch (IOException ex) {
//					}
//			}
//			mdms.logout();
//		} catch (SocketException e) {
//			System.out.println("Socket:" + e.getMessage());
//		} catch (IOException e) {
//			System.out.println("IO:" + e.getMessage());
//		} finally {
//			if (mdms != null && mdms.isConnected()) {
//				try {
//					mdms.disconnect();
//				} catch (IOException e) {
//				}
//			}
//		}
//		return result;
//	}
	
	public String[] FtpDirectoryRead(String path) {
		String[] result = null;
		FTPClient ftp = null;
		try {
			ftp = new FTPClient();
			
			ftp.setControlEncoding("UTF-8");
			ftp.connect("192.168.0.102");
			ftp.login("admin", "admin");
			
			FTPFile[] ftpFiles = ftp.listFiles(path);
			result = new String[ftpFiles.length];
			int cnt = 0;
			
			for (int i = 0; i < ftpFiles.length; i++) {
				if(ftpFiles[i].isFile()) {
					result[cnt] = ftpFiles[i].getName();
					cnt++;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String[] mdmsDirectoryRead(String path) {
		String[] result = null;
		FTPClient ftp = null;
		try {
			ftp = new FTPClient();
			
			ftp.setControlEncoding("UTF-8");
			ftp.connect("192.168.0.124");
			ftp.login("MDMS", "MDMS");
			
			FTPFile[] ftpFiles = ftp.listFiles(path);
			result = new String[ftpFiles.length];
			int cnt = 0;
			
			for (int i = 0; i < ftpFiles.length; i++) {
				if(ftpFiles[i].isFile()) {
					result[cnt] = ftpFiles[i].getName();
					cnt++;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
}
