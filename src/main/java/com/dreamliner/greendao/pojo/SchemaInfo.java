/**   

 * Copyright © 2015 Dreamliner Studio. All rights reserved.
 
 * 

 * @Title: SchemaInfo.java
 
 * @Prject: GreenDao2.0
 
 * @Package: com.dreamliner.greendao.pojo
 
 * @author: chenkaihua  
 
 * @date: 2015年5月13日 下午8:54:00
 
 * @version: V1.0  
 
 */

package com.dreamliner.greendao.pojo;

/**
 * 
 * @ClassName SchemaInfo
 * @author chenkaihua
 * @date 2015年5月13日下午8:54:00
 * @email admin@chenkaihua.com
 */
public class SchemaInfo {

	private int version = 1;

	private boolean enableKeepSectionsByDefault = true;

	private String defaultJavaPackage;

	private String defaultJavaPackageTest;

	private String defaultJavaPackageDao;
	
	private boolean enableActiveEntitiesByDefault;

	/**
	 * @return the enableActiveEntitiesByDefault
	 */
	public boolean isEnableActiveEntitiesByDefault() {
		return enableActiveEntitiesByDefault;
	}

	/**
	 * @param enableActiveEntitiesByDefault the enableActiveEntitiesByDefault to set
	 */
	public void setEnableActiveEntitiesByDefault(
			boolean enableActiveEntitiesByDefault) {
		this.enableActiveEntitiesByDefault = enableActiveEntitiesByDefault;
	}

	/**
	 * 
	 * @param defaultJavaPackage
	 */
	public SchemaInfo(String defaultJavaPackage) {
		super();
		this.defaultJavaPackage = defaultJavaPackage;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the enableKeepSectionsByDefault
	 */
	public boolean isEnableKeepSectionsByDefault() {
		return enableKeepSectionsByDefault;
	}

	/**
	 * @param enableKeepSectionsByDefault
	 *            the enableKeepSectionsByDefault to set
	 */
	public void setEnableKeepSectionsByDefault(
			boolean enableKeepSectionsByDefault) {
		this.enableKeepSectionsByDefault = enableKeepSectionsByDefault;
	}

	/**
	 * @return the defaultJavaPackage
	 */
	public String getDefaultJavaPackage() {
		return defaultJavaPackage;
	}

	/**
	 * @param defaultJavaPackage
	 *            the defaultJavaPackage to set
	 */
	public void setDefaultJavaPackage(String defaultJavaPackage) {
		this.defaultJavaPackage = defaultJavaPackage;
	}

	/**
	 * @return the defaultJavaPackageTest
	 */
	public String getDefaultJavaPackageTest() {
		return defaultJavaPackageTest;
	}

	/**
	 * @param defaultJavaPackageTest
	 *            the defaultJavaPackageTest to set
	 */
	public void setDefaultJavaPackageTest(String defaultJavaPackageTest) {
		this.defaultJavaPackageTest = defaultJavaPackageTest;
	}

	/**
	 * 重写 toString
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SchemaInfo [version=" + version
				+ ", enableKeepSectionsByDefault="
				+ enableKeepSectionsByDefault + ", defaultJavaPackage="
				+ defaultJavaPackage + ", defaultJavaPackageTest="
				+ defaultJavaPackageTest + ", defaultJavaPackageDao="
				+ defaultJavaPackageDao + ", enableActiveEntitiesByDefault="
				+ enableActiveEntitiesByDefault + "]";
	}

	/**
	 * @return the defaultJavaPackageDao
	 */
	public String getDefaultJavaPackageDao() {
		return defaultJavaPackageDao;
	}

	/**
	 * @param defaultJavaPackageDao
	 *            the defaultJavaPackageDao to set
	 */
	public void setDefaultJavaPackageDao(String defaultJavaPackageDao) {
		this.defaultJavaPackageDao = defaultJavaPackageDao;
	}

}
