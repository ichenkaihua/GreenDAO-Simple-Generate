/**   

 * Copyright © 2015 Dreamliner Studio. All rights reserved.
 
 * 

 * @Title: GenerateInfo.java
 
 * @Prject: GreenDao2.0
 
 * @Package: com.dreamliner.greendao.pojo
 
 * @author: chenkaihua  
 
 * @date: 2015年5月13日 下午8:53:48
 
 * @version: V1.0  
 
 */

package com.dreamliner.greendao.pojo;

/**代表生成信息
 * @author chenkaihua
 *
 */
public class GenerateInfo {
	@Override
	public String toString() {
		return "GenerateInfo [outDir=" + outDir + ", outDirTest=" + outDirTest
				+ ", schemaInfo=" + schemaInfo + "]";
	}

	String outDir;

	String outDirTest;

	public GenerateInfo() {
	}

	/**
	 * 构造一个生成信息
	 * @param outDir 输出路径
	 * @param outDirTest 测试文件输出路径
	 * @param schemaInfo 数据库信息
	 */
	public GenerateInfo(String outDir, String outDirTest, SchemaInfo schemaInfo) {
		super();
		this.outDir = outDir;
		this.outDirTest = outDirTest;
		this.schemaInfo = schemaInfo;
	}

	/**
	 * @return the outDir
	 */
	public String getOutDir() {
		return outDir;
	}

	/**
	 * @param outDir
	 *            the outDir to set
	 */
	public void setOutDir(String outDir) {
		this.outDir = outDir;
	}

	/**
	 * @return the outDirTest
	 */
	public String getOutDirTest() {
		return outDirTest;
	}

	/**
	 * @param outDirTest
	 *            the outDirTest to set
	 */
	public void setOutDirTest(String outDirTest) {
		this.outDirTest = outDirTest;
	}

	/**
	 * @return the schemaInfo
	 */
	public SchemaInfo getSchemaInfo() {
		return schemaInfo;
	}

	/**
	 * @param schemaInfo
	 *            the schemaInfo to set
	 */
	public void setSchemaInfo(SchemaInfo schemaInfo) {
		this.schemaInfo = schemaInfo;
	}

	SchemaInfo schemaInfo;

}
