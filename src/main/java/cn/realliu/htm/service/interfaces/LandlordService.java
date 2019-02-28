package cn.realliu.htm.service.interfaces;

import cn.realliu.htm.common.bean.File;
import cn.realliu.htm.common.bean.Landlord;
import cn.realliu.htm.common.exception.CommonException;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/21
 * @Time: 17:04
 * @Description：房东逻辑接口
 */
public interface LandlordService {

    /**
     * 通过用户id查找房东信息
     * @param userId 用户id
     * @return Landlord 房东实体
     * @throws CommonException
     */
    Landlord selectByUserId(Integer userId) throws CommonException;

    /**
     * 通过用户id修改房东信息
     * @param landlord 房东实体
     * @throws CommonException
     */
    void update(Landlord landlord) throws CommonException;

    /**
     * 将图片上传到服务器
     * @param uploadFile 上传的文件
     * @return File 上传文件实体
     * @throws CommonException
     */
    File uploadPicture(MultipartFile uploadFile) throws CommonException,Exception;

}
