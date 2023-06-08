// index.js
// 获取应用实例

const app = getApp()
const Url = app.globalData.Url;

Page({
  // 数据绑定
  data: {
    news_id:"",
    yaolist:[],
    pagesize: 6,
    page: 1,
    showlist: [],
    tabs: ['头条', '体育', '军事','科技','财经','社会'],
    current:0,
    categorytype: {
      'category':'top'
    }
  },
  // 自定义变量
  imgPath: "/images/...",
  
  tabSelect:function(e){
    var current = e.currentTarget.dataset.id
    this.setData({
      current:current
    })
    this.myNews();
  },
  // 自定义方法
  process: function() {

  },
  jump: function (event) {
    console.log(event.currentTarget.dataset.flag);
    this.setData({
      news_id: event.currentTarget.dataset.flag// 更新输入框的值
    });
    app.globalData.options = this.data.news_id;
    wx.navigateTo({
      url: '../context/index?news_id=' + JSON.stringify(this.data.news_id)
    })
  },
  myNews:function(){
    let _this = this
    const map = new Map()
    map.set(0,"top")
    map.set(1,"sports")
    map.set(2,"military")
    map.set(3,"technology")
    map.set(4,"finance")
    map.set(5,"society")
    const category = map.get(_this.data.current)
    _this.data.categorytype.category = category;
    const categoryJson = JSON.stringify(_this.data.categorytype);
    console.log(categoryJson)
    wx.request({
      url: Url + '/news/getAllNewsByCategory',
      method: 'POST',
      data: categoryJson,
      success: (res) => {
        console.log(res)
 // 打印请求成功后的响应数据
        let list = res.data;
        let qielist = list.slice(_this.data.page-1,_this.data.pagesize)
        _this.setData({
          yaolist:list,     //全部数据
          showlist:qielist, //刚进来第一次展示数据
        });
      },
      fail: function(err){
        console.error(err); // 打印请求失败的错误信息
      }
    })
  },
  onLoad: function() {
    this.myNews();
  },
  onReady: function() {
    // 页面渲染完成
  },
  onShow: function() {
    // 页面显示
  },
  onHide: function() {
    // 页面隐藏
  },
  onUnload: function() {
    // 页面关闭
  },
    /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom () {
    wx.showLoading({
      title: '加载中',
    })
    let shu = this.data.page
    this.setData({
      page:shu+1
    })
    let num = (this.data.page-1)*this.data.pagesize   
    let num2 = num+this.data.pagesize
    let arr = this.data.yaolist
    let qielist = arr.slice(num,num2)
    let slist = this.data.showlist
    let newarr = slist.concat(qielist)
    this.setData({
      showlist:newarr
    })
    console.log(this.data.showlist);
    setTimeout(function () {
      wx.hideLoading()
    }, 300)
  },
  onPullDownRefresh () {  
    wx.showLoading({
      title: '加载中',
    })
    this.onRefresh();
  },
    onRefresh(){
    //在当前页面显示导航条加载动画 
    wx.showNavigationBarLoading();
    //显示 loading 提示框。需主动调用 wx.hideLoading 才能关闭提示框 
    this.searchList();
  },
 
  searchList(){
    this.setData({
      page:1,
    })
    let arr = this.data.yaolist
    let qielist = arr.slice(this.data.page-1,this.data.pagesize)
    this.setData({
      showlist:qielist
    })
    console.log(this.data.showlist);
    setTimeout(function () {
      wx.hideLoading()
      wx.hideNavigationBarLoading();
      //停止下拉刷新
      wx.stopPullDownRefresh();
    }, 1000)
 
  }
})


