package ac.biu.nlp.nlp.instruments.parse.tree.dependency.basic.xmldom;

import static ac.biu.nlp.nlp.instruments.parse.tree.dependency.basic.xmldom.InfoToElement.DEPENDENCY_RELATION_STRING_ELEMENT_NAME;
import static ac.biu.nlp.nlp.instruments.parse.tree.dependency.basic.xmldom.InfoToElement.EXIST_ATTRIBUTE_NAME;
import static ac.biu.nlp.nlp.instruments.parse.tree.dependency.basic.xmldom.InfoToElement.ID_ELEMENT_NAME;
import static ac.biu.nlp.nlp.instruments.parse.tree.dependency.basic.xmldom.InfoToElement.LEMMA_ELEMENT_NAME;
import static ac.biu.nlp.nlp.instruments.parse.tree.dependency.basic.xmldom.InfoToElement.POS_STRING_ELEMENT_NAME;
import static ac.biu.nlp.nlp.instruments.parse.tree.dependency.basic.xmldom.InfoToElement.SERIAL_ELEMENT_NAME;
import static ac.biu.nlp.nlp.instruments.parse.tree.dependency.basic.xmldom.InfoToElement.TRUE_VALUE;
import static ac.biu.nlp.nlp.instruments.parse.tree.dependency.basic.xmldom.InfoToElement.VARIABLE_ATTRIBUTE_NAME;
import static ac.biu.nlp.nlp.instruments.parse.tree.dependency.basic.xmldom.InfoToElement.VARIABLE_ID_ELEMENT_NAME;
import static ac.biu.nlp.nlp.instruments.parse.tree.dependency.basic.xmldom.InfoToElement.WORD_ELEMENT_NAME;
import static ac.biu.nlp.nlp.instruments.parse.tree.dependency.basic.xmldom.TreeXmlUtils.getChildElement;
import static ac.biu.nlp.nlp.instruments.parse.tree.dependency.basic.xmldom.TreeXmlUtils.getTextOfElement;

import org.w3c.dom.Element;

import ac.biu.nlp.nlp.instruments.parse.representation.basic.DefaultEdgeInfo;
import ac.biu.nlp.nlp.instruments.parse.representation.basic.DefaultInfo;
import ac.biu.nlp.nlp.instruments.parse.representation.basic.DefaultNodeInfo;
import ac.biu.nlp.nlp.instruments.parse.representation.basic.DefaultSyntacticInfo;
import ac.biu.nlp.nlp.instruments.parse.representation.basic.DependencyRelation;
import ac.biu.nlp.nlp.instruments.parse.representation.basic.DependencyRelationType;
import ac.biu.nlp.nlp.instruments.parse.representation.basic.EdgeInfo;
import ac.biu.nlp.nlp.instruments.parse.representation.basic.Info;
import ac.biu.nlp.nlp.instruments.parse.representation.basic.NamedEntity;
import ac.biu.nlp.nlp.instruments.parse.representation.basic.NodeInfo;
import ac.biu.nlp.nlp.instruments.parse.representation.basic.SyntacticInfo;
import ac.biu.nlp.nlp.representation.CanonicalPosTag;
import ac.biu.nlp.nlp.representation.PartOfSpeech;
import ac.biu.nlp.nlp.representation.UnsupportedPosTagStringException;

/**
 * 
 * @author Asher Stern
 * @since Oct 3, 2012
 *
 */
public class ElementToInfo
{
	public ElementToInfo(XmlTreePartOfSpeechFactory posFactory, Element infoElement)
	{
		super();
		this.posFactory = posFactory;
		this.infoElement = infoElement;
	}



	public void createInfo() throws TreeXmlException
	{
		if (markedAsExist(infoElement))
		{
			String id = createId();
			NodeInfo nodeInfo = createNodeInfo();
			EdgeInfo edgeInfo = createEdgeInfo();
			
			if (null==nodeInfo) throw new TreeXmlException("Malformed XML. Missing node info.");
			if (null==edgeInfo) throw new TreeXmlException("Malformed XML. Missing edge info.");
			if (null==id) throw new TreeXmlException("Malformed XML. Missing id.");
			
			info = new DefaultInfo(id, nodeInfo, edgeInfo);
		}
		else
		{
			info = null;
		}
		
		created=true;
	}
	
	

	public Info getInfo() throws TreeXmlException
	{
		if (!created) throw new TreeXmlException("Not created! Please call the method createInfo()");
		return info;
	}



	private String createId() throws TreeXmlException
	{
		String id = null;
		
		Element idElement = getChildElement(infoElement, ID_ELEMENT_NAME);
		id = getTextOfElement(idElement);
		
		return id;
	}
	
