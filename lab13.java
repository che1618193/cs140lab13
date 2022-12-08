import java.util.ArrayList;
class lab13{
    private ArrayList<Integer> values;
    lab13(){
        values = new ArrayList<Integer>();
    }
    public void readData(String filename){
    	try
        {
            java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
            String inn;

            inn = input.readLine();
            while(inn != null)
            {
                values.add(Integer.parseInt(inn));
                inn = input.readLine();
            }

            input.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
            System.exit(0);
        }
    }
    public long getTotalCount(){
        return values.stream().count();
    }
    public long getOddCount(){
    	return values.stream().filter(x -> x % 2 == 1).count();
    }
    public long getEvenCount(){
    	return values.stream().filter(x -> x % 2 == 0).count();
    }
    public long getDistinctGreaterThanFiveCount(){
    	return values.stream().distinct().filter(x -> x > 5).count();
    }
    public Integer[] getResult1(){
    	return values.stream().filter(x -> x % 2 == 0 && x > 5 && x < 50).sorted().toArray(Integer[]::new);
    }
    public Integer[] getResult2(){
    	return values.stream().map(x -> x * x * 3).limit(50).toArray(Integer[]::new);
    }
    public Integer[] getResult3(){
    	return values.stream().filter(x -> x % 2 == 1).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
    }
}