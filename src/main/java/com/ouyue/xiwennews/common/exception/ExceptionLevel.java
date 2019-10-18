package com.ouyue.xiwennews.common.exception;

/**
 *
 * 类: ExceptionLevel <br>
 * 描述: 异常级别定义 <br>
 */
public enum ExceptionLevel {

	DEBUG {
		@Override
		public int intValue() {
			return 0;
		}
	},
	INFO {
		@Override
		public int intValue() {
			return 1;
		}
	},
	WARN {
		@Override
		public int intValue() {
			return 2;
		}
	},
	ERROR {
		@Override
		public int intValue() {
			return 3;
		}
	}
	;
	public abstract int intValue();

}
