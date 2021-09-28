class AplicativoCalorias{
    public static void main(String[] args){
        int e1 = MyIO.readInt();
        int e2 = MyIO.readInt();
        int e3 = MyIO.readInt();
        int x = MyIO.readInt();
        if((e1 - e2) <= x){
            MyIO.println(e2);
        }else if((e1 - e2) > x){
            MyIO.println(e3);
        }
    }
    
}