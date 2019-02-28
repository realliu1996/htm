package cn.realliu.htm.common.util;

import cn.realliu.htm.common.exception.CommonException;
import com.jcraft.jsch.*;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/2/27
 * @Time: 10:22
 * @Description：SFTP上传的工具类
 */
public class SftpUtil {

    //获取sftp对象
    private ChannelSftp sftp;
    private Session session;
    //FTP登录用户名
    private String username;
    //FTP登录密码
    private String password;
    //FTP服务器地址IP地址
    private String host;
    //FTP 端口
    private int port;

    public SftpUtil(){}

    /**
     * 构造基于密码认证的sftp对象
     * @param username
     * @param password
     * @param host
     * @param port
     */
    public SftpUtil(String username, String password, String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    /**
     * 连接sftp服务器
     */
    public void login() throws CommonException{

        try {

            JSch jSch = new JSch();

            session = jSch.getSession(username, host, port);

            if (password !=null){
                session.setPassword(password);
            }

            Properties config = new Properties();

            config.put("StrictHostKeyChecking","no");
            session.setConfig(config);
            session.connect();

            Channel channel = session.openChannel("sftp");

            channel.connect();

            sftp = (ChannelSftp) channel;

        }catch (Exception e){
            e.printStackTrace();
            throw CommonException.getException(409);
        }
    }

    /**
     * 关闭sftp连接
     */
    public void logout(){
        if (sftp != null){
            if (sftp.isConnected()){
                sftp.disconnect();
            }
        }

        if (session !=null){
            if (session.isConnected()){
                session.disconnect();
            }
        }
    }

    /**
     * 将输入流的数据上传到sftp作为文件
     * @param directory  上传到该目录
     * @param sftpFileName  sftp端文件名
     * @param input 输入流
     * @throws SftpException
     * @throws Exception
     */
    public void upload(String directory, String sftpFileName, InputStream input) throws CommonException {

        try {
            sftp.cd(directory);
            sftp.put(input,sftpFileName);
        } catch (SftpException e) {
            throw CommonException.getException(407);
        }
    }


}
