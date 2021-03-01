class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        List<String> curstr=new ArrayList<>();
        dfs(n, cur, curstr, result);
        return result;
    }
  public void dfs(int n, List<Integer> cur, List<String> curstr, List<List<String>>     result){
    if(cur.size()==n){
    result.add(new ArrayList<String>(curstr));
    return;
    }
    for(int i=0;i<n;i++){
    if(valid(cur, i)){
        char[] array=new char[n];
        Arrays.fill(array, '.');
        array[i]='Q';
        cur.add(i);
        curstr.add(new String(array));
        dfs(n, cur, curstr, result);
        cur.remove(cur.size()-1);
        curstr.remove(curstr.size()-1);
        }
    }
    }
    
  public boolean valid(List<Integer> cur, int col){
    int row=cur.size();
    for(int i=0;i<row;i++){
    if(cur.get(i)==col||(Math.abs(cur.get(i)-col)==row-i)){
    return false;
    }
    }
    return true;
    }
}