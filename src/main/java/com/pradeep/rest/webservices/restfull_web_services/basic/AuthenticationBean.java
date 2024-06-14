package com.pradeep.rest.webservices.restfull_web_services.basic;

public class AuthenticationBean {
    public  String msg;

    public AuthenticationBean(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }
    @Override

    public String toString() {
        return "HelloWorldBean{" +
                "msg='" + msg + '\'' +
                '}';
    }

}
