import java.util.ArrayList;

public class WorstFit implements Fit {
    @Override
    public void fit(ArrayList<Bin> arr, Item item) {
        Bin bin = new Bin();

        if(arr.size() == 0){
            bin.update(item);
            arr.add(bin);
            return;
        }
        else {
            int max = -1;
            for (int i = 0; i < arr.size() ; i++) {
                bin = arr.get(i);
                if(bin.check(item)) {
                    if (max < bin.remainCapacity - item.weight) max = i;
                }
            }
            if(max == -1) {
                bin = new Bin();
                bin.update(item);
                arr.add(bin);
            }
            else {
                bin = arr.get(max);
                bin.update(item);
            }
        }
    }
}