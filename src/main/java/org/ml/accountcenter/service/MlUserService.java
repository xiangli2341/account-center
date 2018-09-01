package org.ml.accountcenter.service;


import org.ml.accountcenter.entity.MlUser;


/**
 * @author RLY
 */
public interface MlUserService {
    /**
     *  demo 根据 userName查找个人信息
     * @param userName
     * @return
     */
	MlUser findByUserName(String userName);


    /**
     * 通过MlUser的手机号查找是否注册
     *  查询为0，则为非注册
     *  查询非0，则为注册过
     *  返回int类型
     * @param phoneNumber
     * @return
     */
    Integer findByPhoneNumber(String phoneNumber);


    /**
     * 注册
     * @param mlUser
     * @return
     */
    boolean addUser(MlUser mlUser);
}
