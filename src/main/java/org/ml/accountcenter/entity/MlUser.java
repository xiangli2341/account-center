package org.ml.accountcenter.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ml_user实体类
 * 使用lombok省略getter/setter方法
 * @author 
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MlUser {
	/**用户id,自增*/
	private Integer id; 
	/**用户名*/
	private String username; 
	/**密码*/
	private String password; 
	/**是否可用：1可,0不可*/
	private Integer status; 
	/**手机型号(枚举说明)*/
	private Integer phoneType; 
	/**说明*/
	private String remark; 
	/**注册时间*/
    private Integer regTime;
    /**手机号*/
    private String phoneNumber;
}
