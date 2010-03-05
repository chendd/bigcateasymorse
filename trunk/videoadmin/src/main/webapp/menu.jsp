<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<SCRIPT language=javascript src="js/dtree/dtree.js"></SCRIPT>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="js/dtree/dtree.css" type="text/css" />


<div class="module">
<div class="title"><h2>菜单列表</h2></div>
<div class="reDiv">
<SCRIPT LANGUAGE="JavaScript">
                                d = new dTree('d');
                                
                                d.config.imageDir = 'js/dtree/img';
                                d.reSetImagePath();
                                d.config.folderLinks = false;
                                d.config.closeSameLevel = true;
                                var isOpen ;
                                //根节点
                                
                                d.add(0, -1, '网站后台管理','');
                                
                                d.add(1, 0, '视频管理','','','','');
                                d.add(11, 1, 'FLV视频列表','getVideoes.do','','','');
                                d.add(16, 1, '视频评论','getComments.do','','','');
                                d.add(12, 1, '用户上传视频','getUploadVideoes.do','','','');
                                d.add(13, 1, '节目单列表','getPlayBills.do','','','');
                                d.add(16, 1, '视频分类管理','videoChannelIndex.do','','','');
                                d.add(14, 1, '推荐待选视频','getCandidateVideoes.do','','','');
                                d.add(15, 1, '视频推荐','','','','');
                                d.add(151, 15, '最受欢迎视频','getIndexRecommendVideoes.do','','','');
                                d.add(152, 15, '您一定会喜欢','getMayLikeVideoes.do','','','');

                                
                                d.add(2, 0, '播客管理','','','','');
                                d.add(21, 2, '日志管理','','','','');
                                d.add(211, 21, '添加日志','addDailyInit.do','','','');
                                d.add(212, 21, '管理日志','dailyList.do','','','');
                                d.add(213, 21, '网友评论','dailyReplyList.do','','','');
                                d.add(214, 21, '分类管理','dailyChannelManage.do','','','');
                                d.add(215, 21, '用户模板','','','','');                    
								d.add(3, 0, '会员用户管理','','','','');
								d.add(31, 3, '会员添加','toUserCreate.do','','','');
								d.add(32, 3, '会员管理','getUsers.do','','','');
								d.add(33, 3, '管理员添加','toAdminCreate.do','','','');
								d.add(34, 3, '管理员设置','getAdmins.do','','','');
								d.add(35, 3, '每周明星推荐','toChooseStar.do','','','');
                                d.add(4, 0, '标签管理','','','','');
                                d.add(41,4 , '视频标签','getTags.do','','','');
                                d.add(42, 4, '日志标签','getDailyTags.do','','','');
                                
								d.add(5, 0, '圈子管理','','','','');
								d.add(51, 5, '圈子管理','getGroups.do','','','');
								d.add(52, 5, '圈子推荐','toUpdateRecommendGroups.do','','','');
								d.add(52, 5, '话题管理','getTopices.do','','','');
								d.add(11, 0, '搜索管理','indexSearchChannel.do','','','');
								
								d.add(6, 0, '广告管理','','','','');
								d.add(7, 0, '站内短信管理','','','','');
								d.add(71, 7, '短信列表','getWhispers.do','','','');
								d.add(72, 7, '群发公告','sendMessage.do','','','');
								d.add(73, 7, '群发邮件','mail.do','','','');
								
								
								d.add(8, 0, '公告管理','','','','');
								d.add(81, 8, '公告列表','getNotices.do','','','');
								d.add(82, 8, '公告添加','toAddNotice.do','','','');
								d.add(9, 0, '网站模版管理','','','','');
								d.add(10, 0, '统计','#','','','');
                                document.write(d);
                            </script>
</div>
</div>

