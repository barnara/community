import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import baoxiuxinxi from '@/views/modules/baoxiuxinxi/list'
	import qishou from '@/views/modules/qishou/list'
	import jiaofeitongzhi from '@/views/modules/jiaofeitongzhi/list'
	import wuyerenyuan from '@/views/modules/wuyerenyuan/list'
	import changdileixing from '@/views/modules/changdileixing/list'
	import forumtype from '@/views/modules/forumtype/list'
	import tousufuwu from '@/views/modules/tousufuwu/list'
	import peisongjilu from '@/views/modules/peisongjilu/list'
	import fangwudengji from '@/views/modules/fangwudengji/list'
	import danyuanhao from '@/views/modules/danyuanhao/list'
	import weixiudengji from '@/views/modules/weixiudengji/list'
	import news from '@/views/modules/news/list'
	import discusszhoubianfuwu from '@/views/modules/discusszhoubianfuwu/list'
	import zhoubianfuwu from '@/views/modules/zhoubianfuwu/list'
	import cheweidengji from '@/views/modules/cheweidengji/list'
	import jumin from '@/views/modules/jumin/list'
	import changdixinxi from '@/views/modules/changdixinxi/list'
	import discusschangdixinxi from '@/views/modules/discusschangdixinxi/list'
	import forum from '@/views/modules/forum/list'
	import huodongbaoming from '@/views/modules/huodongbaoming/list'
	import quyushenqing from '@/views/modules/quyushenqing/list'
	import forumreport from '@/views/modules/forumreport/list'
	import discussshequhuodong from '@/views/modules/discussshequhuodong/list'
	import shequhuodong from '@/views/modules/shequhuodong/list'
	import louyumingcheng from '@/views/modules/louyumingcheng/list'
	import config from '@/views/modules/config/list'
	import changdiyuyue from '@/views/modules/changdiyuyue/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/baoxiuxinxi',
		name: '报修信息',
		component: baoxiuxinxi
	}
	,{
		path: '/qishou',
		name: '骑手',
		component: qishou
	}
	,{
		path: '/jiaofeitongzhi',
		name: '缴费通知',
		component: jiaofeitongzhi
	}
	,{
		path: '/wuyerenyuan',
		name: '物业人员',
		component: wuyerenyuan
	}
	,{
		path: '/changdileixing',
		name: '场地类型',
		component: changdileixing
	}
	,{
		path: '/forumtype',
		name: '论坛分类',
		component: forumtype
	}
	,{
		path: '/tousufuwu',
		name: '投诉服务',
		component: tousufuwu
	}
	,{
		path: '/peisongjilu',
		name: '配送记录',
		component: peisongjilu
	}
	,{
		path: '/fangwudengji',
		name: '房屋登记',
		component: fangwudengji
	}
	,{
		path: '/danyuanhao',
		name: '单元号',
		component: danyuanhao
	}
	,{
		path: '/weixiudengji',
		name: '维修登记',
		component: weixiudengji
	}
	,{
		path: '/news',
		name: '社区公告',
		component: news
	}
	,{
		path: '/discusszhoubianfuwu',
		name: '周边服务评论',
		component: discusszhoubianfuwu
	}
	,{
		path: '/zhoubianfuwu',
		name: '周边服务',
		component: zhoubianfuwu
	}
	,{
		path: '/cheweidengji',
		name: '车位登记',
		component: cheweidengji
	}
	,{
		path: '/jumin',
		name: '居民',
		component: jumin
	}
	,{
		path: '/changdixinxi',
		name: '场地信息',
		component: changdixinxi
	}
	,{
		path: '/discusschangdixinxi',
		name: '场地信息评论',
		component: discusschangdixinxi
	}
	,{
		path: '/forum',
		name: '社区论坛',
		component: forum
	}
	,{
		path: '/huodongbaoming',
		name: '活动报名',
		component: huodongbaoming
	}
	,{
		path: '/quyushenqing',
		name: '区域申请',
		component: quyushenqing
	}
	,{
		path: '/forumreport',
		name: '举报记录',
		component: forumreport
	}
	,{
		path: '/discussshequhuodong',
		name: '社区活动评论',
		component: discussshequhuodong
	}
	,{
		path: '/shequhuodong',
		name: '社区活动',
		component: shequhuodong
	}
	,{
		path: '/louyumingcheng',
		name: '楼宇名称',
		component: louyumingcheng
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/changdiyuyue',
		name: '场地预约',
		component: changdiyuyue
	}
	,{
		path: '/newstype',
		name: '社区公告分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
