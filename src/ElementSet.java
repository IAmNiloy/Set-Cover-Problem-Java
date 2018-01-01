import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

// This class holds a set ID, it's cost, and the element IDs that the set covers
public class ElementSet implements Comparable {

	private int _id; // Set ID
	private double _cost; // Cost of using this Set ID
	private SortedSet<Integer> _elements; // Element IDs that this set covers
	
	// Initialize this ElementSet
	public ElementSet(int id, double cost, Collection<Integer> elements) {
		_id = id;
		_cost = cost;
		_elements = new TreeSet<Integer>(elements);
	}
	
	// Simple getters
	public int getId()      { return _id;   }
	public double getCost() { return _cost; }
	public SortedSet<Integer> getTheseEs(){
		TreeSet<Integer> temp = new TreeSet<Integer>();
		temp.addAll(_elements);
		return temp;
	}
	// Returns the number of element IDs in this set that cover element IDs in elements_to_cover.
	// You'll find this very useful during the greedy algorithm implementation.
	public int countElementsCovered(Set<Integer> elements_to_cover) {
		int count = 0;
		if(_elements.size() < elements_to_cover.size()){
			for(int i : _elements){
				if(elements_to_cover.contains(i))
					count++;
			}
		}
		else {
			for(int i : elements_to_cover){
				if(_elements.contains(i))
					count++;
			}
		}
		return count; // TODO
	}

	@Override
	public int compareTo(Object o) {
		// TODO: We inherit from the Comparable interface that allows this object to
		//       be stored in a SortedSet so we need to implement this method.  It should
		//       put ElementSet's with lower Set IDs earlier in a comparison ordering.
		//       See supplementary lecture slides or just use Google to understand what
		//       this method returns.
		if(!(o instanceof ElementSet))
			return 1;
		
		ElementSet e = (ElementSet)o;
		
		if(this._id != e._id)
			return (this._id - e._id);
		
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO: Many set-based methods such as add(...) and contains(...) require equals to 
		//       be defined properly, otherwise multiple copies of an equivalent object
		//       may be stored on add(...) and contains(...) would not work as intended.
		//       See supplementary lecture slides or just use Google to understand what
		//       this method returns.
		if(!(o instanceof ElementSet))
			return false;
		ElementSet e = (ElementSet)o;		
		return _cost == e._cost && _id == e._id;
	}
	
	// With the following method, we can write 
	//   for (Integer i : getElementIteratable()) { 
	//      do something with i;
	//   }
	// so that we can iterate through the Integer elements in 
	// this class *without having any further ability to modify* 
	// the underlying _elements instance.  See SCPModel for a  
	// similar method and how it is used in toString() there.
	public Iterable<Integer> getElementIterable() {
		return (Iterable<Integer>)_elements;
	}
	
	@Override
	public String toString() {
		return String.format("Set ID: %3d   Cost: %6.2f   Element IDs: %s", _id, _cost, _elements);
	}
}
