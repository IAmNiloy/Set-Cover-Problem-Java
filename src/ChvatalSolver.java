
public class ChvatalSolver extends GreedySolver {
	
	public ChvatalSolver() {
		this._name = "Chvatal's algorithm";
		this.reset();
	}
	
	@Override
	public ElementSet nextBestSet() {
		double minratio = Double.MAX_VALUE;
		double ratio;
		ElementSet Best = null;
		for(ElementSet e : _model.getElementSetIterable()){
		ratio = e.getCost() / e.countElementsCovered(_elementsNotCovered);
		if( ratio < minratio){
			minratio = ratio;
			Best = e;
		}
	}
		return Best; // TODO: Implement this
}
}
