    package java_lab3;
    import java.util.Scanner;

    public class TicTacTok {
        private String[][] map = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        private player current_player = player.X;
        
        public TicTacTok() {
        }

        public void TTTpaly() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("start TicTacTok game");
            while (true){
                while(true){
                    print_map();
                    System.out.printf("player%s : ", current_player.toString());
                    String a = scanner.nextLine();
                    String[] number = a.split(" ");
                    int x = Integer.parseInt(number[0]);
                    int y = Integer.parseInt(number[1]);
                    if(map[y][x].equals(" ")){ // 문자열 비교는 equals 메서드를 사용해야 합니다.
                        if (current_player == player.X) map[x][y] = "X"; // 여기서 "O"가 아니라 "X"로 변경
                        else map[x][y] = "O";
                        break;
                    }
                    System.out.println("Input one more time.");
                }
                if(check_win()){
                    print_map();
                    System.out.printf("Winner : %s\n", current_player);
                    break;
                }
                if(game_set()){
                    System.out.println("Game set");
                    break;
                }

                current_player = (current_player == player.X) ? player.O : player.X;
            }
        }

        private boolean check_win(){
            if (map[0][0].equals(map[0][1]) && map[0][1].equals(map[0][2]) && map[0][1] != " " ) return true;
            if (map[1][0].equals(map[1][1]) && map[1][1].equals(map[1][2]) && map[1][2] != " " ) return true;
            if (map[2][0].equals(map[2][1]) && map[2][1].equals(map[2][2]) && map[2][2] != " " ) return true;
            if (map[0][0].equals(map[1][0]) && map[1][0].equals(map[2][0]) && map[2][0] != " " ) return true;
            if (map[0][1].equals(map[1][1]) && map[1][1].equals(map[2][1]) && map[2][1] != " " ) return true;
            if (map[0][2].equals(map[1][2]) && map[1][2].equals(map[2][2]) && map[2][2] != " " ) return true;
            if (map[0][0].equals(map[1][1]) && map[1][1].equals(map[2][2]) && map[2][2] != " " ) return true;
            if (map[0][2].equals(map[1][1]) && map[1][1].equals(map[0][0]) && map[2][2] != " " ) return true;
            return false;
        }

        private boolean game_set(){
            for(int i =0 ; i < 3 ; i++){
                for(int j = 0 ; j < 3 ; j++){
                    if(map[i][j].equals(" ")){
                        return false;
                    }
                }
            }
            return true;
        }

        private void print_map() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
    enum player {X, O}
