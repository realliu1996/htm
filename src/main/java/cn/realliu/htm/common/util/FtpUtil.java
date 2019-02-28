package cn.realliu.htm.common.util;

import cn.realliu.htm.common.exception.CommonException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/2/26
 * @Time: 21:36
 * @Description：FTP上传的工具类
 */
public class FtpUtil {

    /**
     * 向FTP服务器上传文件
     * @param host FTP服务器hostname
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param filePath FTP服务器文件存放路径
     * @param filename 上传到FTP服务器上的文件名
     * @param input 输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String host, String username, String password, String filePath, String filename, InputStream input) throws CommonException {

        boolean result= false;
        FTPClient ftp = new FTPClient();

        try {

            ftp.connect(host);
            ftp.login(username,password);

            int reply = ftp.getReplyCode();

            if (!FTPReply.isPositiveCompletion(reply)){
                ftp.disconnect();
                return result;
            }

            //切换到上传目录
            if (!ftp.changeWorkingDirectory(filePath)){
                throw  CommonException.getException(407);
            }

            ftp.changeWorkingDirectory(filePath);

            String s = ftp.printWorkingDirectory();

            //设置上传文件的类型为二进制类型
            ftp.setFileType(FTP.BINARY_FILE_TYPE);


            ftp.enterLocalPassiveMode();

            //上传文件
            if (!ftp.storeFile(filename, input)) {
                return result;
            }

            input.close();
            ftp.logout();
            result = true;

        } catch (IOException e) {
            throw  CommonException.getException(408);
        }finally {

            if (ftp.isConnected()){
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    throw  CommonException.getException(406);
                }
            }
            return result;
        }
    }



}
