package com.company.util;

import codestat.CodeStatistics;

/**
 * @author Johnny
 * @category 代码统计图
 */
public class CodeStatView {

	public static void main(String[] args) throws Exception {
		CodeStatistics.showCodeStat(null, "html");
	}
}
