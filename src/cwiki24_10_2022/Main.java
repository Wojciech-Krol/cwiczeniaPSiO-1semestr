package cwiki24_10_2022;


public class Main {

    //char litery[]= {'I','V','X','L','C','D','M'};
    static String litery="IVXLCDM";
    static int[] liczby = {1,5,10,50,100,500,1000};

    public static int rzymNa10(String s){
        int odp=0;
        for(int i=s.length()-1;i>=0;i--){
            int indexP=litery.indexOf(s.charAt(i));
            if(i==0){
                odp+=liczby[indexP];
                return odp;
            }
            int indexD=litery.indexOf(s.charAt(i-1));

            if(liczby[indexP]>liczby[indexD]){
                odp+=liczby[indexP];
                odp-=liczby[indexD];
                i--;
            }
            else{
                odp+=liczby[indexP];
            }
        }
        return odp;
    }

    public static String dziesiecNaRzym(int liczba){
        String odp="";
        String tmp;
        int j=0;
        int wartoscZnaku=0;
        while(liczba>0){
            if(liczba>=1000){
                odp+=litery.charAt(6);
                liczba-=liczby[6];
            }
            else {
                while (liczba < liczby[j]) {
                    System.out.println(j);
                    wartoscZnaku = liczby[j + 1];
                    j++;
                }
                tmp=Integer.toString(wartoscZnaku);
                System.out.println(tmp);
                if(tmp.charAt(0)=='1'){
                    liczba-=liczby[j-2];
                    liczba-=liczby[j];
                    odp+=litery.charAt(j-2);
                    odp+=litery.charAt(j);
                }
                else{
                    liczba-=liczby[j-1];
                    liczba-=liczby[j];
                    odp+=litery.charAt(j-1);
                    odp+=litery.charAt(j);
                }
                j=0;
            }
        }
        return odp;
    }

    public static void main(String[] args) {
        System.out.println(dziesiecNaRzym(40));
        System.out.println(rzymNa10("MMMDCCCLXXXVIII"));//1460
        System.out.println("Hello world!");
    }
}