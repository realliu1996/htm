package cn.realliu.htm.service.impl;

import cn.realliu.htm.common.bean.Agency;
import cn.realliu.htm.common.bean.Landlord;
import cn.realliu.htm.common.bean.Tenant;
import cn.realliu.htm.common.bean.User;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.dao.AgencyDao;
import cn.realliu.htm.dao.LandlordDao;
import cn.realliu.htm.dao.TenantDao;
import cn.realliu.htm.dao.UserDao;
import cn.realliu.htm.service.interfaces.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/15
 * @Time: 15:12
 * @Description：用户逻辑实现
 */
@Service
@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private TenantDao tenantDao;
    @Autowired
    private LandlordDao landlordDao;
    @Autowired
    private AgencyDao agencyDao;
    @Autowired
    private Tenant tenant;
    @Autowired
    private Landlord landlord;
    @Autowired
    private Agency agency;

    /**
     * 新增用户
     * @param user 用户信息
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void insertUser(User user) throws CommonException {

        if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getUserRole()) || StringUtils.isBlank(user.getUserPassword())){
            throw CommonException.getException(401);
        }

        userDao.insert(user);

        if ("租客".equals(user.getUserRole())) {
            tenant.setUserId(user.getUserId());
            tenant.setTenantNick(user.getUserName());
            tenant.setRole(user.getUserRole());
            tenant.setStatus("E");
            tenantDao.insert(tenant);
        }else if ("房东".equals(user.getUserRole())) {
            landlord.setUserId(user.getUserId());
            landlord.setLandlordNick(user.getUserName());
            landlord.setRole(user.getUserRole());
            landlord.setStatus("E");
            landlordDao.insert(landlord);
        }else if ("中介".equals(user.getUserRole())) {
            agency.setUserId(user.getUserId());
            agency.setAgencyNick(user.getUserName());
            agency.setRole(user.getUserRole());
            agency.setStatus("E");
            agencyDao.insert(agency);
        }else {
            throw CommonException.getException(406);
        }

    }

    /**
     * 通过用户账号，密码查询用户
     * @param userName 用户名
     * @param userPassword 用户密码
     * @return User 用户实体
     * @throws CommonException
     */
    @Override
    public User selectByNamePassword(String userName, String userPassword) throws CommonException {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(userPassword)){
            throw CommonException.getException(401);
        }

        User user = userDao.selectByNamePassword(userName, userPassword);

        if (user == null){
            throw  CommonException.getException(402);
        }

        return user;

    }

    /**
     * 通过用户账号查询用户
     * @param userName 用户名
     * @return User 用户实体
     * @throws CommonException
     */
    @Override
    public User selectByUserName(String userName) throws CommonException{

        if (StringUtils.isBlank(userName)){
            throw CommonException.getException(401);
        }

        User user = userDao.selectByUserName(userName);

        return user;

    }
}
