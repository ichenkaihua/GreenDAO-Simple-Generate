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

package com.dreamliner.greendao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName GenerateConfig
 * @author chenkaihua
 * @date 2015年5月13日下午8:30:08
 * @email admin@chenkaihua.com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface GenerateConfig {
	
	
	String outDir();
	
	
	String outDirTest() default "";
	
	
	SchemaConfig schemaConfig();
	
	
	
	
	
	
	
	
	

}
