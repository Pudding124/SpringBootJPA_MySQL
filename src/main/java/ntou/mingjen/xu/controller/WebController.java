package ntou.mingjen.xu.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ntou.mingjen.xu.model.Customer;
import ntou.mingjen.xu.repository.CustomerRepository;

@RestController
public class WebController {
   @Autowired
   CustomerRepository repository;
     
   @RequestMapping(value="/save",method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
   public String process(@RequestBody String re){
     //  repository.save(new Customer("Jackk", "Smith",1,"J321", "dsdfs",4));
       List order= new ArrayList<>();
       ArrayList mealNameOrder = new ArrayList();
       ArrayList mealNumberOrder = new ArrayList();
		if(re != null){
           try {
               //根据json字符串生成JSONObject
               JSONObject object=new JSONObject(re);
               JSONArray jsonArray = object.getJSONArray("meal");
               System.out.println(object.optInt("serialNumber"));
               System.out.println(object.optString("id"));
               System.out.println(object.optInt("sumPrice"));
               System.out.println(object.optString("time"));
               
               for (int i = 0; i < jsonArray.length(); i++) {
                   JSONObject jsonObject = jsonArray.getJSONObject(i);  
                   String mealType = jsonObject.optString("mealType");
                   String mealName = jsonObject.optString("mealName");
                   int mealQuantity = jsonObject.optInt("mealQuantity");
                   System.out.println(mealType);
                   System.out.println(mealName);
                   System.out.println(mealQuantity);
                   mealNameOrder.add(mealName);
                   mealNumberOrder.add(mealQuantity);
               }
               Object list[] = mealNameOrder.toArray();
               String AllmealName = Arrays.toString(list);
               Object list1[] = mealNumberOrder.toArray();
               String AllmealNumber = Arrays.toString(list1);
               repository.save(new Customer(object.optInt("serialNumber"), object.optString("id"), object.getString("time"), object.getInt("sumPrice"), AllmealName, AllmealNumber)); //加入資料庫
              
           } catch (Exception e) {
               e.printStackTrace();
           }
		}
       return "Done";
   }
     
     
   @RequestMapping("/findall")
   public String findAll() throws Exception{ //注意put可能會被刷掉，所以才用list包
	   
	   JSONObject obj = new JSONObject();
	   //JSONArray ary = new JSONArray();
	   List<String> list = new ArrayList();
	   
       for(Customer cust : repository.findAll()){
			obj.put("serialNumber", cust.getSerialnumber());
			obj.put("id", cust.getUserid());
			obj.put("time", cust.getTime());
			obj.put("sumPrice", cust.getSumprice());
			//obj.put("mealType", cust.getMealtype());
			obj.put("mealName", cust.getMealname());
			obj.put("mealQuantity", cust.getMealnumber());
			System.out.println(obj.toString());
			list.add(obj.toString());
       }
       
       return list.toString();
   }
  
}