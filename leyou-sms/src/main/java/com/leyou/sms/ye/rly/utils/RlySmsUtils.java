package com.leyou.sms.ye.rly.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.leyou.sms.ye.rly.result.RlySmsResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 发送短信的工具
 * @author 叶锦斌
 */
@Component //启动的时候扫描到注解
public class RlySmsUtils {
    //从apllication.yml获取值
    @Value("${leyou.ye.rly.sms.acount}")
    private String acount;//账户id
    @Value("${leyou.ye.rly.sms.token}")
    private String token;//密匙 key
    @Value("${leyou.ye.rly.sms.appId}")
    private String appId;
    @Value("${leyou.ye.rly.sms.templateId}")
    private String templateId;//短信模板ID




    public RlySmsResult smsSend(String phone, String code, String validateTime) {
        HashMap<String, Object> resultMap = null;
        RlySmsResult result=new RlySmsResult();
        //初始化SDK
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
        //******************************注释
        //*初始化服务器地址和端口                                                       *
        //*沙盒环境（用于应用开发调试）：
        restAPI.init("sandboxapp.cloopen.com", "8883");
        //*生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com", "8883");       *
        //*******************************注释
        restAPI.init("app.cloopen.com", "8883");
        //*初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN     *
        //*ACOUNT SID和AUTH TOKEN在登陆官网后，在“应用-管理控制台”中查看开发者主账号获取*
        //*参数顺序：第一个参数是ACOUNT SID，第二个参数是AUTH TOKEN。
        restAPI.setAccount(acount, token);
        //******************************注释
        //*初始化应用ID                                                                 *
        //*测试开发可使用“测试Demo”的APP ID，
        //正式上线需要使用自己创建的应用的App ID
        //*应用ID的获取：登陆官网，在“应用-应用列表”，
        //点击应用名称，看应用详情获取APP ID
        restAPI.setAppId(appId);
        //******************************注释
        //*调用发送模板短信的接口发送短信
        //*参数顺序说明：                                                                                  *
        //*第一个参数:是要发送的手机号码，可以用逗号分隔，一次最多支持100个手机号
        //*第二个参数:是模板ID，在平台上创建的短信模板的ID值；测试的时候可以使用系统的默认模板，id为1。
        //*系统默认模板的内容为“【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入”*
        //*第三个参数是要替换的内容数组。                                                                                                                               *
        //*假设您用测试Demo的APP ID，则需使用默认模板ID 1，发送手机号是13800000000，传入参数为6532和5，则调用方式为           *
        //*result = restAPI.sendTemplateSMS("13800000000","1" ,new String[]{"6532","5"});                                                                          *
        //*则13800000000手机号收到的短信内容是：【云通讯】您使用的是云通讯短信模板，您的验证码是xxxxx，请于xx分钟内正确输入


        //验证码，方便观察
        System.out.println("验证码"+code);

        if (validateTime==null){
            validateTime="随便几分钟或者无限";
        }

        resultMap = restAPI.sendTemplateSMS(phone,templateId ,new String[]{code,validateTime});


        if (resultMap.get("statusCode")!=null) {
            result.setStatusCode((String) resultMap.get("statusCode"));
        }
        if (resultMap.get("data")!=null) {
            result.setData((HashMap<String, Object>) resultMap.get("data"));
        }
        if (resultMap.get("statusMsg")!=null) {
            result.setStatusMsg((String) resultMap.get("statusMsg"));
        }
        if (resultMap.get("statusMsg")==null && result.getStatusCode().equals("000000")){
            result.setStatusMsg("发送 "+phone+" 的验证码："+code+" ，结果是 --> 成功！");
        }

//        System.out.println("SDKTestGetSubAccounts result=" + result);

        if("000000".equals(result.getStatusCode())){
//            //测试
//            //正常返回输出data包体信息（map）
//            Map<String,Object> data = (HashMap<String, Object>) result.getData();
//            Set<String> keySet = data.keySet();
//            for(String key:keySet){
//                Object object = data.get(key);
//                System.out.println(key +" = "+object);
//            }
            //发送成功输出
            System.out.println(result.getStatusMsg());
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.getStatusCode() +" 错误信息= "+result.getStatusMsg());
        }
        return result;
    }
    //随机验证码


}
