package cn.realliu.htm.service.impl;

import cn.realliu.htm.common.bean.File;
import cn.realliu.htm.common.bean.Landlord;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.common.util.FtpUtil;
import cn.realliu.htm.common.util.SftpUtil;
import cn.realliu.htm.dao.LandlordDao;
import cn.realliu.htm.service.interfaces.LandlordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/21
 * @Time: 17:06
 * @Description：房东逻辑实现
 */
@Service
@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=true)
public class LandlordServiceImpl implements LandlordService {

    @Autowired
    private LandlordDao landlordDao;
    @Autowired
    private File file;

    /**
     * 通过用户id查找房东信息
     * @param userId 用户id
     * @return Landlord 房东实体
     * @throws CommonException
     */
    @Override
    public Landlord selectByUserId(Integer userId) throws CommonException {

        if (userId == 0){
            throw CommonException.getException(401);
        }

        Landlord landlord = landlordDao.selectByUserId(userId);

        if (landlord == null){
            throw  CommonException.getException(404);
        }

        return landlord;
    }

    /**
     * 通过用户id修改房东信息
     * @param landlord 房东实体
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void update(Landlord landlord) throws CommonException {
        if (StringUtils.isBlank(landlord.getLandlordName()) || StringUtils.isBlank(landlord.getLandlordSex()) ||
            StringUtils.isBlank(landlord.getLandlordBirth()) || StringUtils.isBlank(landlord.getLandlordAddr()) ||
            StringUtils.isBlank(landlord.getLandlordTel()) || StringUtils.isBlank(landlord.getLandlordMail()) ||
            StringUtils.isBlank(landlord.getLandlordWork())
        ){
            throw CommonException.getException(401);
        }

        landlordDao.update(landlord);
    }

    /**
     * 将图片上传到服务器
     * @param uploadFile 上传的文件
     * @return File 上传文件实体
     * @throws CommonException
     */
    @Override
    public File uploadPicture(MultipartFile uploadFile) throws CommonException, IOException {

        String filename = uploadFile.getOriginalFilename();
        String[] split = filename.split("\\.");

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

        String date = df.format(new Date());

        String newfilename = split[0]+date+"."+split[1];


        //sftp上传
        SftpUtil sftp = new SftpUtil("root", "=1996nkzx20", "47.100.119.240", 22);

        sftp.login();
        sftp.upload("/usr/share/nginx/html/images/",newfilename,uploadFile.getInputStream());
        sftp.logout();

        file.setCode(0);
        file.setMsg("上传成功");
        file.setTitle(newfilename);
        file.setFilename(filename);
        file.setUrl("/usr/share/nginx/html/images/"+newfilename);

        return file;
    }
}
