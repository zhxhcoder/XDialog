package com.zhxh.xdialoglib.dialog.adapter;

/**
 * Created by zhxh on 2018/7/5
 */
public class XWheelAdapter implements IWheelAdapter {
	
	/** The default min value */
	private String[] strContents;
	/**
	 * 构造方法
	 * @param strContents
	 */
	public XWheelAdapter(String[] strContents){
		this.strContents=strContents;
	}
	
	
	public String[] getStrContents() {
		return strContents;
	}


	public void setStrContents(String[] strContents) {
		this.strContents = strContents;
	}


	public String getItem(int index) {
		if (index >= 0 && index < getItemsCount()) {
			return strContents[index];
		}
		return null;
	}
	
	public int getItemsCount() {
		return strContents.length;
	}
	/**
	 * 设置最大的宽度
	 */
	public int getMaximumLength() {
		int maxLen=7;
		return maxLen;
	}


	@Override
	public String getCurrentId(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}
