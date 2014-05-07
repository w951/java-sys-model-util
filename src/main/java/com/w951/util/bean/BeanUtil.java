package com.w951.util.bean;

public class BeanUtil {
	/**
	 * 整合原对象数据至新对象中，仅替换空数据 <br />
	 * 如：newAdmin的name属性为空，则将oldAdmin的name属性替换进新对象中
	 * 
	 * @param newObj 新数据对象
	 * @param oldObj 原数据对象
	 */
	public static void beanToBean(Object newObj, Object oldObj) {
		String[] newPts = ReflexUtil.getPropertyTypes(newObj);
		String[] oldPts = ReflexUtil.getPropertyTypes(oldObj);

		for (int i = 0; i < newPts.length; i++) {
			for (int x = 0; x < oldPts.length; x++) {
				if (newPts[i].equals(oldPts[x])) {
					if (ReflexUtil.getValue(newObj, newPts[i]) == null) {
						ReflexUtil.setValue(newObj, newPts[i],
								ReflexUtil.getValue(oldObj, oldPts[x]));
						break;
					}

					if (ReflexUtil.getPropertyType(newObj, newPts[i]).equals(
							BeanType.JAVA_DOUBLE)
							&& Double.parseDouble(String.valueOf(ReflexUtil
									.getValue(newObj, newPts[i]))) == 0) {
						ReflexUtil.setValue(newObj, newPts[i],
								ReflexUtil.getValue(oldObj, oldPts[x]));
						break;
					}

					if (ReflexUtil.getPropertyType(newObj, newPts[i]).equals(
							BeanType.JAVA_INTEGER)
							&& Integer.parseInt(String.valueOf(ReflexUtil
									.getValue(newObj, newPts[i]))) == 0) {
						ReflexUtil.setValue(newObj, newPts[i],
								ReflexUtil.getValue(oldObj, oldPts[x]));
						break;
					}

					if (ReflexUtil.getPropertyType(newObj, newPts[i]).equals(
							BeanType.JAVA_LONG)
							&& Long.parseLong(String.valueOf(ReflexUtil
									.getValue(newObj, newPts[i]))) == 0) {
						ReflexUtil.setValue(newObj, newPts[i],
								ReflexUtil.getValue(oldObj, oldPts[x]));
						break;
					}

					if (ReflexUtil.getPropertyType(newObj, newPts[i]).equals(
							BeanType.JAVA_SHORT)
							&& Short.parseShort(String.valueOf(ReflexUtil
									.getValue(newObj, newPts[i]))) == 0) {
						ReflexUtil.setValue(newObj, newPts[i],
								ReflexUtil.getValue(oldObj, oldPts[x]));
						break;
					}

					if (ReflexUtil.getPropertyType(newObj, newPts[i]).equals(
							BeanType.JAVA_BOOLEAN)
							&& String.valueOf(ReflexUtil.getValue(newObj,
									newPts[i])) == null) {
						ReflexUtil.setValue(newObj, newPts[i],
								ReflexUtil.getValue(oldObj, oldPts[x]));
						break;
					}
				}
			}
		}
	}
}
