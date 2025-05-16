<template>
	<div>
		<div class="login-container">
			<el-form class="login_form animate__animated animate__backInDown">
				<div class="login_form2">
					<div class="title-container">基于DDD架构的智能友好社区系统登录</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号：
						</div>
						<input placeholder="请输入账号：" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码：
						</div>
						<div class="password-box">
							<input placeholder="请输入密码：" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item select" v-if="roles.length>1">
						<div class="lable">
							角色：
						</div>
						<el-select v-model="rulesForm.role" placeholder="请选择角色：">
							<el-option v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" :key="item.roleName" :label="item.roleName" :value="item.roleName" />
						</el-select>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
						</div>
						<div class="login-btn3">
							<el-button type="primary" @click="updatePassword()" class="forget">忘记密码?</el-button>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
			};
		},
		mounted() {
			let menus = menu.list();
			this.menus = menus;

			for (let i = 0; i < this.menus.length; i++) {
				if (this.menus[i].hasBackLogin=='是') {
					this.roles.push(this.menus[i])
				}
			}

		},
		created() {

		},
		destroyed() {
		},
		components: {
		},
		methods: {

			//重置密码
			updatePassword(){
				this.$storage.set("loginTable", "");
				this.$router.push({path:'/register',query:{pageFlag:'security1'}})
			},
			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$nextTick(()=>{
							this.$http({
								url: this.tableName + '/session',
								method: "get"
							}).then(({
								data
							}) => {
								if (data && data.code === 0) {
									if(this.tableName == 'jumin') {
										this.$storage.set('headportrait',data.data.touxiang)
									}
									if(this.tableName == 'qishou') {
										this.$storage.set('headportrait',data.data.touxiang)
									}
									if(this.tableName == 'wuyerenyuan') {
										this.$storage.set('headportrait',data.data.tupian)
									}
									if(this.tableName == 'users') {
										this.$storage.set('headportrait',data.data.image)
									}
									this.$storage.set('userForm',JSON.stringify(data.data))
									this.$storage.set('userid',data.data.id);
								} else {
									let message = this.$message
									message.error(data.msg);
								}
								this.$router.replace({ path: "/" });
							});
						})
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
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

	.login_form {
		border-radius: 30px;
		box-shadow: rgb(12, 12, 21) 0px 4px 30px 0px inset, 0px 4px 8px 0px #6D6D6D;
		padding: 0 60px;
		background: #141421;
		width: 552px;
		border-color: #1CE3A5;
		border-width: 10px 0 0;
		border-style: solid;
		.login_form2 {
			width: 100%;
		}
		.title-container {
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
			flex-direction: row;
			color: #9E9E9E;
			display: flex;
			font-size: 14px;
			align-items: center;
			height: 50px;
			.lable {
				color: #9E9E9E;
				flex: 0 0 auto;
				width: 70px;
				font-size: 16px;
			}
			input {
				border: none;
				background-color: transparent;
				padding: 0 10px;
				color: #fff;
				flex: 1 1 auto;
				font-size: 16px;
				height: 50px;
			}
			input:focus {
				border: none;
				background-color: transparent;
				padding: 0 10px;
				outline: none;
				color: #fff;
				flex: 1 1 auto;
				font-size: 16px;
				height: 100%;
			}
			.password-box {
				display: flex;
				width: 100%;
				position: relative;
				align-items: center;
				input {
					border: none;
					background-color: transparent;
					padding: 0 10px;
					color: #fff;
					flex: 1 1 auto;
					height: 50px;
				}
				input:focus {
					border: none;
					background-color: transparent;
					padding: 0 10px;
					color: #fff;
					flex: 1 1 auto;
					height: 50px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					top: 0;
					font-size: 16px;
					line-height: 44px;
					position: absolute;
					right: 5px;
				}
			}
			input::placeholder {
				color: #9E9E9E;
				font-size: 16px;
			}
			/deep/ .el-select {
				width: 100%;
			}
			/deep/ .el-select .el-input__inner {
				border: none;
				background-color: transparent;
				padding: 0 10px;
				color: rgba(64, 158, 255, 1);
				font-size: 16px;
				height: 50px;
			}
			/deep/ .el-select .is-focus .el-input__inner {
				border: none;
				background-color: transparent;
				padding: 0 10px;
				color: rgba(64, 158, 255, 1);
				font-size: 16px;
				height: 50px;
			}
			/deep/ .el-select .el-input__inner::placeholder{
				color: #9E9E9E;
				font-size: 16px;
			}
		}
		.login-btn {
			margin: 20px auto;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				width: 100%;
			}
			.login-btn2 {
				margin: 20px 0 0 0;
				display: flex;
				gap: 40px;
				width: 100%;
				justify-content: center;
				align-items: center;
				flex-wrap: wrap;
			}
			.login-btn3 {
				width: 100%;
			}
			.loginInBt {
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
			.loginInBt:hover {
				opacity: 0.5;
			}
			.register {
				cursor: pointer;
				border: none;
				border-radius: 5px;
				padding: 0 10px;
				box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.30),0px -1px 1px 0px rgba(255, 255, 255, 0.30);
				color: #B8B8B8;
				background: #161624;
				width: auto;
				font-size: 16px;
				height: 40px;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 10px 10px 0;
				color: #999;
				background: none;
				width: 100%;
				font-size: 15px;
				text-align: right;
				height: 34px;
			}
			.forget:hover {
				color: #0d6efd;
				opacity: 1;
			}
		}
	}
}

</style>
