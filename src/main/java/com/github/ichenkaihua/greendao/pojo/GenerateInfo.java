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

package com.github.ichenkaihua.greendao.pojo;

/**代表生成信息，{@link com.github.ichenkaihua.greendao.annotation.GenerateConfig}的信息
 * @author chenkaihua
 *
 */
public class GenerateInfo {

	private String outDir;

	private String outDirTest;
	
	private String outDirEntity;
	
	private SchemaInfo schemaInfo;
	
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GenerateInfo [outDir=" + outDir + ", outDirTest=" + outDirTest
				+ ", outDirEntity=" + outDirEntity + ", schemaInfo="
				+ schemaInfo + "]";
	}

	/**
	 * @return the outDir
	 */
	public String getOutDir() {
		return outDir;
	}

	/**
	 * @return the outDirTest
	 */
	public String getOutDirTest() {
		return outDirTest;
	}

	/**
	 * @return the outDirEntity
	 */
	public String getOutDirEntity() {
		return outDirEntity;
	}

	/**
	 * @return the schemaInfo
	 */
	public SchemaInfo getSchemaInfo() {
		return schemaInfo;
	}

	/**
	 * @param outDir the outDir to set
	 */
	public void setOutDir(String outDir) {
		this.outDir = outDir;
	}

	/**
	 * @param outDirTest the outDirTest to set
	 */
	public void setOutDirTest(String outDirTest) {
		this.outDirTest = outDirTest;
	}

	/**
	 * @param outDirEntity the outDirEntity to set
	 */
	public void setOutDirEntity(String outDirEntity) {
		this.outDirEntity = outDirEntity;
	}

	/**
	 * @param schemaInfo the schemaInfo to set
	 */
	public void setSchemaInfo(SchemaInfo schemaInfo) {
		this.schemaInfo = schemaInfo;
	}
	

	

	

}
