package ac.biu.nlp.nlp.datasets.rte6main;


/**
 * 
 * @author Asher Stern
 * @since Jan 2, 2011
 *
 */
public class TestsetRte6MainFileSystemNames extends DefaultRte6MainFileSystemNames implements Rte6FileSystemNames
{
	@Override
	public String getGoldStandardFileName()
	{
		return Rte6MainConstants.TESTSET_GOLD_STANDARD_FILE_NAME;
	}

}
