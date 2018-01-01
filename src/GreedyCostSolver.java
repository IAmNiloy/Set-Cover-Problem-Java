import java.util.SortedSet;

public class GreedyCostSolver extends GreedySolver {
	
	public GreedyCostSolver() {
		this._name = "Greedy cost heuristic";
		this.reset();
	}
	
	@Override
	public ElementSet nextBestSet() {
		ElementSet Best = null;
        for (ElementSet e : _model.getElementSetIterable()) {
            if (e.countElementsCovered(_elementsNotCovered)== 0 || Best != null && e.getCost() >= Best.getCost()) 
            	continue;
            Best = e;
        }
        return Best;
    }
	}
