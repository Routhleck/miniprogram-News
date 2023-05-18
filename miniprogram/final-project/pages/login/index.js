// index.js
// 获取应用实例
const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    current:1,
    counting:false,
    loginForm:{
      phone_num:"",
      password:"",
    },
    registerForm:{
      phone_num:"",
      password:"",
      check_password:""
    },
  },
  // 登陆注册监听
  click(e){
    let index = e.currentTarget.dataset.code;
    this.setData({
      current:index
    })
  },
  //处理登录表单手机号修改事件
  loginForm_phone_num_change:function(e){
      this.setData({
        'loginForm.phone_num': e.detail.value // 更新输入框的值
      });
  },
  //处理登录手机号失去焦点后检验事件
  loginForm_phone_num_blur:function(e){
    // 验证输入框的值是否为11位数字
    if (e.detail.value.length !== 11 || !/^\d+$/.test(e.detail.value)) {
      wx.showToast({
        title: '请输入正确的手机号',
        icon: 'none',
        duration: 2000
      });
    }
  },
  //处理登录表单密码修改事件
  loginForm_password_change:function(e){
    this.setData({
      'loginForm.password': e.detail.value // 更新输入框的值
    });
  },
  //处理注册表单手机号修改事件
  registerForm_phone_num_change:function(e){
    this.setData({
      'registerForm.phone_num': e.detail.value // 更新输入框的值
    });
},
  //处理注册表单密码修改事件
  registerForm_password_change:function(e){
    this.setData({
      'registerForm.password': e.detail.value // 更新输入框的值
    });
  },
    //处理注册表单确认密码修改事件
    registerForm_check_password_change:function(e){
      this.setData({
        'registerForm.check_password': e.detail.value // 更新输入框的值
      });
    },
  //处理点击登录注册按钮事件
  Onsubmit:function(){
    if(this.data.current == 1){
      const loginFormJson = JSON.stringify(this.data.loginForm)
      wx.request({
        url: 'http://127.0.0.1:8888/user/login',
        method: 'POST',
        data: loginFormJson,
        success: function(res){
          console.log(res.data); // 打印请求成功后的响应数据
        },
        fail: function(err){
          console.error(err); // 打印请求失败的错误信息
        }
      })
    }else{
      console.log(this.data.current)
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})
