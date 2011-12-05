import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author aditya
 * Implementation of the problem in codeJam 2008 Qualification rounds.
 * http://code.google.com/codejam/contest/dashboard?c=32013
 * 
 */
public class J2008Universe {

	private static Map<String,Integer> searchEngineIndexMap = null;
	
	private static Boolean[] searchEngineHitCount = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputFileName = null;
		String outputFileName = null;
		
		Integer numberOfTestCases = null;
		
		Scanner sc = null;

		if (args.length == 2) {
			inputFileName = args[0];
			outputFileName = args[1];
		} else {
			System.out
					.println("Error: Only Two arguments are required.\n" +
							"1.Input File Name.\n" +
							"2.Output File Name.\n");
			System.exit(-1);
		}
		try {
			sc = new Scanner(new FileReader(inputFileName));
		} catch (FileNotFoundException fe) {
			System.out.println("Error: File Not Found Exception: "
					+ inputFileName);
			System.exit(-1);
		}
		numberOfTestCases = (Integer)sc.nextInt();
		for(int i=0;i<numberOfTestCases;i++){
			
			Integer numberOfInputSets = null;
			Integer numberOfSearchEngines = null;
			searchEngineIndexMap = null;
			searchEngineIndexMap = new HashMap<String,Integer>();
			Integer switchCount = 0;
			numberOfSearchEngines = (Integer)sc.nextInt();
			sc.nextLine();
			searchEngineHitCount = new Boolean[numberOfSearchEngines];
			for(int j=0;j<numberOfSearchEngines;j++){
				searchEngineHitCount[j] = false;
				String searchEngineName = sc.nextLine();
				searchEngineIndexMap.put(searchEngineName, j);
			}
			numberOfInputSets = (Integer)sc.nextInt();
			sc.nextLine();
			Integer searchEngineCount = 0;
			for(int j=0;j<numberOfInputSets;j++){
				String searchEngine = sc.nextLine();
				if(!searchEngineHitCount[searchEngineIndexMap.get(searchEngine)]){
					searchEngineCount++;
					searchEngineHitCount[searchEngineIndexMap.get(searchEngine)] = true;
				}
				if(searchEngineCount==numberOfSearchEngines){
					for(int k =0;k<numberOfSearchEngines;k++){
						searchEngineHitCount[k] = false;
					}
					searchEngineHitCount[searchEngineIndexMap.get(searchEngine)] = true;
					if(j!=numberOfInputSets-1 || numberOfSearchEngines == 2)
					switchCount++;
					searchEngineCount = 1;
				}
			}
		System.out.println("Case #"+(i+1)+": "+switchCount);
		}
		
		sc.close();
	}
	}
