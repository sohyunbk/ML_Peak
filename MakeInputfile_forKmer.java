import java.io.*;  // Import the File class
import java.util.*; // Import the Scanner class to read text files

public class MakeInputfile_forKmer{
  public static void main(String[] args) throws IOException{
      //Step1: Save dna seqeunce in list or string whatever
      File myObj = new File("1.fa");
      Scanner myReader = new Scanner(myObj);
      String sFirstLine = myReader.nextLine();
      //System.out.println(myReader.nextLine());
      ArrayList<String> Chr1List  = new ArrayList<String>();
      while (myReader.hasNextLine()) {
      String sLine = myReader.nextLine();
      Chr1List.add(sLine);
	}      
      myReader.close();
      //System.out.println(Chr1List.get(0));
      File myObj2 = new File("ARF4.GEM_events.narrowPeak");
      //FileWriter myWriter = new FileWriter(".fa");
      Scanner myReader2 = new Scanner(myObj2);
      ArrayList<Integer> Peak_Start  = new ArrayList<Integer>();
      ArrayList<Integer> Peak_End  = new ArrayList<Integer>();
      while (myReader2.hasNextLine()) {
	String sLine2 = myReader2.nextLine();
	String[] sList = sLine2.split("\t");
	int Start = Integer.parseInt(sList[1]);
	int End = Integer.parseInt(sList[2]);
	Peak_Start.add(Start);
	Peak_End.add(End);
	}
	myReader.close();
      
      ArrayList<Integer> NPeak_Start  = new ArrayList<Integer>();
      ArrayList<Integer> NPeak_End  = new ArrayList<Integer>();
      for (int i =0;i<(Peak_Start.size()-1);i++){
        int NewRegionS = Peak_End.get(i);
	int NewRegionE = Peak_Start.get(i+1);
	if( (NewRegionE-NewRegionS) > 2200){
          //Should get random sequence Here..
           for(int j=(NewRegionS+200);j<(NewRegionS+2000);j+=200){
 		NPeak_Start.add(j);
		NPeak_End.add(j+200);
          } 
	}	

       }
     //myWriter.close();
     //********* start Write File using Chr1List
     FileWriter PositiveF = new FileWriter("all_pos.fasta");
     
     PositiveF.close()
    // make method and then put outfileName and two arraylist to write the file!! 
 
    }
  }
