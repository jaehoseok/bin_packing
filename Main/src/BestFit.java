import java.util.ArrayList;

public class BestFit implements Fit {
    @Override
    public void fit(ArrayList<Bin> arr, Item item) {
        Bin bin = new Bin();

        if(arr.size() == 0){
            bin.update(item);
            arr.add(bin);
            return;
        }
        else {
            int min = 10;
            for (int i = 0; i < arr.size() ; i++) {
                bin = arr.get(i);
                if(bin.check(item)) {
                    if (min > bin.remainCapacity - item.weight) min = i;
                }
            }

            if(min == 10) {
                bin = new Bin();
                bin.update(item);
                arr.add(bin);
            }
            else {
                bin = arr.get(min);
                bin.update(item);
            }
        }
    }
}