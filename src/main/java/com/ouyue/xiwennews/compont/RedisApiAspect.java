package com.ouyue.xiwennews.compont;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.ouyue.xiwennews.annotation.RedisCacheAble;
import com.ouyue.xiwennews.annotation.RedisCachePut;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
/**
 * @author :tongjingji01@gmail.com
 * @program:billionbottle-engine
 * @description:
 * @create:2019-10-21 17-16
 */  
@Component // 注册到Spring容器，必须加入这个注解  
@Aspect // 该注解标示该类为切面类，切面是由通知和切点组成的。
public class RedisApiAspect {

	Logger logger = LoggerFactory.getLogger(RedisApiAspect.class);

	@Autowired
	private RedisTemplate redisTemplate;

    @Pointcut("@annotation(com.ouyue.xiwennews.annotation.RedisCachePut)")// 定义注解类型的切点，只要方法上有该注解，都会匹配
    public void annotationPut(){          
    }  
    

    @Pointcut("@annotation(com.ouyue.xiwennews.annotation.RedisCacheAble)")// 定义注解类型的切点，只要方法上有该注解，都会匹配
    public void annotationAble(){        
    }       
    

    @Around("annotationPut()&& @annotation(rd)")
    public Object redisCachePut(ProceedingJoinPoint joinPoint, RedisCachePut rd) throws Throwable {
    	
    	if(joinPoint.getArgs().length!=1 && joinPoint.getArgs()[0] == null) {
      	   logger.error("rediaCache args is null");    
     	}	
    	
    	//执行函数
        //如果返回值不是整数，那么就不是用于插入操作,返回
		Object returnObj = joinPoint.proceed();
		if(returnObj == null) {
			logger.error("redisCachePut不可使用于返回值为空");
			return 0;
		}

		String rtStr = returnObj.toString();
		if(!Character.isDigit(rtStr.charAt(0))) {
			logger.error("redisCachePut不可使用于返回值不为数字");
			return 0;
		}		
		int result = Integer.parseInt(rtStr);	
		//插入数据库失败
		if(result == 0) {
			return 0;
		}
    	
    	//获取调用的路径
		String path = getMethodPath(joinPoint);
		//根据values获取object里的值，并生成用于redis存储的对象
	    Object sourceObject = joinPoint.getArgs()[0];
		Class<? extends Object> cl = sourceObject.getClass();
    	//获取key在对象中的值
		String redisKey = getRedisKey(rd, sourceObject, cl);
    	//先淘汰缓存，再进行sql，防止数据不一致
		redisTemplate.delete(redisKey);
		
		//插入数据库成功
		//如果values没有值，那么redis对应的value为输入对象；否则根据输入参数重新生成对象
    	if(rd.names() == null) {
			final String jsonStr = JSON.toJSONString(sourceObject);
            //存入目标对象,key=类名:keyvalue
			redisTemplate.opsForValue().set(redisKey, jsonStr);
    	}else {   		
			Map jsonMap = new HashMap<String,Object>();
    		for(String name: rd.names()) {
    			 try {    
    				   //生成值到新的对象中
    		           String upChar = name.substring(0, 1).toUpperCase();   
    		           String getterStr = "get" + upChar + name.substring(1);  
    		           Method getMethod = cl.getMethod(getterStr, new Class[] {});    
    		           Object objValue = getMethod.invoke(sourceObject, new Object[] {});  
    		           
    		           jsonMap.put(name, objValue);
    		       } catch (Exception e) {    
    		    	   logger.error(e.getMessage(),e);    
    		       }        		
        	}
			String jsonString = JSON.toJSONString(jsonMap);
            //存入目标对象,key=类名:keyvalue
			redisTemplate.opsForValue().set(redisKey, jsonString);

    	}
    	return result;
}


	@Around("annotationAble()&& @annotation(rd)")
	public Object redisCacheAble(ProceedingJoinPoint joinPoint, RedisCacheAble rd) throws Throwable {
		String preKey = rd.value();

		String arg0 = joinPoint.getArgs()[0].toString();

		Class returnClassType = ((MethodSignature)joinPoint.getSignature()).getMethod().getReturnType();

		//TODO arg0判断
		String key = preKey + ":" +arg0;

		//如果redis中已經有值，直接返回
		String rtObject = (String) redisTemplate.opsForValue().get(key);

		if (rtObject != null) {
			Object obj = JSON.parseObject(rtObject,returnClassType);
			return obj;
		}

		// 执行函数,如果返回值為空,返回
		Object sourceObject = joinPoint.proceed();
		if (sourceObject == null) {
			return null;
		}

		String path = getMethodPath(joinPoint);
		// 根据values获取object里的值，并生成用于redis存储的对象
		Class<? extends Object> cl = sourceObject.getClass();

		// 插入数据库成功
		// 如果values没有值，那么redis对应的value为输入对象；否则根据输入参数重新生成对象
		if (rd.names() == null ||rd.names().length==0) {
			// 存入目标对象
			final String jsonStr = JSON.toJSONString(sourceObject);
			redisTemplate.opsForValue().set(key, jsonStr,rd.timeout(),TimeUnit.MINUTES);

		} else {
			// 将目标对象特定字段存入redis
			// 不用反射，而用jsonobject；并且只存储需要的字段，而不存整个对象
			//Object targetObject = cl.newInstance();
			Map jsonMap = new HashMap<String,Object>();
			for (String name : rd.names()) {
				try {
					// 生成值到新的对象中
					String upChar = name.substring(0, 1).toUpperCase();
					String getterStr = "get" + upChar + name.substring(1);
					Method getMethod = cl.getMethod(getterStr, new Class[] {});
					Object objValue = getMethod.invoke(sourceObject, new Object[] {});
					jsonMap.put(name, objValue);

				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
			// 存入目标对象,key=类名:keyvalue
			String jsonString = JSON.toJSONString(jsonMap);
			redisTemplate.opsForValue().set(key, jsonString,rd.timeout(),TimeUnit.MINUTES);

		}
		return sourceObject;
	}

	public static Map<String,Object> getStringToMap(String str){
		//根据逗号截取字符串数组
		String[] str1 = str.split(",");
		//创建Map对象
		Map<String,Object> map = new HashMap<>();
		//循环加入map集合
		for (int i = 0; i < str1.length; i++) {
			//根据":"截取字符串数组
			String[] str2 = str1[i].split(":");
			//str2[0]为KEY,str2[1]为值
			map.put(str2[0],str2[1]);
		}
		return map;
	}





	private String getRedisKey(RedisCachePut rd, Object sourceObject, Class<? extends Object> cl)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		String key = rd.key();
		key = key.substring(1); //去掉开头的#号，与spring原生注解保持一致
		
		String firstLetter = key.substring(0, 1).toUpperCase();   
        String getter = "get" + firstLetter + key.substring(1);  
        Method method = cl.getMethod(getter, new Class[] {});    
        Object keyValue = method.invoke(sourceObject, new Object[] {});  
        
        String value = rd.value();
      	String redisKey = value+":"+keyValue.toString();
		return redisKey;
	}

	private String getMethodPath(ProceedingJoinPoint joinPoint) {
		String methodName = ((MethodSignature)joinPoint.getSignature()).getMethod().getName();
	    String classFullName =  ((MethodSignature)joinPoint.getSignature()).getMethod().getDeclaringClass().getName();
	    String path = classFullName.substring(classFullName.lastIndexOf(".")+1) + "." + methodName;
		return path;
	}

} 