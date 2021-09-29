import java.util.Stack;

public class 크레인인형뽑기게임 {

  public static int solution(int[][] board, int[] moves) {
    int answer = 0;

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < moves.length; i++) {
      int clamp = moves[i] - 1;

      for (int j = 0; j < board.length; j++) {

        if(board[j][clamp] != 0) {
          int doll = board[j][clamp];
          board[j][clamp] = 0;

          if(!stack.empty() && stack.peek() == doll){
            answer += 2;
            stack.pop();
            break;
          }
          else {
            stack.push(doll);
            break;
          }
        }
      }
    }

    // System.out.println(stack.toString());
    return answer;
  }

  public static void main(String[] args) {
    int N = 5;

    int[][] board = {
      {0,0,0,0,0}, 
      {0,0,1,0,3},
      {0,2,5,0,1},
      {4,2,4,4,2},
      {3,5,1,3,1}
    };

    int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
    
    System.out.println(solution(board, moves));
  }
}


