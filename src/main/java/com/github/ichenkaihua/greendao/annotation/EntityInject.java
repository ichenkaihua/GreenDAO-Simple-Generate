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

package com.github.ichenkaihua.greendao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/** 注入一个Entity,必须是{@link de.greenrobot.daogenerator.Schema}类型
 * @author chenkaihua
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityInject {


	/**
	 * java类名称
	 * @return java类名称
     */
	String value();


	/**
	 * 是否实现{@link java.io.Serializable}接口
	 * @return 默认为false
     */
	boolean implementsSerializable() default false;


	/**
	 * 表名称
	 * @return 表名
     */
	String tableName() default "";
	
}
