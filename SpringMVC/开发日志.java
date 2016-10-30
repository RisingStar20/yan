1.当DispatcherServlet启动时，会创建Spring应用上下文，并加载配置文件或配置类中所声明的bean。getServletConfigClasses()方法中，要求DispatcherServlet加载应用上下文时，使用定义在WebConfig配置类中的bean。但是在SpringWeb应用中，通常还会有另外一个应用上下文，另外的应用上下文在ContextLoaderListener创建。我们希望DispatcherServlet加载包含Web组件的bean，如控制器、视图解析器以及处理器映射，二ContextLoaderListener要加载应用中其他的bean。这些bean通常是驱动应用后端的中间层和数据层组件。实际上AbstractAnnotationConfigDispatcherServletInitializer会同时创建DispatcherServlet和ContextLoaderListener。getServletConfigClasses方法返回的带有@Configuration注解的类将会用来定义DispatcherServlet应用上下文中的bean。getRootConfigClasses方法返回带有@Configuration注解的类将会用来配置ContextLoaderListener创建的应用上下文中的bean。
2.设置WebMvcConfigurerAdapter为WebConfig的父类，用来配置静态资源，并重写configureDefaultServletHandling方法，并使得默认的servlet生效：configurer.enable();
3.Controller中的@RequestMapping(method=GET,value="/")中的GET需要引入import static org.springframework.web.bind.annotation.RequestMethod.GET;
4.从Spring3.2开始，我们可以按照控制器的方式来测试SpringMVC中的控制器了，而不仅仅是作为POJO进行测试。Spring现在包含了一种mock Spring MVC并针对控制器执行HTTP请求的机制。这样的话，在测试控制器的时候，就没有必要再启动Web服务器和Web浏览器了。要注意引用的静态包！！！
5.类级别的@RequestMapping相当于命名空间，如果类级别的mapping为"/home"，方法级别的mapping为"/method",那么得到此方法返回的视图名时所要指定的action为"/home/method"
6.@RequestMapping的参数是String[]类型，也就是说可以指定多个action，如{"/","/home"}，这表示两个都有效
7.Model类型其实是一个Map，它会传递给视图，这样数据就能够渲染到客户端了，当调用model.addAttribute()方法并且不指定key的时候，那么key会根据值得对象类型推断确定，如果是List<Book>，则会默认为bookList，以后可能会用ModelAndView类型，此处先不追究了。
8.如果想显式声明key的话，也可以自行指定，model.addAttribute("key",Object obj)
9.如果希望使用非Spring类型，也可以用Map来代替Model，model.addAttribute()变更为model.put()即可，原理参见https://zhidao.baidu.com/question/564038740.html
10.
	