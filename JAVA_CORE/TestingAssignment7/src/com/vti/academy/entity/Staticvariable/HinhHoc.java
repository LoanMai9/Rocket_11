package com.vti.academy.entity.Staticvariable;

public abstract class HinhHoc implements IHinhHoc {
	public static int counter=0;
	private float a;
	private float b;
	public HinhHoc(float a, float b) throws Exception {
		if (counter > Config.SO_LUONG_HINH_TOI_DA) {
			throw new Exception("Chỉ khởi tạo được 5 hình!!" +Config.SO_LUONG_HINH_TOI_DA);
		}
		this.a = a;
		this.b = b;
	}
	
}
