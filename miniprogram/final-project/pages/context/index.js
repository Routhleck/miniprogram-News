// index.js
// 获取应用实例

const app = getApp();
const Url = app.globalData.Url;

Page({
  // 数据绑定
  data: {
    placeholder: '说点什么...', //底部输入框占字符,
    comment_text: null, //底部评论框内容,
    focus: false, //输入框是否聚焦,
    job:[],
    jobList:[],
    id:'',
    isClick:false,
    jobStorage:[],
    jobId:'',
    newForm:{
      news_id:"",
    },
    userLike:{
      news_id:"",
    },
    comtentFrom:{
      text:"",
      news_id:1,
      user_id:1,
      time:""
    },
    myfavortFrom:{
      news_id:"",
      user_id:""
    }
  },
  imgPath: "/images/...",
  getData:function(){
    var text = this.data.getFrom.title;
  },
  onLoad(options){
    this.data.newForm.news_id = options.news_id;
    this.data.comtentFrom.news_id = parseInt(options.news_id);
    this.data.myfavortFrom.news_id = parseInt(options.news_id);
    this.data.comtentFrom.user_id= parseInt(app.globalData.user_id);
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
    }),
    wx.request({
      url: Url + '/getComment',
      method: 'POST',
      data:this.data.newForm,
      dataType: 'json',
      responseType: 'text',
      success: (res) => {
 // 打印请求成功后的响应数据
        this.setData({
          getFroms:res.data// 更新输入框的值
        });
        console.log(this.data.getFroms);
      },
      fail: function(err){
        console.error(err); // 打印请求失败的错误信息
      }
    })

  },
  myfavort(){
      var app = getApp();
      this.data.myfavortFrom.user_id = app.globalData.user_id;
      console.log(this.data.myfavortFrom);
      wx.request({
        url: Url + '/favourite/addFavourite',
        method: 'POST',
        data:this.data.myfavortFrom,
        dataType: 'json',
        responseType: 'text',
        success: (res) => {
          console.log(this.data.getFrom);
        },
        fail: function(err){
          console.error(err); // 打印请求失败的错误信息
        }
      })
  },
  confirm(e){
    this.data.comtentFrom.text= e.detail.value;
    var timestamp = Date.parse(new Date());
    var date = new Date(timestamp);//获取年份
    var Y =date.getFullYear();//获取月份
    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1);//获取当日日期 
    var D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
    this.data.comtentFrom.time= Y+"-"+M+"-"+D //更新输入框的值
    console.log(this.data.comtentFrom);
    wx.request({
      url: Url + '/addComment',
      method: 'POST',
      data:this.data.comtentFrom,
      dataType: 'json',
      responseType: 'text',
      success: (res) => {
        var option = {
          'news_id':String(app.globalData.options)
        }
        this.onLoad(option);
      },
      fail: function(err){
        console.error(err); // 打印请求失败的错误信息
      }
    })
  },
  haveSave(e){
      let jobData = this.data.jobStorage;
      jobData.push({
        jobid:jobData.length,
        id:this.data.job.id
      })
      wx.setStorageSync('jobData', jobData);
      wx.showToast({
        title: '已收藏',
      });
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


