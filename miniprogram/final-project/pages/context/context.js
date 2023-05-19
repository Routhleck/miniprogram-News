// index.js
// 获取应用实例

const app = getApp()
const Url = app.globalData.Url;

Page({
  // 数据绑定
  data: {
    newForm:{
      news_id:"",
    }
  },
  getData:function(){
    var text = this.data.getFrom.title;
  },
  onLoad(options){
    this.data.newForm.news_id = options.news_id // 更新输入框的值
    console.log(this.data.newForm);
    wx.request({
      url: Url + '/news/getNewsById',
      method: 'POST',
      data:this.data.newForm,
      dataType: 'json',
      responseType: 'text',
      success: (res) => {
 // 打印请求成功后的响应数据
        this.setData({
          getFrom:res.data// 更新输入框的值
        });
        console.log(this.data.getFrom);
      },
      fail: function(err){
        console.error(err); // 打印请求失败的错误信息
      }
    })
  },
  onReady: function() {
    // 页面渲染完成
    console.log('onReady');
  },
  onShow: function() {
    // 页面显示
    console.log('onShow');
  },
  onHide: function() {
    // 页面隐藏
    console.log('onHide');
  },
  onUnload: function() {
    // 页面关闭
    console.log('onUnload');
  }
})


