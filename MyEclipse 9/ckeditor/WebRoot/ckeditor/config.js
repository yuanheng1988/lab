/*
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	//add equation
	config.extraPlugins += (config.extraPlugins ? ',equation' : 'equation');
	
	config.toolbar_Full =
		[
		['Source','-','Save','NewPage','Preview','-','Templates'],
		['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],
		['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
		['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],
		'/',
		['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
		['NumberedList','BulletedList','-','Outdent','Indent','Blockquote','CreateDiv'],
		['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
		['BidiLtr', 'BidiRtl' ],
		['Link','Unlink','Anchor'],
		['equation','Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak','Iframe'],
		'/',
		['Styles','Format','Font','FontSize'],
		['TextColor','BGColor'],
		['Maximize', 'ShowBlocks','-','About']
		];
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
		config.language = 'zh-cn';//语言
		config.uiColor = '#FFF';//背景颜色
		config.width = 'auto';//宽度
		config.height = '300px';//高度
		config.skin = 'office2003';//界面v2,kama,office2003
		config.toolbar = 'Full';//工具栏风格Full,Basic
};
