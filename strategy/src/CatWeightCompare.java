/**
 * @author cky
 * @create 2020 2 24 20:36
 */
public class CatWeightCompare implements  Comparator<Cat>{

    @Override
    public int compare(Cat a, Cat b) {
        if(a.weight>b.weight)   return 1;
        else if(a.weight<b.weight)   return -1;
        else return 0;
    }
}
