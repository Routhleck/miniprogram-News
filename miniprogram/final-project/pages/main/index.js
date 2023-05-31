// index.js
// 获取应用实例

const app = getApp()
const Url = app.globalData.Url;

Page({
  // 数据绑定
  data: {
    news_id:"",
    newForm:[]
  },
  // 自定义变量
  imgPath: "/images/...",

  // 自定义方法
  process: function() {

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
  myNews:function(){
    wx.request({
      url: Url + '/news/getAllNews',
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: (res) => {
 // 打印请求成功后的响应数据
        this.setData({
          newForm:res.data// 更新输入框的值
        });
        console.log(this.data.newForm);
      },
      fail: function(err){
        console.error(err); // 打印请求失败的错误信息
      }
    })
  },
  onReady: function() {
    // 页面渲染完成
    this.myNews();
  },
  onShow: function() {
    // 页面显示
  },
  onHide: function() {
    // 页面隐藏
  },
  onUnload: function() {
    // 页面关闭
  }
})


