package cc.cynara.lanqiao.SFTG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 java实现全排列
 * @author liutao-REMIX 
 *
 */
public class ADV_000_3 {
	 private static int NUM = 4;  
	  
	    /** 
	     * 递归算法：将数据分为两部分，递归将数据从左侧移右侧实现全排列 
	     * 
	     * @param datas 
	     * @param target 
	     */  
	    private static void sort(List datas, List target) {  
	        if (target.size() == NUM) {  
	            for (Object obj : target)  
	                System.out.print(obj);  
	            System.out.println();  
	            return;  
	        }  
	        for (int i = 0; i < datas.size(); i++) {  
	            List newDatas = new ArrayList(datas);  
	            List newTarget = new ArrayList(target);  
	            newTarget.add(newDatas.get(i));  
	            newDatas.remove(i);  
	            sort(newDatas, newTarget);  
	        }  
	    }  
	  
	    public static void main(String[] args) {  
	        String[] datas = new String[] { "1", "1", "2", "3" };  
	        sort(Arrays.asList(datas), new ArrayList());  
	    }  
}
