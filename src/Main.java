import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(sc.nextLine());
        int S = 0;

        for(int i=0; i<M; i++){
            String line = sc.nextLine();
            String[] orders = line.split(" ");
            String order = orders[0];
            int num=0;
            if(orders.length > 1) {
                num = Integer.parseInt(orders[1])-1;
            }

            if(order.equals("add")){
                S = (S | (1 << num));
            }else if(order.equals("check")){
                int check = S & (1 << num);
                if( check != 0) {
                    sb.append("1\n");
                }else {
                    sb.append("0\n");
                }
            }else if(order.equals("remove")){
                S = (S & ~(1 << num ));
            }else if(order.equals("toggle")){
                S = (S ^ (1 << num ));
            }else if(order.equals("all")){
                S = ((1<<20) -1);
            }else if(order.equals("empty")){
                S = 0;
            }

        }

        System.out.println(sb.toString());

    }

    void answer() {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int s = 0; //전체집합
        StringBuilder sb = new StringBuilder();


        for(int i=0; i<T; i++){
            String tempOrder = sc.nextLine();
            String[] orders = tempOrder.split(" ");
            String order = orders[0];
            System.out.println(i+": "+order);

            if(order.equals("add")) {
                int num = Integer.parseInt(orders[1])-1;
                s = (s | (1 << num));
            } else if(order.equals("remove")) {
                int num = Integer.parseInt(orders[1])-1;
                s = ( s & ~(1 << num));
            } else if(order.equals("check")) {
                int num = Integer.parseInt(orders[1])-1;
                int check = s & (1 << num);
                if(check != 0) {
                    sb.append("1\n");
//                    System.out.println('1');
                } else {
                    sb.append("0\n");
//                    System.out.println('0');
                }
            } else if(order.equals("toggle")) {
                int num = Integer.parseInt(orders[1])-1;
                s = s ^ (1 << num);
            } else if(order.equals("all")) {
                s = (1<<20)-1;
            } else if(order.equals("empty")) {
                s = 0;
            }
        }

        System.out.println(sb.toString());
    }
}
