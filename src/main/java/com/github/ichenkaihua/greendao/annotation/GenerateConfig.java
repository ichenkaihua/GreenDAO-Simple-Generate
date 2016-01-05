/**   

 * Copyright © 2015 Dreamliner Studio. All rights reserved.
 
 * 

 * @Title: GenerateConfig.java
 
 * @Prject: GreenDao
 
 * @Package: com.dreamliner.greendao.annotation
 
 * @author: chenkaihua  
 
 * @date: 2015年5月13日 下午8:30:08
 
 * @version: V1.0  
 
 */

package com.github.ichenkaihua.greendao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 配置信息
 * @author chenkaihua
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface GenerateConfig {


	/**
	 * 输出路径，这个路径必须存在，可以是相对路径或者绝对路径
	 * @return 输出路径
     */
	String outDir();

	/**
	 * 测试文件输出路径
	 * @return 测试文件输出路
     */
	String outDirTest() default "";

	/**
	 * 输出entity类文件的路径
	 * @return entity类文件的路径
     */
	String outDirEntity() default "";


    /**
	 * 数据库配置信息
	 * @return 数据库配置信息
     */
	SchemaConfig schemaConfig();
	
	
	
	
	
	
	
	
	

}
