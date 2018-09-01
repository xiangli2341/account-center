package org.ml.accountcenter.web;

import lombok.extern.slf4j.Slf4j;
import org.ml.accountcenter.entity.MlUser;
import org.ml.accountcenter.service.MlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * MlUser的路由接口服务
 * 
 * @author 
 *
 */
@Slf4j
@RestController
public class MlUserController {

    @Autowired
    private MlUserService service;

    /**
     * demo 根据 userName查找个人信息
     * 测试接口：http://localhost:1001/findByUserName?userName=admin
     * @param userName
     * @return
     */
    @RequestMapping("/findByUserName")
    public MlUser find(@RequestParam String userName) {
        return service.findByUserName(userName);
    }

    /**
     * demo 根据 手机号查找个人信息
     *   测试接口：http://localhost:1001/findByPhoneNumber?phoneNumber=17829030612
     *
     *   num：查找到的数据条数
     * @param phoneNumber
     * @return
     */
    @RequestMapping("/findByPhoneNumber")
    public Integer findByPhoneNumber(@RequestParam String phoneNumber) {
        int num=service.findByPhoneNumber(phoneNumber);
        log.info("日志输出 根据手机号查找到："+num+"条数据");
        return service.findByPhoneNumber(phoneNumber);
    }


    /**
     * demo 根据 手机号查找个人信息
     *   测试接口：http://localhost:1001/addUser?username=asdli&password=123456&status=1&regTime=20181012&phoneNumber=18700523543
     *   添加时先进行手机号检测，有则返回false
     *   无 进行注册
     * @param
     * @return
     */
    @RequestMapping(value = "/addUser")
    public boolean addUser (MlUser mlUser,@RequestParam String phoneNumber){
        boolean flag=false;

        try{

            //进行数据库查找
            Integer a=service.findByPhoneNumber(phoneNumber);
            //如果查找条数为0,则进行添加操作
            if(a==0){
                //如果添加操作返回true,flag-true,返回添加成功
                if(service.addUser(mlUser)==true){
                    flag=true;
                    log.info("日志输出 =====添加成功！！");
                }else{                              //否则添加操作返回添加出现异常,添加失败
                    log.debug("日志输出 =====添加出现异常,失败！！");
                }
            }else{
                log.error("添加失败，数据库已有注册的手机号！！！");
            }
        }catch(Exception e){
            e.printStackTrace();
            log.debug("日志输出 =====添加出现异常,失败！！");
        }
        log.info("结果返回为："+flag);
        return flag;
    }

}
