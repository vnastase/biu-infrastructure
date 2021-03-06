package ac.biu.nlp.nlp.general.text;

public class EmptyTextPreprocessor implements TextPreprocessor
{

	public void setText(String text) throws TextPreprocessorException
	{
		this.text = text;
	}

	public void preprocess() throws TextPreprocessorException
	{
	}

	public String getPreprocessedText() throws TextPreprocessorException
	{
		return this.text;
	}
	
	protected String text;

}
