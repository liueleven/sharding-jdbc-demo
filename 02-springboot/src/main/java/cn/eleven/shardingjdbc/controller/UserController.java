package cn.eleven.shardingjdbc.controller;


import cn.eleven.shardingjdbc.entity.Address;
import cn.eleven.shardingjdbc.entity.Code;
import cn.eleven.shardingjdbc.entity.User;
import cn.eleven.shardingjdbc.service.AddressService;
import cn.eleven.shardingjdbc.service.CodeService;
import cn.eleven.shardingjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 一定要写注释啊
 * @date:        2019-10-09
 * @author:      十一
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CodeService cs;
    @Autowired
    private AddressService as;
   

    @GetMapping("/select-user")
    public List<User> select() {
        return userService.getUserList();
    }
    

    public int getRandom() {
    	return  (int) (Math.random()*100);
    }
    

    @GetMapping("/insert-user")
    public Boolean insert(User user) {
    	
    	for(int i=1;i<=10;i++) {
    		user.setUid(i);
        	user.setName("aaa"+i);
        	user.setAge(getRandom());
        	
            userService.save(user);
            
            Address address=new Address();
            address.setAid(i);
            //用户id
            address.setUid(i);
            address.setName("ddd"+i);
            
            as.save(address);
            
    	}
    	return true;
    	
    }
    
    
    
    @GetMapping("/insert-code")
    public boolean insertCode(Code code) {
        // 主键id，用雪花算法生成，这里一定要把id设置为null，才可以
        code.setId(null);
    	code.setName(getRandom() + "-code");
    	return cs.save(code);
    }

    @GetMapping("/update-code")
    public boolean updateCode(Code code) {
        code.setName(getRandom() + "-code-update");
        return cs.update(code);
    }


}
