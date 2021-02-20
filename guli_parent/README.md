---
谷粒学院项目实战
--
#### 2021年
###2月：
- 修复日志问题输出问题
- 学习js： let使用范围；不能重复定义变量；常量const定义不可变且必须初始化；es6语法-结构模版和声明对象；

        es6语法
        
        //数组赋值
        let [a,b,c]=[20,30,40]
        
        //对象赋值 ,新定义的变量名称必须和对象中的属性一致
        let user = {name:'lucy',age:19}
        let {name,age} = user;
        
        //模板字符串 反引号``
        let str1 = `你好，
            我是黎明！`
        
        //在``中，变量、函数配和${}使用,放入JavaScript表达式 
        let name = "mike"
        let age = 27
        let info = `My name is ${name},I am ${age} years old.`
        
        //创建定义方法简写
        //传统
        let persion1 = {
            sayHi:function(){
                alert("Hi")
            }
        }
        //简写function
        let persion2 = {
             sayHi(){
                alert("Hi")
             }
        }
        
        //扩展运算符 
        //...对象复制
        let persion1 = {name:"lucy",age:19}
        let persion2 = {...persion1}
        
        //...对象合并
        let age = {age:20}
        let name = {name:"mary"}
        let persion = {...age,...name}
        
        //=>箭头函数
        let f1 = function(a){
            return a+1
        }
        let f2 = a=>a+1
        
        //=>箭头函数 复杂
        let f3 = function(a,b){
            return a+b
        }
        let f4 = (a,b)=>a+b