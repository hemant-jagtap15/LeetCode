/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> s = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        createStack(nestedList);
    }

    @Override
    public Integer next() {
        if(!hasNext()) {
            return null;
        }
        return s.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!s.isEmpty() && !s.peek().isInteger())  {
            List<NestedInteger> list = s.pop().getList();
            createStack(list);
        }
        return !s.isEmpty();
    }

    public void createStack(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            s.add(nestedList.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */