public class BSTUnemployment{
	//attribute
	TreeNode root;
	
	//constructor
	public BSTUnemployment(){
		root = null;
	}
	
	//insertNode method
	public void insertNode(Unemployment u){
		if(root==null)
			root = new TreeNode(u);
		else
			root.insert(u);
	}//end
	
	//displayState method
	public void displayState(double rate){
		displayStateDetails(root,rate);
	}//end
	
	//recursive displayState method
	private void displayStateDetails(TreeNode n, double rt){
		if(n==null)
			return;
		else{
			Unemployment u = (Unemployment)n.data;
			if(u.getRate()<rt){
				System.out.println(u.toString());
				displayStateDetails(n.left,rt);
				displayStateDetails(n.right,rt);
			} else {
				displayStateDetails(n.left,rt);
				displayStateDetails(n.right,rt);
			}
		}//end else
	}//end void

	//average
	public void aveRate(){
		double cr = countTotalRate(root);
		System.out.println("Total unemployment rate in 2016: "+cr);
		int cs = countState(root);
		System.out.println("Total unemployment state in 2016: "+cs);
		double ave = cr / cs ;
		System.out.println("Average unemployment rate in 2016: "+ave);
	}

	//countTotalRate
	private double countTotalRate(TreeNode n){
		if(n==null)
			return 0;
		else{
			Unemployment u2 = (Unemployment)n.data;
			return u2.getRate() + countTotalRate(n.left) + countTotalRate(n.right);
		}
	}
	
	//countState
	
	private int countState(TreeNode n){
		if(n==null)
			return 0;
		else{
			Unemployment u3 = (Unemployment)n.data;
			return 1 + countState(n.left) + countState(n.right);
		}
	}
	
}