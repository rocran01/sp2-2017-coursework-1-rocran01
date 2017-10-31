import java.util.*;

/**
 * A StringAnalyser can perform various analyses for several Strings
 * that have been added to it before. In this sense, a StringAnalyser
 * is an "intelligent container" for Strings.
 *
 * The analysis results do not depend on the order in which the Strings
 * have been added since object creation or the last call to the reset()
 * method (if any). Added null elements are ignored by the analyses.
 * Repeated occurrences of the same/equal Strings are allowed.
 *
 * @author RobertOcran
 */
public class StringAnalyser {

    // TO DO: add and document instance variable(s)
	private static ArrayList<String> stringsArray;
	private static final double EMPTY_VALUE=-1.0;
    /**
     * Constructs a new StringAnalyser without any Strings.
     */
    public StringAnalyser() {
        // TO DO: write constructor
    	stringsArray = new ArrayList<>();
    	}

    /**
     * Constructs a new StringAnalyser containing the non-null Strings in
     * strings. The strings array may be modified by the caller afterwards
     * without affecting this StringAnalyser, and it will not be modified by
     * this constructor.
     *
     * @param strings  must not be null; non-null elements are added to the
     *  constructed StringAnalyser
     */
    public StringAnalyser(String[] strings) {
        // TO DO: write constructor
    	this();
    	for(String element: strings){
    		if(element!=null){
    			stringsArray.add(element);	
    		}
    	}
    }

    /**
     * Adds a String s to this StringAnalyser if s is not null;
     * does not modify this StringAnalyser otherwise.
     *
     * @param s  to be added toStringAnalyser.stringsArray this StringAnalyser
     * @return true if s is not null, false otherwise
     */
    public boolean add(String s) {
        // TO DO: write proper method body
    	if(s==null){
    		return false;
    	}
    	else{
        	stringsArray.add(s);
        	return true;
        }
    }

    /**
     * Adds all non-null Strings in strings to this StringAnalyser.
     *
     * @param strings  contains the String objects to be added to
     *  this StringAnalyser; must not be null (but may contain null)
     * @return true if at least one element of strings is non-null;
     *  false otherwise
     */
    public boolean addAll(String[] strings) {
        // TO DO: write proper method body
    	int flag=0;
    	if(strings[flag]==null){return false;}
    	else{
    	for(String element: strings){
    			stringsArray.add(element);
    		}
    	return true;
    	}
    }

    /**
     * Resets this StringAnalyser to a StringAnalyser that contains 0 Strings.
     */
    public void reset() {
        // TO DO: write proper method body
    	stringsArray.clear();;
    }

    /**
     * Returns how many non-null Strings this StringAnalyser contains.
     *
     * @return how many non-null Strings this StringAnalyser contains
     */
    public int numberOfStrings() {
        // TO DO: write proper method body
    	int numberOfStrings = stringsArray.size();
        return numberOfStrings;
    }

    /**
     * Returns how many distinct non-null Strings this StringAnalyser
     * contains. We say that two non-null Strings x and y are
     * <i>distinct</i> if x.equals(y) evaluates to false.
     *
     * @return how many distinct non-null Strings this StringAnalyser contains
     */
    public int numberOfUniqueStrings() {
        // TO DO: write proper method body
    	HashSet<String> hset= new HashSet<>();
    	for(String element:stringsArray ){
    			hset.add(element);
    	}
        return hset.size();
    }

    /**
     * Returns the sum of the lengths of all (non-null) Strings in this StringAnalyser.
     *
     * @return the sum of the lengths of all (non-null) Strings in this StringAnalyser
     */
    public int totalLength() {
        // TO DO: write proper method body
    	int total=0;
    	for(String element:stringsArray ){
    		total += element.length();
    	}
        return total;
    }


