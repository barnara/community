const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot19ml18s6/",
            name: "springboot19ml18s6",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot19ml18s6/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于DDD架构的智能友好社区系统"
        } 
    }
}
export default base
