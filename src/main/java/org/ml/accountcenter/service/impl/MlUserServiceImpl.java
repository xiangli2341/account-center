package org.ml.accountcenter.service.impl;

import org.ml.accountcenter.entity.MlUser;
import org.ml.accountcenter.mapper.MlUserMapper;
import org.ml.accountcenter.service.MlUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author RLY
 */
@Service
public class MlUserServiceImpl implements MlUserService {

    @Resource
    private MlUserMapper mlUserMapper;

    /**
     * demo 根据 userName查找个人信息
     * @param userName
     * @return
     */
    @Override
    public MlUser findByUserName(String userName) {
        return mlUserMapper.findByUserName(userName);
    }


    /**
     * 通过MlUser的手机号查找是否注册
     *  查询为0，则为非注册
     *  查询非0，则为注册过
     *  返回int类型
     * @param phoneNumber
     * @return
     */
    @Override
    public Integer findByPhoneNumber(String phoneNumber) {
        return mlUserMapper.findByPhoneNumber(phoneNumber);
    }
    /**
     * 注册
     * @param mlUser
     * @return
     */
    @Override
    public boolean addUser(MlUser mlUser) {
        boolean flag=false;
        try{
            mlUserMapper.addUser(mlUser);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }



}
