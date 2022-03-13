package dfsbfs;

import com.sun.deploy.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *  括号生成
 */
public class GenerateParent {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisDfs(n,n,new Stack<>(),result,new ArrayList<>());
        return result;
    }
    /**
     *  dfs 回溯算法实现
     */
    public static void generateParenthesisDfs(int leftSize,int rightSize, Stack<String> stack, List<String> result, List<String> path) {
        if (leftSize == 0 && rightSize == 0) {
            result.add(StringUtils.join(path, ""));
            return;
        }
        // 横向选择
        List<String>  ParenthesisList = Arrays.asList("(",")");
        for (String item :ParenthesisList){
            String stackTop = stack.isEmpty() ? "" :  stack.peek();
            String chooseStr = "";
            if(leftSize > 0 && "(".equals(item)){
                chooseStr = item;
                stack.add(item);
                leftSize--;
            }
            if(rightSize > 0 && "(".equals(stackTop) && ")".equals(item)){
                chooseStr = item;
                stack.pop();
                rightSize--;
            }
            if(!"".equals(chooseStr) ){
                path.add(item);
                generateParenthesisDfs(leftSize,rightSize,stack,result,path);
                path.remove(path.size() -1);
                // 回溯之前做的事情全部回退
                if("(".equals(item)){
                    stack.pop();
                    leftSize++;
                }
                if(")".equals(item)) {
                    stack.push("(");
                    rightSize++;
                }
            }
        }
    }


    public static void main(String[] args) {
        GenerateParent generateParent = new GenerateParent();

        System.out.println(generateParent.generateParenthesis(3));
    }
}
