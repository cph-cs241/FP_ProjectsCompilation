
package cjs;

import java.util.Stack;

/**
 *
 * @author Cherry Rose Semeña
 */
public class Tower {
    private Stack<Disk> disks = new Stack<>();

    public Tower(int count) {
        for (int size = count+1; size > 1; size--) {
            disks.push(new Disk(size));
        }
    }
    
    public boolean moveTo(Tower other){
        if(disks.isEmpty()) return false;
        if(!other.disks.isEmpty() && 
                this.disks.peek().getSize() > other.disks.peek().getSize())
            return false;
        other.disks.push(this.disks.pop());
        
        return true;
    }
    public boolean moveToRec(Tower other){
        if(disks.isEmpty()) return false;
        if(!other.disks.isEmpty() && 
                this.disks.peek().getSize() > other.disks.peek().getSize())
            return false;
        other.disks.push(this.disks.pop());
        System.out.println("here:" + other.disks.size());
        moveToRec(other);
        return true;
    }
    
    public String text(int height){
         if (height >= disks.size()) return "            |            ";
    return disks.get(height).text();
    }
    
    
}
