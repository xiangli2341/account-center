package org.ml.accountcenter.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ml.accountcenter.entity.MlUser;

/**
 * MlUser的服务接口
 * 
 * @author 
 *
 */

@Mapper
public interface MlUserMapper {
	/**
	 * 通过MlUser的手机号获得MlUser对象
	 *
	 * @param userName
	 * @return
	 */
	@Select("SELECT * FROM ml_user WHERE userName=#{userName}")
    MlUser findByUserName(@Param("userName") String userName);


    /**
     * 通过MlUser的手机号查找是否注册
     *  查询为0，则为非注册
     *  查询非0，则为注册过
     *  返回int类型
     *
     * @param phoneNumber
     * @return
     */
    @Select("SELECT COUNT(*) FROM ml_user WHERE phone_Number=#{phoneNumber}")
    Integer findByPhoneNumber(@Param("phoneNumber") String phoneNumber);



    /**
     * 进行注册
     * @param mlUser
     * @return
     */
    @Insert("INSERT INTO ml_account_center.ml_user (username, PASSWORD, STATUS, remark, reg_time, phone_Number)\n" +
            "VALUES(#{username}, #{password}, #{status}, #{remark}, #{regTime}, #{phoneNumber})")
    Integer addUser(MlUser mlUser);



}
