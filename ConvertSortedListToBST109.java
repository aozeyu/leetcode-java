import java.util.*;


public class ConvertSortedListToBST109
{
  public TreeNode sortedListToBST(ListNode head) {
    List<TreeNode> nodes = new ArrayList<TreeNode>();
    storeBSTNodes(head,nodes);
    int n = nodes.size();
    return buildBST(nodes,0,n -1);
  }

  private void storeBSTNodes(ListNode head,List<TreeNode> nodes) {
    while (head != null) {
      nodes.add(new TreeNode(head.val));
      head = head.next;
    }
  }

  private TreeNode buildBST(List<TreeNode> nodes,int start,int end) {
    if (start > end) {
      return  null;
    }
    int mid = (start + end) / 2;
    TreeNode node = nodes.get(mid);

    node.left = buildBST(nodes,start,mid - 1);
    node.right = buildBST(nodes ,mid + 1, end);
    return  node;
  }

  public static void main(String[] args) {
    ConvertSortedListToBST109 sl2bst = new ConvertSortedListToBST109();

  }



}
