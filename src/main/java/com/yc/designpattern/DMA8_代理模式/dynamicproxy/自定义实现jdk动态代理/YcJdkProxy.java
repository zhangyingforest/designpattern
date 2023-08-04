package com.yc.designpattern.DMA8_代理模式.dynamicproxy.自定义实现jdk动态代理;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 用来生成代理类字节码的工具类
 *
 */
public class YcJdkProxy {

    public static final String ln = "\r\n";


    public static Object newProxyInstance(YcClassLoader classLoader,
                                          Class<?> [] interfaces,
                                          YcInvocationHandler h){
       try {
           //1、动态生成源代码.java文件
           String src = generateSrc(interfaces);

//           System.out.println(src);
           //2、Java文件输出磁盘
           String filePath = YcJdkProxy.class.getResource("").getPath();
//           System.out.println(filePath);

           filePath=URLDecoder.decode(filePath,"UTF-8");
           File f = new File(filePath + "/$Proxy0.java");

           FileWriter fw = new FileWriter(f);
           fw.write(src);
           fw.flush();
           fw.close();

           //3、把生成的.java文件编译成.class文件
           //获取系统编译器  javac
           JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
           //获取java文件管理器
           StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
           Iterable iterable = manage.getJavaFileObjects(f);
            //启动编译任务
          JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null,iterable);
          task.call();
          manage.close();

           //4、编译生成的.class文件加载到JVM中来
          Class proxyClass =  classLoader.findClass("$Proxy0");
          Constructor c = proxyClass.getConstructor(YcInvocationHandler.class);
          f.delete();

           //5、返回字节码重组以后的新的代理对象
           return c.newInstance(   h  );
       }catch (Exception e){
           e.printStackTrace();
       }
        return null;
    }

    /**
     * 针对这个接口拼装了一个java实现类，在这个类对抽象 方法做实现.
     *      伪代码:
     *           1. 首先利用ribbon, 访问eureka服务得到服务列表， 自动利用负载均衡取一个服务.
     *            2. 将服务名转为地址.    http://ip:端口/服务名/product/get/{id}
     *           3. 利用网络访问框架.   HttpClient(OKhttp )
     *
     * @param interfaces
     * @return
     */
    private static String generateSrc(Class<?>[] interfaces){
            StringBuffer sb = new StringBuffer();
            //TODO: 应当是根据接口的包名来生成.
            sb.append("package com.yc.designpattern.DMA8_代理模式.dynamicproxy.自定义实现jdk动态代理;" + ln);
            sb.append("import com.yc.designpattern.DMA8_代理模式.staticproxy.Person;" + ln);
            sb.append("import java.lang.reflect.*;" + ln);
            sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
                sb.append("YcInvocationHandler h;" + ln);
                sb.append("public $Proxy0(YcInvocationHandler h) { " + ln);
                    sb.append("this.h = h;");
                sb.append("}" + ln);
                for (Method m : interfaces[0].getMethods()){
                    Class<?>[] params = m.getParameterTypes();

                    StringBuffer paramNames = new StringBuffer();
                    StringBuffer paramValues = new StringBuffer();
                    StringBuffer paramClasses = new StringBuffer();

                    for (int i = 0; i < params.length; i++) {
                        Class clazz = params[i];
                        String type = clazz.getName();
                        String paramName = toLowerFirstCase(clazz.getSimpleName());
                        paramNames.append(type + " " +  paramName);
                        paramValues.append(paramName);
                        paramClasses.append(clazz.getName() + ".class");
                        if(i > 0 && i < params.length-1){
                            paramNames.append(",");
                            paramClasses.append(",");
                            paramValues.append(",");
                        }
                    }

                    sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() + ") {" + ln);
                        sb.append("try{" + ln);
                            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
                            sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})",m.getReturnType()) + ";" + ln);
                        sb.append("}catch(Error _ex) { }");
                        sb.append("catch(Throwable e){" + ln);
                        sb.append("throw new UndeclaredThrowableException(e);" + ln);
                        sb.append("}");
                        sb.append(getReturnEmptyCode(m.getReturnType()));
                    sb.append("}");
                }
            sb.append("}" + ln);
            return sb.toString();
    }


    private static Map<Class,Class> mappings = new HashMap<Class, Class>();
    static {
        mappings.put(int.class,Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "return 0;";
        }else if(returnClass == void.class){
            return "";
        }else {
            return "return null;";
        }
    }

    private static String getCaseCode(String code,Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "((" + mappings.get(returnClass).getName() +  ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz){
        return clazz != void.class;
    }

    private static String toLowerFirstCase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
