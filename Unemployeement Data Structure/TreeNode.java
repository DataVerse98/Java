//Treenode class for primitive int data type
public class TreeNode{
	//attributes
	TreeNode left;
	TreeNode right;
	Unemployment data;
	
	//methods
	//default constructor
    public TreeNode(){
		left = null;
		right = null;
		data = null;
	}
	
	//normal constructor
	public TreeNode(Unemployment d){
		left = null;
		right = null;
		data = d;
	}
	
	//insert methods
	public void insert(Unemployment d){
		if(d.getRate() < data.getRate()){ //add to the left of data 
		  if(left == null) //left is empty
		   left = new TreeNode(d);
		  else 
			  left.insert(d);
		}
		  else if (d.getRate()>=data.getRate()){ //add to right of data
			  if(right == null) //right is empty
			  right = new TreeNode(d);
			  else 
				  right.insert(d);
		  }
	}
}