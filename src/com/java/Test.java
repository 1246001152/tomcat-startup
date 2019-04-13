package com.java;

import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

public class Test {

    private static final int PORT=8080;
    //项目名称
    private static final String CONTEXT_PATH="/";
    public static void main(String[] args)throws Exception {
        //创建tomcat服务器
        Tomcat tomcat = new Tomcat();
        // 自定义端口号
        tomcat.setPort(PORT);
        // 是否设置自动部署
        tomcat.getHost().setAutoDeploy(false);
        //创建上下文
        StandardContext standardContext= new StandardContext();
        //设置上下文路径 就是项目名称
        standardContext.setPath("/");
        // 上下文对象添加监听
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        // tomcat添加上下文信息
        tomcat.getHost().addChild(standardContext);

        //创建serlvet请求地址     项目名     servlet名字    创建serlvet对象
//        tomcat.addServlet(CONTEXT_PATH,"HelloServlet",new HelloServlet())
        //                                          mapping地址   servlet名字
//        standardContext.addServletMappingDecoded("/hello","HelloServlet");
        tomcat.start();
        System.out.println("tomcat启动成功！");
        tomcat.getServer().await();

    }
}
