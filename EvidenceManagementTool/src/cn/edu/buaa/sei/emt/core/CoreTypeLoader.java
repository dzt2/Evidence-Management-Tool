package cn.edu.buaa.sei.emt.core;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import cn.edu.buaa.sei.lmf.AttributeBuilder;
import cn.edu.buaa.sei.lmf.ManagedObjectImpl;
import cn.edu.buaa.sei.lmf.TypeBuilder;
import cn.edu.buaa.sei.lmf.TypeLoader;

public class CoreTypeLoader implements TypeLoader {
	
	
	
	@Override
	public Set<TypeBuilder> loadTypes(Map<String, TypeBuilder> existingTypes) {
		Set<TypeBuilder> types = new HashSet<TypeBuilder>();
		
		// Type Definition: Element
		TypeBuilder type_Element = new TypeBuilder("core", "Element");
		type_Element.isAbstract = false;
		type_Element.isFinal = false;
		{
		}
		types.add(type_Element);
		
		// Type Definition: ModelElement
		TypeBuilder type_ModelElement = new TypeBuilder("core", "ModelElement");
		type_ModelElement.isAbstract = false;
		type_ModelElement.isFinal = false;
		type_ModelElement.superTypeNames.add("core.Element");
		{
			// Attribute Definition: id
			AttributeBuilder attr_id = new AttributeBuilder("id");
			attr_id.extensionID = "core";
			attr_id.valueTypeName = "primitives.<string>";
			attr_id.isContainment = true;
			type_ModelElement.attributes.add(attr_id);
			
			// Attribute Definition: gid
			AttributeBuilder attr_gid = new AttributeBuilder("gid");
			attr_gid.extensionID = "core";
			attr_gid.valueTypeName = "primitives.<string>";
			attr_gid.isContainment = true;
			type_ModelElement.attributes.add(attr_gid);
			
			// Attribute Definition: tags
			AttributeBuilder attr_tags = new AttributeBuilder("tags");
			attr_tags.extensionID = "core";
			attr_tags.valueTypeName = "primitives.<list>";
			attr_tags.isContainment = false;
			attr_tags.valueTypeParameter = "core.TaggedValue";
			type_ModelElement.attributes.add(attr_tags);
			
			// Attribute Definition: annotations
			AttributeBuilder attr_annotations = new AttributeBuilder("annotations");
			attr_annotations.extensionID = "core";
			attr_annotations.valueTypeName = "primitives.<list>";
			attr_annotations.isContainment = false;
			attr_annotations.valueTypeParameter = "core.Annotation";
			type_ModelElement.attributes.add(attr_annotations);
			
		}
		types.add(type_ModelElement);
		
		// Type Definition: UtilityElement
		TypeBuilder type_UtilityElement = new TypeBuilder("core", "UtilityElement");
		type_UtilityElement.isAbstract = false;
		type_UtilityElement.isFinal = false;
		type_UtilityElement.superTypeNames.add("core.Element");
		{
		}
		types.add(type_UtilityElement);
		
		// Type Definition: TaggedValue
		TypeBuilder type_TaggedValue = new TypeBuilder("core", "TaggedValue");
		type_TaggedValue.isAbstract = false;
		type_TaggedValue.isFinal = false;
		type_TaggedValue.superTypeNames.add("core.UtilityElement");
		{
			// Attribute Definition: key
			AttributeBuilder attr_key = new AttributeBuilder("key");
			attr_key.extensionID = "core";
			attr_key.valueTypeName = "primitives.<string>";
			attr_key.isContainment = true;
			type_TaggedValue.attributes.add(attr_key);
			
			// Attribute Definition: value
			AttributeBuilder attr_value = new AttributeBuilder("value");
			attr_value.extensionID = "core";
			attr_value.valueTypeName = "primitives.<string>";
			attr_value.isContainment = true;
			type_TaggedValue.attributes.add(attr_value);
			
		}
		types.add(type_TaggedValue);
		
		// Type Definition: Annotation
		TypeBuilder type_Annotation = new TypeBuilder("core", "Annotation");
		type_Annotation.isAbstract = false;
		type_Annotation.isFinal = false;
		type_Annotation.superTypeNames.add("core.UtilityElement");
		{
			// Attribute Definition: content
			AttributeBuilder attr_content = new AttributeBuilder("content");
			attr_content.extensionID = "core";
			attr_content.valueTypeName = "primitives.<string>";
			attr_content.isContainment = true;
			type_Annotation.attributes.add(attr_content);
			
		}
		types.add(type_Annotation);
		
		return types;
	}
	
	@Override
	public Map<String, Class<? extends ManagedObjectImpl>> loadImplementationClasses() {
		Map<String, Class<? extends ManagedObjectImpl>> map = new HashMap<String, Class<? extends ManagedObjectImpl>>();
		map.put("core.Element", cn.edu.buaa.sei.emt.core.ElementImpl.class);
		map.put("core.ModelElement", cn.edu.buaa.sei.emt.core.ModelElementImpl.class);
		map.put("core.UtilityElement", cn.edu.buaa.sei.emt.core.UtilityElementImpl.class);
		map.put("core.TaggedValue", cn.edu.buaa.sei.emt.core.TaggedValueImpl.class);
		map.put("core.Annotation", cn.edu.buaa.sei.emt.core.AnnotationImpl.class);
		return map;
	}
	
}
