package com.leyou.sms.ye.rly.result;

import java.util.Map;

/**
 * 容联云发送短信后，返回的数据
 * @author 小叶
 */
public class RlySmsResult {

//    statusCode详情：http://doc.yuntongxun.com/pe/5a5857203b8496dd00dd2b3d
    private String statusCode; //statusCode=000000
    private String statusMsg;
    private Map<String,Object> data; //data={templateSMS={dateCreated=20201011223344, smsMessageSid=3bfbca0bfd9b4ce58c55aca95970afff}


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SmsResult{" +
                "statusCode='" + statusCode + '\'' +
                ", statusMsg='" + statusMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
