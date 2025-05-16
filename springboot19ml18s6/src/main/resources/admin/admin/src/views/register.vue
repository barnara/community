<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='security1'" class="rgs-form animate__animated animate__backInDown" :model="forgetForm">
				<div class="rgs-form2">
					<div class="title">基于DDD架构的智能友好社区系统找回密码</div>
					<el-form-item class="list-item">
						<div class="lable">账号</div>
						<el-input v-model="forgetForm.username" autocomplete="off" placeholder="请您输入账号" />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="getSecurity()">下一步</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
            </el-form>
			<el-form v-if="pageFlag=='security2'" class="rgs-form animate__animated animate__backInDown" :model="ruleForm">
				<div class="rgs-form2">
					<div class="title">基于DDD架构的智能友好社区系统密码重置</div>
					<el-form-item class="list-item">
						<div class="lable">密保问题</div>
						<el-input v-model="ruleForm.pquestion" readOnly autocomplete="off" placeholder="密保问题" />
					</el-form-item>
					<el-form-item class="list-item">
						<div class="lable">密保答案</div>
						<el-input v-model="ruleForm.myanswer" autocomplete="off" placeholder="请您输入密保答案" />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="validateSecurity()">下一步</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
            </el-form>
			<el-form v-if="pageFlag=='security3'" class="rgs-form animate__animated animate__backInDown" :model="ruleForm">
				<div class="rgs-form2">
					<div class="title">基于DDD架构的智能友好社区系统密码重置</div>
					<el-form-item class="list-item">
						<div class="lable">新密码</div>
						<el-input v-model="ruleForm.newpassword" autocomplete="off" type="password" placeholder="请您输入新密码" />
					</el-form-item>
					<el-form-item class="list-item">
						<div class="lable">确认密码</div>
						<el-input v-model="ruleForm.repassword" autocomplete="off" type="password" placeholder="请您确认新密码" />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="updatePassword()">修改密码</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
			</el-form>
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__backInDown" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于DDD架构的智能友好社区系统</div>
					<el-form-item class="list-item" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('juminzhanghao')?'required':''">居民账号：</div>
						<el-input  v-model="ruleForm.juminzhanghao"  autocomplete="off" placeholder="居民账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('juminxingming')?'required':''">居民姓名：</div>
						<el-input  v-model="ruleForm.juminxingming"  autocomplete="off" placeholder="居民姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in juminxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="jumintouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('shenfenzheng')?'required':''">身份证：</div>
						<el-input  v-model="ruleForm.shenfenzheng"  autocomplete="off" placeholder="身份证"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('louyumingcheng')?'required':''">楼宇名称：</div>
						<el-select v-model="ruleForm.louyumingcheng" placeholder="请选择楼宇名称" >
							<el-option
								v-for="(item,index) in juminlouyumingchengOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('danyuanhao')?'required':''">单元号：</div>
						<el-select v-model="ruleForm.danyuanhao" placeholder="请选择单元号" >
							<el-option
								v-for="(item,index) in jumindanyuanhaoOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('chepaihao')?'required':''">车牌号：</div>
						<el-input  v-model="ruleForm.chepaihao"  autocomplete="off" placeholder="车牌号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item email" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('email')?'required':''">邮箱：</div>
						<div style="display: flex;flex: 1;">
							<input v-model="ruleForm.email" autocomplete="off" placeholder="邮箱"/>
							<button v-if="isEndFlag" type="success" class="register-code" @click="sendemailcode()">发送验证码</button>
							<button v-if="!isEndFlag" type="success" class="register-code" disabled="disabled">{{SecondToDate}}</button>
						</div>
					</el-form-item>
					<el-form-item class="list-item email-code" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('email')?'required':''">验证码：</div>
						<el-input  v-model="emailcode" autocomplete="off" placeholder="验证码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('pquestion')?'required':''">密保问题：</div>
						<el-input  v-model="ruleForm.pquestion"  autocomplete="off" placeholder="密保问题"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jumin'">
						<div class="lable" :class="changeRules('panswer')?'required':''">密保答案：</div>
						<el-input  v-model="ruleForm.panswer"  autocomplete="off" placeholder="密保答案"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qishou'">
						<div class="lable" :class="changeRules('qishouzhanghao')?'required':''">骑手账号：</div>
						<el-input  v-model="ruleForm.qishouzhanghao"  autocomplete="off" placeholder="骑手账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qishou'">
						<div class="lable" :class="changeRules('qishouxingming')?'required':''">骑手姓名：</div>
						<el-input  v-model="ruleForm.qishouxingming"  autocomplete="off" placeholder="骑手姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qishou'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qishou'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qishou'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="qishoutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qishou'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in qishouxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qishou'">
						<div class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qishou'">
						<div class="lable" :class="changeRules('dianhua')?'required':''">电话：</div>
						<el-input  v-model="ruleForm.dianhua"  autocomplete="off" placeholder="电话"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item email" v-if="tableName=='qishou'">
						<div class="lable" :class="changeRules('email')?'required':''">邮箱：</div>
						<div style="display: flex;flex: 1;">
							<input v-model="ruleForm.email" autocomplete="off" placeholder="邮箱"/>
							<button v-if="isEndFlag" type="success" class="register-code" @click="sendemailcode()">发送验证码</button>
							<button v-if="!isEndFlag" type="success" class="register-code" disabled="disabled">{{SecondToDate}}</button>
						</div>
					</el-form-item>
					<el-form-item class="list-item email-code" v-if="tableName=='qishou'">
						<div class="lable" :class="changeRules('email')?'required':''">验证码：</div>
						<el-input  v-model="emailcode" autocomplete="off" placeholder="验证码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qishou'">
						<div class="lable" :class="changeRules('pquestion')?'required':''">密保问题：</div>
						<el-input  v-model="ruleForm.pquestion"  autocomplete="off" placeholder="密保问题"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qishou'">
						<div class="lable" :class="changeRules('panswer')?'required':''">密保答案：</div>
						<el-input  v-model="ruleForm.panswer"  autocomplete="off" placeholder="密保答案"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='wuyerenyuan'">
						<div class="lable" :class="changeRules('gonghao')?'required':''">工号：</div>
						<el-input  v-model="ruleForm.gonghao"  autocomplete="off" placeholder="工号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='wuyerenyuan'">
						<div class="lable" :class="changeRules('xingming')?'required':''">姓名：</div>
						<el-input  v-model="ruleForm.xingming"  autocomplete="off" placeholder="姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='wuyerenyuan'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='wuyerenyuan'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='wuyerenyuan'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in wuyerenyuanxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='wuyerenyuan'">
						<div class="lable" :class="changeRules('tupian')?'required':''">图片：</div>
						<file-upload
							tip="点击上传图片"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
							@change="wuyerenyuantupianUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='wuyerenyuan'">
						<div class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='wuyerenyuan'">
						<div class="lable" :class="changeRules('pquestion')?'required':''">密保问题：</div>
						<el-input  v-model="ruleForm.pquestion"  autocomplete="off" placeholder="密保问题"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='wuyerenyuan'">
						<div class="lable" :class="changeRules('panswer')?'required':''">密保答案：</div>
						<el-input  v-model="ruleForm.panswer"  autocomplete="off" placeholder="密保答案"  type="text"  />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            emailcode:'',
			// 倒计时时间
			count: 60,
			// 倒计时定时器
			inter: null,
			// 倒计时是否结束
			isEndFlag: true,
            juminxingbieOptions: [],
            juminlouyumingchengOptions: [],
            jumindanyuanhaoOptions: [],
            qishouxingbieOptions: [],
            wuyerenyuanxingbieOptions: [],
		};
	},
	computed: {
		SecondToDate: function() {
			var time = this.count;
			if (null != time && "" != time) {
				time = parseInt(time) + "秒后重发";
			}
			return time;
		}
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='jumin'){
				this.ruleForm = {
					juminzhanghao: '',
					mima: '',
					juminxingming: '',
					xingbie: '',
					touxiang: '',
					lianxidianhua: '',
					shenfenzheng: '',
					louyumingcheng: '',
					danyuanhao: '',
					chepaihao: '',
					email: '',
					pquestion: '',
					panswer: '',
				}
			}
			if(this.tableName=='qishou'){
				this.ruleForm = {
					qishouzhanghao: '',
					qishouxingming: '',
					mima: '',
					touxiang: '',
					xingbie: '',
					nianling: '',
					dianhua: '',
					email: '',
					pquestion: '',
					panswer: '',
				}
			}
			if(this.tableName=='wuyerenyuan'){
				this.ruleForm = {
					gonghao: '',
					xingming: '',
					mima: '',
					xingbie: '',
					tupian: '',
					lianxidianhua: '',
					pquestion: '',
					panswer: '',
				}
			}
			if ('jumin' == this.tableName) {
				this.rules.juminzhanghao = [{ required: true, message: '请输入居民账号', trigger: 'blur' }]
			}
			if ('jumin' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('qishou' == this.tableName) {
				this.rules.qishouzhanghao = [{ required: true, message: '请输入骑手账号', trigger: 'blur' }]
			}
			if ('qishou' == this.tableName) {
				this.rules.qishouxingming = [{ required: true, message: '请输入骑手姓名', trigger: 'blur' }]
			}
			if ('qishou' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			this.juminxingbieOptions = "男,女".split(',')
			this.$http({
				url: `option/louyumingcheng/louyumingcheng`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.juminlouyumingchengOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			this.$http({
				url: `option/danyuanhao/danyuanhao`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.jumindanyuanhaoOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			this.qishouxingbieOptions = "男,女".split(',')
			this.wuyerenyuanxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			if(name == 'pquestion'||name=='panswer') {
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        jumintouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        qishoutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        wuyerenyuantupianUploadChange(fileUrls) {
            this.ruleForm.tupian = fileUrls;
        },

        // 多级联动参数

		sendemailcode() {
			if(!this.ruleForm.email){
				this.$message.error(`邮箱不能为空`);
				return
			}
			if(this.ruleForm.email&&(!this.$validate.isEmail(this.ruleForm.email))){
				this.$message.error(`请输入正确的邮箱格式`);
				return
			}
			this.isEndFlag = false;
			var _this = this;
			this.inter = window.setInterval(function() {
				_this.count = _this.count - 1;
				if (_this.count <= 0) {
					window.clearInterval(_this.inter);
					_this.isEndFlag = true;
					_this.count=60;
				}
			}, 1000);
			this.$http({
				url: `${this.tableName}/sendemail?email=`+this.ruleForm.email,
				method: "get",
				params: {}
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message.success(`发送成功`);
				} else {
					this.$message.error(`服务器异常，请稍后重试`)
				}
			});
		},

        //获取密保问题
        getSecurity(){
            this.tableName = 'wuyerenyuan'
            if(!this.tableName) {
                this.$message.error("请选择角色");
                return false
            }
            if(!this.forgetForm.username){
                this.$message.error("请输入账号");
                return false
            }
            this.$http({
                url: this.tableName+`/security?username=` + this.forgetForm.username,
                method: "get",
            }).then(({
                data
            }) => {
                if (data.data && data.code === 0) {
                    this.ruleForm = data.data;
                    this.pageFlag="security2"
                } else {
                    if(!data.data) {
                        this.$message.error("用户不存在");
                    } else {
                        this.$message.error(data.msg);
                    }
                }
            });
        },
        //验证密保问题
        validateSecurity(){
            let that = this
            if(this.ruleForm.panswer!=this.ruleForm.myanswer){
                this.$message.error("答案输入不正确");
                return false
            }
            this.$message.success("答案正确");
            setTimeout(()=>{
                this.pageFlag="security3";
            },1000)
        },
        // 修改密码
        updatePassword() {
            if (this.ruleForm.newpassword != this.ruleForm.repassword) {
                this.$message.error("两次密码输入不一致");
                return;
            }
            this.ruleForm.mima = this.ruleForm.newpassword;
            this.ruleForm.password = this.ruleForm.newpassword;
            this.$http({
                url: this.tableName+`/update`,
                method: "post",
                data: this.ruleForm
            }).then(({
                data
            }) => {
                if (data && data.code === 0) {
                    this.$message({
                        message: "修改密码成功",
                        type: "success",
                        duration: 1500,
                        onClose: () => {}
                    });
                    this.close()
                } else {
                    this.$message.error(data.msg);
                }
            });
        },
		// 注册
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.juminzhanghao) && `jumin` == this.tableName){
				this.$message.error(`居民账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `jumin` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `jumin` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`jumin` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}
			if(`jumin` == this.tableName && this.ruleForm.shenfenzheng &&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
				this.$message.error(`身份证应输入身份证格式`);
				return
			}
			if(`jumin` == this.tableName && this.ruleForm.email &&(!this.$validate.isEmail(this.ruleForm.email))){
				this.$message.error(`邮箱应输入邮件格式`);
				return
			}
			if(`jumin` == this.tableName ){
				url=this.tableName+"/register?emailcode="+this.emailcode;
				if(this.ruleForm.email&&(!this.$validate.isEmail(this.ruleForm.email))){
					this.$message.error(`请输入正确的邮箱格式`);
					return
				}
			}
			if((!this.emailcode) && `jumin` == this.tableName){
				this.$message.error(`验证码不能为空`);
				return
			}
			if(`jumin` == this.tableName && this.ruleForm.pquestion==''){
				this.$message.error(`密保问题不能为空`);
				return
			}
			if(`jumin` == this.tableName && this.ruleForm.panswer==''){
				this.$message.error(`密保答案不能为空`);
				return
			}
			if((!this.ruleForm.qishouzhanghao) && `qishou` == this.tableName){
				this.$message.error(`骑手账号不能为空`);
				return
			}
			if((!this.ruleForm.qishouxingming) && `qishou` == this.tableName){
				this.$message.error(`骑手姓名不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `qishou` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `qishou` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`qishou` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
			if(`qishou` == this.tableName && this.ruleForm.dianhua &&(!this.$validate.isMobile(this.ruleForm.dianhua))){
				this.$message.error(`电话应输入手机格式`);
				return
			}
			if(`qishou` == this.tableName && this.ruleForm.email &&(!this.$validate.isEmail(this.ruleForm.email))){
				this.$message.error(`邮箱应输入邮件格式`);
				return
			}
			if(`qishou` == this.tableName ){
				url=this.tableName+"/register?emailcode="+this.emailcode;
				if(this.ruleForm.email&&(!this.$validate.isEmail(this.ruleForm.email))){
					this.$message.error(`请输入正确的邮箱格式`);
					return
				}
			}
			if((!this.emailcode) && `qishou` == this.tableName){
				this.$message.error(`验证码不能为空`);
				return
			}
			if(`qishou` == this.tableName && this.ruleForm.pquestion==''){
				this.$message.error(`密保问题不能为空`);
				return
			}
			if(`qishou` == this.tableName && this.ruleForm.panswer==''){
				this.$message.error(`密保答案不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `wuyerenyuan` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
            if(this.ruleForm.tupian!=null) {
                this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`wuyerenyuan` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}
			if(`wuyerenyuan` == this.tableName && this.ruleForm.pquestion==''){
				this.$message.error(`密保问题不能为空`);
				return
			}
			if(`wuyerenyuan` == this.tableName && this.ruleForm.panswer==''){
				this.$message.error(`密保答案不能为空`);
				return
			}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20250428/c7094311ae734075952638ae6f00b202.png);
	background-repeat: no-repeat;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20250428/c7094311ae734075952638ae6f00b202.png);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	background-position: center center;
	.rgs-form {
		.rgs-form2 {
		width: 100%;
		}
		border-radius: 30px;
		box-shadow: rgb(12, 12, 21) 0px 4px 30px 0px inset, 0px 4px 8px 0px #6D6D6D;
		padding: 0 60px;
		margin: 20px 0;
		background: #141421;
		width: 552px;
		border-color: #1CE3A5;
		border-width: 10px 0 0;
		border-style: solid;
		.title {
			margin: 60px 0;
			color: #1CE3A5;
			font-weight: 500;
			width: 100%;
			font-size: 28px;
			text-align: center;
		}
		.list-item {
			background-color: rgba(22, 22, 36, 1);
			box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.30);
			padding: 0 12px;
			margin: 0 0 40px 0;
			color: #fff;
			font-size: 14px;
			/deep/ .el-form-item__content {
				display: block;
			}
			.lable {
				color: #9E9E9E;
				display: inline-block;
				width: 70px;
				font-size: 16px;
			}
			.el-input {
				width: calc(100% - 80px);
			}
			.el-input /deep/ .el-input__inner {
				border: none;
				background-color: transparent;
				padding: 0 10px;
				color: #fff;
				font-size: 16px;
				height: 50px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: none;
				background-color: transparent;
				padding: 0 10px;
				font-size: 16px;
				height: 50px;
			}
			.el-input-number {
				width: calc(100% - 80px);
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border: none;
				background-color: transparent;
				padding: 0 10px;
				color: #fff;
				font-size: 16px;
				height: 50px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border: none;
				background-color: transparent;
				padding: 0 10px;
				font-size: 16px;
				height: 50px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				width: calc(100% - 80px);
			}
			.el-select /deep/ .el-input__inner {
				border: none;
				background-color: transparent;
				padding: 0 10px;
				color: rgba(64, 158, 255, 1);
				font-size: 16px;
				height: 50px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: none;
				background-color: transparent;
				padding: 0 10px;
				color: rgba(64, 158, 255, 1);
				font-size: 16px;
				height: 50px;
			}
			.el-date-editor {
				width: calc(100% - 80px);
			}
			.el-date-editor /deep/ .el-input__inner {
				border: none;
				background-color: transparent;
				padding: 0 10px;
				color: rgba(64, 158, 255, 1);
				font-size: 16px;
				height: 50px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: none;
				background-color: transparent;
				padding: 0 10px;
				color: rgba(64, 158, 255, 1);
				font-size: 16px;
				height: 50px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 8px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 8px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 8px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #9E9E9E;
				font: 16px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 16px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				top: 3px;
				left: -8px;
				position: absolute;
				content: "*";
				order: -1;
			}
			.editor {
				background: #fff;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: none;
				background-color: transparent;
				outline: none;
				color: #fff;
				flex: 1 1 0;
				height: 50px;
			}
			input:focus {
				border: none;
				background-color: transparent;
				color: #9E9E9E;
				height: 50px;
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
			button {
				border: 0px solid #efeff7;
				cursor: pointer;
				border-radius: 4px;
				padding: 0;
				margin: 1px 0 0;
				color: #9E9E9E;
				background: #1C1F2F;
				width: 150px;
				font-size: 15px;
				height: 38px;
			}
			button:hover {
				opacity: 0.8;
			}
		}
		.register-btn {
			width: 100%;
		}
		.register-btn1 {
			width: 100%;
		}
		.register-btn2 {
			width: 100%;
		}
		.r-btn {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			border-radius: 25px;
			padding: 0 10px;
			margin: 0 0 10px;
			color: #fff;
			background: #1C1F2F;
			font-weight: 700;
			width: 100%;
			font-size: 24px;
			min-width: 68px;
			height: 50px;
		}
		.r-btn:hover {
			opacity: 0.8;
		}
		.r-login {
			cursor: pointer;
			padding: 0;
			color: #fff;
			font-size: 14px;
			line-height: 40px;
			text-align: center;
			height: 40px;
		}
		.r-login:hover {
			color: #1890ff;
			opacity: 1;
		}
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
