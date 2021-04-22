1.先打开MySQL数据库，把SQL文件运行（在目录的文件夹“SQL”里）；
2.打开src--jdbc.properties文件，进行登录用户名和密码的修改，可能还要修改url；
3.配置Tomcat，加入此项目进服务器，即可运行；

后台：
dao--放置处理DAO层的方法和接口（面向数据库）
service--用于调用DAO层的方法，并进行其他业务处理
filter--放过滤器
pojo--放置Javabean实体对象
test--测试类（用于编写时的测试）
utils--工具类把多次用到的方法打包成一个包，调用即可（包括数据库的连接，字符的转换，键值对的注入）
web--存放servlet类，处理前段jsp跳转内容

前端：
image--存放图片
page--各种页面
    common--常用的jsp，可直接引用
    edit_page--用于修改的页面
    error--错误页面
    info_pages--展示信息的主页面
    user--登录、注册的页面
static--存放静态资源（css样式，jQuery等）




