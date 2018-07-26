package com.neuedu.utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

public class ViewUtils {
	// 设置窗体出现在屏幕中央
	public static void setWindowCenter(Component window) {
		/*
		 * 思路： A：首先获取屏幕的长和宽 B：然后获取窗体的长和宽 C：再用屏幕的长和宽分别减去窗体的，再除以2 D：得到的值作为窗体出现的坐标
		 */
		// 获取默认工具包
		Toolkit tl = Toolkit.getDefaultToolkit();

		// 获取屏幕的长和宽，不确定什么类型，用double类
		Dimension d = tl.getScreenSize();
		double ScreenHeigth = d.getHeight();
		double ScreenWidth = d.getWidth();

		// 获取窗体的长和宽,这个是int类的
		int FrameWidth = window.getWidth();
		int FrameHeigth = window.getHeight();

		// 相减再除以2，因为设置窗体出现的坐标所需要的是int类的，所以要转换成int类
		int Higth = (int) (ScreenHeigth - FrameHeigth) / 2;
		int Width = (int) (ScreenWidth - FrameWidth) / 2;

		// 值作为窗体出现的坐标
		window.setLocation(Width, Higth);

	}
}