    /**
     * Class method to return the sum of all String lengths in all elements
     * of analysers. For example, if analysers contains two StringAnalysers,
     * one with the contents "Alice" and "Bob" and one with the contents
     * "George", the result will be (5 + 3) + 6 = 14.
     *
     * Entries of the array analysers may be null, and these entries should be
     * ignored in the computation. So if in the above example we had an
     * additional third array entry null, the result would be exactly
     * the same.
     *
     * @param analysers  must not be null, but may contain null
     * @return the sum of all (non-null) String lengths in all elements of analysers
     */
    public static int totalLength(StringAnalyser[] analysers) {
        // TO DO: write proper method body
    	int totalLen=0;
    	for (StringAnalyser element: analysers){
    		totalLen += element.totalLength();
    	}
    	return totalLen;
    }

    /**
     * Returns the average length of the (non-null) Strings in this StringAnalyser.
     * In case there is no String in this StringAnalyser, -1.0 is returned.
     *
     * For example, if this StringAnalyser has the contents "A" and "Bc",
     * the result is 1.5.
     *
     * @return the average length of the Strings in this StringAnalyser,
     *  or -1.0 if there is no such String.
     */
    public double averageLength() {
        // TO DO: write proper method body
    	double aver = totalLength();
    	if(stringsArray.isEmpty()){return EMPTY_VALUE;}
    	else{return aver/stringsArray.size();}  
    }

    /**
     * Returns how many of the Strings in this StringAnalyser contain
     * at least one upper-case character.
     *
     * For example, if this StringAnalyser contains "a", "bC", and
     * "DEfGH", the result is 2 ("a" is not counted because it does
     * not contain an upper-case character, but the other two Strings
     * contain at least one upper-case character each, so they are both
     * counted).
     *
     * @return the number of Strings in this StringAnalyser that
     *  contain at least one upper-case character, as determined by
     *  the class method boolean isUpperCase(char c) of the class Character
     */
    public int numberOfStringsWithUpperCaseChars() {
        // TO DO: write proper method body
    	
    	int count= 0;
    	for(String element:stringsArray ){
    		int strLen= element.length();
    		for(int i=0; i< strLen; i++){
    		if (Character.isUpperCase(element.charAt(i))) {count++;
    		    break;} 
    		}
    	}
        return count;
    }

    /**
     * Returns the greatest String in this StringAnalyser with respect
     * to the "natural ordering" of String, which is induced by the
     * instance method boolean compareTo(String s) of the class String.
     *
     * @return the greatest String in this StringAnalyser, where "greatest"
     *  is defined with respect to String.compareTo(String s); null if this
     *  StringAnalyser contains no String objects.
     */
    public String getGreatest() {
        // TO DO: write proper method body
    	int r=0;
    	int w=1;
    	int start=0;
    	int position=0;
    	String comElement="";
    	if(stringsArray.isEmpty())
    		{return null;}
    	else if(stringsArray.size()==1 ){return stringsArray.get(0);}
    	
    	else{
    		
    		for(int i=0;i<stringsArray.size(); i++ ){
    			comElement=stringsArray.get(i);
    			for(int j=1;j<stringsArray.size();j++){
    					int greatest =comElement.compareTo(stringsArray.get(j));
    					if(greatest==0){j++;}
    					if(greatest>start){position = i;
    						start=greatest;}	
    			}		
    		}
    		return stringsArray.get(position);
    	}
    	
    }

    /**
     * Returns a String representation for the contents of this
     * StringAnalyser.
     *
     * The String representation starts with a "[" and ends with a "]".
     * The Strings are separated by ", ". The order of the Strings from
     * this StringAnalysis in its String representation is
     * implementation-specific (i.e., it does not matter, and callers
     * should not rely on any particular order).
     *
     * For example, if this StringAnalyser contains the Strings
     * "Alice", "Bob", and "Alice", the three possible valid
     * results are "[Alice, Bob, Alice]" or "[Alice, Alice, Bob]"
     * or "[Bob, Alice, Alice]".
     *
     * @return a String representation of the Strings that have been added
     *  to this in the constructor or via the add/addAll methods
     *  since object construction or since the last reset() (if any) 
     */
    public String toString() {
    	String toString="";
    	if(stringsArray.isEmpty()){return "[]";}
    	else{
    		for(int i=0;i<stringsArray.size() ; i++ ){
				if(i==stringsArray.size()-1){toString += stringsArray.get(i);}
				else{toString += stringsArray.get(i)+", ";}
			}	
		}
		return "["+toString+"]";
    	}
	}
