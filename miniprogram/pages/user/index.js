// pages/user/index.js
const app = getApp();
const Url = app.globalData.Url;
const options = app.globalData.options;

Page({

  /**
   * 页面的初始数据
   */
  data: {
    userFavorForm:{
      user_id: ''
    },
    listData: []
  },
  getUserInfo(e) {
    var _this = this
    wx.showModal({
      title: '温馨提示',
      content: '亲，授权微信登录后才能正常使用小程序功能',
      success(res) {
        //如果用户点击了确定按钮
        if (res.confirm) {
          wx.getUserProfile({
            desc: '获取你的昵称、头像、地区及性别',
            success: (res) => {
              _this.setData({
                userInfo: res.userInfo,
                hasUserInfo: true,
              })
              app.globalData.hasUserInfo = true;
              console.log(res);
            },
            fail: res => {
              console.log(res)
              //拒绝授权
              wx.showToast({
                title: '您拒绝了请求,不能正常使用小程序',
                icon: 'error',
                duration: 2000
              });
              return;
            }
          });
        } else if (res.cancel) {
          //如果用户点击了取消按钮
          wx.showToast({
            title: '您拒绝了请求,不能正常使用小程序',
            icon: 'error',
            duration: 2000
          });
          return;
        }
      }
    });
  },
  jump: function (event) {
    this.setData({
      news_id: event.currentTarget.dataset.flag// 更新输入框的值
    });
    app.globalData.options = this.data.news_id;
    wx.navigateTo({
      url: '../context/index?news_id=' + JSON.stringify(this.data.news_id)
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(res) {

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
  if(app.globalData.hasUserInfo == true){
    this.data.userFavorForm.user_id = app.globalData.user_id;
    const userIdJson = JSON.stringify(this.data.userFavorForm);
    wx.request({
      url: Url + '/user/getUserInfo',
      method: 'POST',
      data: userIdJson,
      success: (res) => {
        this.setData({
          listData: res.data
        })
        console.log(this.data.listData);
      },
      fail: (err) => {
        console.error(err);
      }
    })
  }
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