	private NodeInfo createNodeInfo() throws TreeXmlException
	{
		NodeInfo nodeInfo = null;
		
		Element nodeInfoElement = getChildElement(infoElement, NodeInfo.class.getSimpleName());
		if (markedAsExist(nodeInfoElement))
		{
			if (TRUE_VALUE.equals(nodeInfoElement.getAttribute(VARIABLE_ATTRIBUTE_NAME)))
			{
				variable = true;
			}
			else
			{
				variable = false;
			}
			
			String lemma = null;
			Element lemmaElement = getChildElement(nodeInfoElement, LEMMA_ELEMENT_NAME);
			if (markedAsExist(lemmaElement))
			{
				lemma = getTextOfElement(lemmaElement);
			}
			
			String word = null;
			Element wordElement = getChildElement(nodeInfoElement, WORD_ELEMENT_NAME);
			if (markedAsExist(wordElement))
			{
				word = getTextOfElement(wordElement);
			}
			
			NamedEntity namedEntity = null;
			Element namedEntityElement = getChildElement(nodeInfoElement, NamedEntity.class.getSimpleName());
			if (markedAsExist(namedEntityElement))
			{
				String neString = getTextOfElement(namedEntityElement);
				try{namedEntity = NamedEntity.valueOf(neString);}
				catch(IllegalArgumentException e){throw new TreeXmlException("Bad value for named entity \""+neString+"\"",e);}
			}
			
			SyntacticInfo syntacticInfo = null;
			Element syntacticInfoElement = getChildElement(nodeInfoElement, SyntacticInfo.class.getSimpleName());
			if (markedAsExist(syntacticInfoElement))
			{
				PartOfSpeech partOfSpeech = null;
				
				Element partOfSpeechElement = getChildElement(syntacticInfoElement, PartOfSpeech.class.getSimpleName());
				if (markedAsExist(partOfSpeechElement))
				{

					String canonicalPosTagString = getTextOfElement(getChildElement(partOfSpeechElement, CanonicalPosTag.class.getSimpleName()));
					CanonicalPosTag canonicalPosTag = null;
					try{canonicalPosTag = CanonicalPosTag.valueOf(canonicalPosTagString);}
					catch(IllegalArgumentException e){throw new TreeXmlException("Bad value for canonicalPosTag \""+canonicalPosTagString+"\"",e);}

					String posString = getTextOfElement(getChildElement(partOfSpeechElement, POS_STRING_ELEMENT_NAME));

					try
					{
						partOfSpeech = posFactory.createPartOfSpeech(canonicalPosTag, posString);
					}
					catch (UnsupportedPosTagStringException e)
					{
						throw new TreeXmlException("Malformed part of speech: "+posString+" / "+canonicalPosTag.name(),e);
					}
				}

				syntacticInfo = new DefaultSyntacticInfo(partOfSpeech);
			}
			
			int serial = 0;
			Element serialElement = getChildElement(nodeInfoElement, SERIAL_ELEMENT_NAME);
			if (markedAsExist(serialElement))
			{
				serial = Integer.parseInt(getTextOfElement(serialElement));
			}

			
			if (variable)
			{
				String variableIdString = getTextOfElement(getChildElement(nodeInfoElement, VARIABLE_ID_ELEMENT_NAME));
				Integer variableId = Integer.parseInt(variableIdString);
						
				nodeInfo = DefaultNodeInfo.newVariableDefaultNodeInfo(variableId, lemma, serial, namedEntity, syntacticInfo);
			}
			else
			{
				nodeInfo = new DefaultNodeInfo(word, lemma, serial, namedEntity, syntacticInfo);
			}
		}
		
		return nodeInfo;
	}
	
	private EdgeInfo createEdgeInfo() throws TreeXmlException
	{
		EdgeInfo edgeInfo = null;
		Element edgeInfoElement = getChildElement(infoElement, EdgeInfo.class.getSimpleName());
		if (markedAsExist(edgeInfoElement))
		{
			DependencyRelation dependencyRelation = null;
			Element dependencyRelationElement = getChildElement(edgeInfoElement, DependencyRelation.class.getSimpleName());
			if (markedAsExist(dependencyRelationElement))
			{
				Element dependencyRelationStringElement = getChildElement(dependencyRelationElement, DEPENDENCY_RELATION_STRING_ELEMENT_NAME);
				if (markedAsExist(dependencyRelationStringElement))
				{
					String dependencyRelationString = getTextOfElement(dependencyRelationStringElement);
					DependencyRelationType dependencyRelationType = null;
					
					Element dependencyRelationTypeElement = getChildElement(dependencyRelationElement, DependencyRelationType.class.getSimpleName());
					if (markedAsExist(dependencyRelationTypeElement))
					{
						String dependencyRelationTypeString = getTextOfElement(dependencyRelationTypeElement);
						try{dependencyRelationType = DependencyRelationType.valueOf(dependencyRelationTypeString);}
						catch(IllegalArgumentException e){throw new TreeXmlException("Bad value of DependencyRelationType: \""+dependencyRelationTypeString+"\"",e);}
					}
					dependencyRelation = new DependencyRelation(dependencyRelationString,dependencyRelationType);
				}
				
			}
			edgeInfo = new DefaultEdgeInfo(dependencyRelation);
		}
		return edgeInfo;
	}
	
	
	
	
	
	
	
	private boolean markedAsExist(Element element)
	{
		return TRUE_VALUE.equals(element.getAttribute(EXIST_ATTRIBUTE_NAME));
	}
	

	

	private XmlTreePartOfSpeechFactory posFactory;
	private Element infoElement;
	private boolean variable = false;
	
	private boolean created = false;
	private Info info;
}
