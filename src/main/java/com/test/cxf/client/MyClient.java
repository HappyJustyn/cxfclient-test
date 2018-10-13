package com.test.cxf.client;

import com.test.cxf.generate.User;
import com.test.cxf.generate.UserService;
import com.test.cxf.generate.UserService_Service;
import lombok.SneakyThrows;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * 客户端（两种方式）
 *
 * @author Justyn
 * @date 2018/10/13 14:42
 */
public class MyClient {

    public static void main(String[] args) {
        client1();
    }

    /**
     * 1.代理类工厂的方式,需要根据wsdl地址生成客户端代码
     */
    public static void client1() {
        // 接口地址
        String address = "http://127.0.0.1:8080/services/user?wsdl";
        // 代理工厂
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        // 设置代理地址
        factoryBean.setAddress(address);
        // 设置接口类型
        factoryBean.setServiceClass(UserService.class);
        // 创建一个代理接口实现
        UserService userService = (UserService) factoryBean.create();
        // 调用代理接口的方法
        User user = userService.getUser(1);
        System.out.println(user.getEmail());
    }

    public static void client2() {
        UserService_Service userService = new UserService_Service();
        User user = userService.getUserServiceImplPort().getUser(1);
        System.out.println(user.getEmail());
    }

    /**
     * 2：动态调用
     */
    @SneakyThrows
    public static void client3() {
        // 创建动态客户端
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient("http://127.0.0.1:8080/services/user?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        // invoke("方法名",参数1,参数2,参数3....);
        Object[] objects = client.invoke("getUserName", 1);
        System.out.println(objects[0].getClass());
        System.out.println(objects[0]);
    }

}
