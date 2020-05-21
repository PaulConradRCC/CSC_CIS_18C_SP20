
/**
 Class invariant: The tree satisfies the binary search tree storage rule.
*/
public class IntTree
{
    private static class IntTreeNode
    {
        private int data;
        private IntTreeNode leftLink;
        private IntTreeNode rightLink;

        public IntTreeNode(int newData, IntTreeNode newLeftLink,
                                        IntTreeNode newRightLink)
        {
             data = newData;
             leftLink = newLeftLink;
             rightLink = newRightLink;
        }
    } //End of IntTreeNode inner class


    private IntTreeNode root;

    public IntTree( )
    {
        root = null;
    }

    public void add(int item)
    {
        root = insertInSubtree(item, root);
    }

    public boolean contains(int item)
    {
        return isInSubtree(item, root);
    }

    public void inorder( )
    {
        showElementsInSubtree(root);
        System.out.println();
    }

    public void preorder()
    {
        showElementsPreOrderSubtree(root);
        System.out.println();
    }

    public void postorder()
    {
        showElementsPostOrderSubtree(root);
        System.out.println();
    }
	
    /**
     Returns the root node of a tree that is the tree with root node
     subTreeRoot, but with a new node added that contains item.
    */
    private static IntTreeNode insertInSubtree(int item, IntTreeNode subTreeRoot)
    {
        if (subTreeRoot == null)
            return new IntTreeNode(item, null, null);
        else if (item < subTreeRoot.data)
        {
            subTreeRoot.leftLink = insertInSubtree(item, subTreeRoot.leftLink);
            return subTreeRoot;
        }
        else //item >= subTreeRoot.data
        {
            subTreeRoot.rightLink = insertInSubtree(item, subTreeRoot.rightLink);
            return subTreeRoot;
        }
    }

    private static boolean isInSubtree(int item, IntTreeNode subTreeRoot)
    {
        if (subTreeRoot == null)
            return false;
        else if (subTreeRoot.data == item)
            return true;
        else if (item < subTreeRoot.data)
            return isInSubtree(item, subTreeRoot.leftLink);
        else //item >= link.data
            return isInSubtree(item, subTreeRoot.rightLink);
    }

    private static void showElementsInSubtree(IntTreeNode subTreeRoot)
    {//Uses inorder traversal.
        if (subTreeRoot != null)
        {
            showElementsInSubtree(subTreeRoot.leftLink);
            System.out.print(subTreeRoot.data + " ");
            showElementsInSubtree(subTreeRoot.rightLink);
        }//else do nothing. Empty tree has nothing to display.
    }
	
	private static void showElementsPreOrderSubtree(IntTreeNode subTreeRoot)
    {//Uses inorder traversal.
        if (subTreeRoot != null)
        {
            System.out.print(subTreeRoot.data + " ");
            showElementsPreOrderSubtree(subTreeRoot.leftLink);
            showElementsPreOrderSubtree(subTreeRoot.rightLink);
        }//else do nothing. Empty tree has nothing to display.
    }
	
	private static void showElementsPostOrderSubtree(IntTreeNode subTreeRoot)
    {//Uses inorder traversal.
        if (subTreeRoot != null)
        {			
            showElementsPostOrderSubtree(subTreeRoot.leftLink);
            showElementsPostOrderSubtree(subTreeRoot.rightLink);
            System.out.print(subTreeRoot.data + " ");
        }//else do nothing. Empty tree has nothing to display.
    }
}
