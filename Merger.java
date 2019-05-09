/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
		ArrayList<String> myArray = new ArrayList<String>();
		for(int index = 0; index < usersData.size(); index++){
			myArray.add(usersData.get(index));
		}
		int endOfFirst = start1;
		int currentIndex = start0;
		while(start0 < endOfFirst && start1 < nItems){ //Dreaded while loops seems neccessary here
			if (usersData.get(start0).compareTo(usersData.get(start1)) < 0){
				myArray.set(currentIndex, usersData.get(start0));
				start0++;
			}
			else{
				myArray.set(currentIndex, usersData.get(start1));
				start1++;
			}
			currentIndex++;
		}
		while (start0 < endOfFirst){ //Could also be for-loops but far less perspicuous
			myArray.set(currentIndex, usersData.get(start0));
			start0++;
			currentIndex++;
		}
		while (start1 < nItems){
			myArray.set(currentIndex, usersData.get(start1));
			start1++;
			currentIndex++;
		}
		usersData = myArray;
	}


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}