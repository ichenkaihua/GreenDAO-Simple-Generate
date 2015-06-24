/**   

 * Copyright © 2015 Dreamliner Studio. All rights reserved.
 
 * 

 * @Title: EntityInject.java
 
 * @Prject: GreenDao
 
 * @Package: com.dreamliner.greendao.annotation
 
 * @author: chenkaihua  
 
 * @date: 2015年5月9日 下午11:55:47
 
 * @version: V1.0  
 
 */

package com.dreamliner.greendao.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 代表一个实体的注解，默认值为生成的类名
 * 
 * @ClassName EntityInject
 * @author chenkaihua
 * @date 2015年5月9日下午11:55:47
 * @email admin@chenkaihua.com
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityInject {
	
	
	/**
	 * 生成的类名  
	 */
	String value();
	
	
	/**
	 * 
	 *是否实现{@link Serializable}接口  
	 */
	boolean implementsSerializable() default false;
	
	
	/**
	 * 表名  
	 */
	String tableName() default "";
	
}
