/**   

 * Copyright © 2015 Dreamliner Studio. All rights reserved.
 
 * 

 * @Title: SchemaConfig.java
 
 * @Prject: GreenDao
 
 * @Package: com.dreamliner.greendao.annotation
 
 * @author: chenkaihua  
 
 * @date: 2015年5月13日 下午8:28:23
 
 * @version: V1.0  
 
 */

package com.github.ichenkaihua.greendao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** schema的配置信息
 * @author chenkaihua
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface SchemaConfig {
	
	/**
	 * version of schema
	 * @return version of schema
	 */
	int version() default 1;
	
	/**
	 * enable keep section by default,default=true
	 * @return enable keep section by default
	 */
	boolean  enableKeepSectionsByDefault() default true;

	/**
	 * enable active entitys by default ,default=false
	 * @return enable active entitys by default ,default=false
	 */
	boolean enableActiveEntitiesByDefault() default false;
	
	String  defaultJavaPackage();
	
	
	String  defaultJavaPackageTest() default "";
	
	String  defaultJavaPackageDao() default "";
	
	
	
	
	
	
	
	
	

}
