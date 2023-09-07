
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s652803
 */
public class UnitTesting {
    
    
    public int numBuses(int n){
        
        return (int)(n/50.0);
    }
    
    public ArrayList<Double> stock_price_summary(ArrayList<Double> priceChanges){
        ArrayList<Double> changes = new ArrayList<>();
        double gains = 0, losses = 0;
        for(int i = 0; i < priceChanges.size(); i++){
            double pos = priceChanges.get(i);
            if(pos >= 0)
                gains+= pos;
            else
                losses+= pos;
        }
        changes.add(gains);
        changes.add(losses);
        return null;
             
    }
    
    public void swap_k(ArrayList l, int k){
          for(int i = 0; i < k; i++){
              int spot = l.size() - k + i;
              Object first = l.get(i);   
              Object last = l.get(spot);
              l.set(i, last);
              l.set(spot, first);         
          }
    }
}
