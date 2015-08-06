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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/** 注入
 * @author chenkaihua
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityInject {
	
	
	
	String value();
	
	
	
	boolean implementsSerializable() default false;
	
	
	
	String tableName() default "";
	
}
