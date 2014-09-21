package cn.edu.buaa.sei.exLmf.translater;

import java.io.File;

import cn.edu.buaa.sei.exLmf.metamodel.LPackage;

/**
 *	IModelImporter
 *		- description: read model from model files and translate the code into instances of exLMF 
 * 		- setResource(File): set the model file to provide model information.
 * 		- validate(): test whether the resource has been ready for translation.
 * 		- translate: read the model file and return the root package as a result.
 */
public interface IModelImporter {
	public void setResource(File file);
	public boolean validate() throws Exception;
	public LPackage translate() throws Exception;
}
