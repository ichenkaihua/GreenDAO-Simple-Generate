/**   

 * Copyright © 2015 Dreamliner Studio. All rights reserved.
 
 * 

 * @Title: GenerateService.java
 
 * @Prject: GreenDao
 
 * @Package: com.dreamliner.greendao.service
 
 * @author: chenkaihua  
 
 * @date: 2015年5月10日 上午11:50:34
 
 * @version: V1.0  
 
 */

package com.github.ichenkaihua.greendao.service;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.github.ichenkaihua.greendao.annotation.EntityInject;
import com.github.ichenkaihua.greendao.annotation.GenerateConfig;
import com.github.ichenkaihua.greendao.annotation.SchemaConfig;
import com.github.ichenkaihua.greendao.pojo.GenerateInfo;
import com.github.ichenkaihua.greendao.pojo.SchemaInfo;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GenerateService {

	private final Class<?> classesz;

	/**
	 * 构造一个greendaoService，生成greendao时将会根据传入的Class读取注解和方法
	 * 
	 * @param classesz
	 *            带有注解信息的类
	 */
	public GenerateService(Class<?> classesz) {
		this.classesz = classesz;
	}

	public void generate() {
		if (classesz == null) {
			System.out.println("构造传入的Classes不能为空!");
			return;
		}
		GenerateConfig annotation = classesz
				.getAnnotation(GenerateConfig.class);
		if (annotation == null) {
			System.out.println(classesz.getName() + "can not find  "
					+ GenerateConfig.class.getName() + " annotation!");
			return;
		}
		try {
			Object obj = classesz.newInstance();
			GenerateInfo generateInfo = parseInfo(annotation);
			Method[] declaredMethods = classesz.getDeclaredMethods();
			String defaultJavaPackage = generateInfo.getSchemaInfo()
					.getDefaultJavaPackage();
			String defaultJavaPackageDao = generateInfo.getSchemaInfo()
					.getDefaultJavaPackageDao();
			String defaultJavaPackageTest = generateInfo.getSchemaInfo()
					.getDefaultJavaPackageTest();
			Schema schema = new Schema(generateInfo.getSchemaInfo()
					.getVersion(), defaultJavaPackage);
			if (null != defaultJavaPackageDao)
				schema.setDefaultJavaPackageDao(defaultJavaPackageDao);
			if (null != defaultJavaPackageTest)
				schema.setDefaultJavaPackageTest(defaultJavaPackageTest);
			for (Method method : declaredMethods) {
				method.setAccessible(true);
				boolean invoke = false;
				Map<Integer, Object> params = new HashMap<Integer, Object>();
				Class<?>[] parameterTypes = method.getParameterTypes();

				Annotation[][] parameterAnnotations = method
						.getParameterAnnotations();
				// 处理注解
				for (int i = 0; i < parameterAnnotations.length; i++) {
					Annotation[] annotations = parameterAnnotations[i];
					for (int j = 0; j < annotations.length; j++) {
						Annotation annotation2 = annotations[j];
						if (annotation2 instanceof EntityInject
								&& Entity.class.equals(parameterTypes[i])) {
							EntityInject entityInject = (EntityInject) annotation2;
							boolean implementsSerializable = entityInject
									.implementsSerializable();
							String tableName = entityInject.tableName();
							String value = entityInject.value();
							Entity entity = schema.addEntity(value);
							if (implementsSerializable)
								entity.implementsSerializable();
							if (!isEmpty(tableName))
								entity.setTableName(tableName);
							if (!invoke)
								invoke = true;
							params.put(i, entity);

						}

					}

				}
				// 处理参数
				for (int i = 0; i < parameterTypes.length; i++) {
					Class<?> classz = parameterTypes[i];
					if (classz == Schema.class) {
						params.put(i, schema);
						invoke = true;
					} else if (classz == GenerateInfo.class) {
						params.put(i, generateInfo);
						invoke = true;
					} else if (classz == SchemaInfo.class) {
						params.put(i, generateInfo.getSchemaInfo());
						invoke = true;
					}

				}
				// 调用信息
				if (invoke) {
					Object[] paraArray = new Object[parameterTypes.length];
					for (Integer i : params.keySet()) {
						paraArray[i] = params.get(i);
					}
					method.invoke(obj, paraArray);

				}

			}

			new DaoGenerator().generateAll(schema, generateInfo.getOutDir(),
					generateInfo.getOutDirEntity(),
					generateInfo.getOutDirTest());

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private GenerateInfo parseInfo(GenerateConfig config) {
		GenerateInfo generateInfo = new GenerateInfo();

		String outDir = config.outDir();
		String outDirTest = config.outDirTest();
		String outDirEntity = config.outDirEntity();
		generateInfo.setOutDir(outDir);
		if (!isEmpty(outDirTest))
			generateInfo.setOutDirTest(outDirTest);
		if (!isEmpty(outDirEntity))
			generateInfo.setOutDirEntity(outDirEntity);

		SchemaConfig schemaConfig = config.schemaConfig();
		SchemaInfo schemaInfo = new SchemaInfo(
				schemaConfig.defaultJavaPackage());
		String defaultJavaPackageDao = schemaConfig.defaultJavaPackageDao();
		String defaultJavaPackageTest = schemaConfig.defaultJavaPackageTest();
		boolean enableActiveEntitiesByDefault = schemaConfig
				.enableActiveEntitiesByDefault();
		boolean enableKeepSectionsByDefault = schemaConfig
				.enableKeepSectionsByDefault();
		int version = schemaConfig.version();
		if (!isEmpty(defaultJavaPackageTest))
			schemaInfo.setDefaultJavaPackageTest(defaultJavaPackageTest);
		if (!isEmpty(defaultJavaPackageDao))
			schemaInfo.setDefaultJavaPackageDao(defaultJavaPackageDao);
		schemaInfo
				.setEnableActiveEntitiesByDefault(enableActiveEntitiesByDefault);
		schemaInfo.setEnableKeepSectionsByDefault(enableKeepSectionsByDefault);
		schemaInfo.setVersion(version);
		generateInfo.setSchemaInfo(schemaInfo);
		return generateInfo;
	}

	private static boolean isEmpty(String str) {
		return str == null || str.trim().equals("");
	}

}
