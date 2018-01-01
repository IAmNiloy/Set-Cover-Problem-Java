
public class GreedyCoverageSolver extends GreedySolver {
	
	public GreedyCoverageSolver() {
		this._name = "Greedy coverage heuristic";
		this.reset();
	}
	
	@Override
	public ElementSet nextBestSet() {
		int max_amount = 0;
		int amount = 0;
		ElementSet Best = null;
		for(ElementSet e : _model.getElementSetIterable()){
		amount = e.countElementsCovered(_elementsNotCovered);
		if(amount > max_amount){
			max_amount = amount;
			Best = e;
		}
		}
		if(max_amount == 0)
			return null;
		return Best; // TODO: Implement this
	}
	
}
