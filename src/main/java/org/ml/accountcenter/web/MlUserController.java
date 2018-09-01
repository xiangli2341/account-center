package org.ml.accountcenter.web;

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
     * @param phoneNumber
     * @return
     */
    @RequestMapping("/findByPhoneNumber")
    public Integer findByPhoneNumber(@RequestParam String phoneNumber) {
        return service.findByPhoneNumber(phoneNumber);
    }


    /**
     * demo 根据 手机号查找个人信息
     *   测试接口：http://localhost:1001/addUser?username=asdli&PASSWORD=123456&STATUS=1&regTime=20181012&phoneNumber=18700523543
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
            if(a==0){
                if(service.addUser(mlUser)==true){
                    flag=true;
                    System.out.println("添加成功！！");
                    System.out.println("---------------------");
                }else{
                    System.out.println("添加失败！！");
                    System.out.println("---------------------");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("出现异常，添加失败！！");
            System.out.println("---------------------");
        }
        System.out.println("结果返回为："+flag);
        System.out.println("---------------------");
        return flag;
    }

}
