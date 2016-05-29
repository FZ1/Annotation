package converter;

import java.lang.annotation.Annotation;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * 引数で渡されたクラス名からクラスを取得し、NamedQueries、NamedNativeQueriesアノテーションを
 * XML形式に変換する。 
 */
public class QueryAnnotationConverter {
	public static void main(String[] args) throws Exception {
		// 引数で渡されたクラス名分、処理をループ
		for (int i = 0; i < args.length; i++) {
			// 対象のクラスを取得
			Class<?> clazz = Class.forName(args[i]);
			// クラス内のアノテーションを取得
			Annotation[] annotations = clazz.getAnnotations();

			for (Annotation a : annotations) {
				// アノテーションの種類により、処理を分岐
				if (a instanceof NamedQueries) {
					NamedQueries NamedQueries = (NamedQueries) a;
					convertNamedQuery(NamedQueries);
				} else if (a instanceof NamedNativeQueries) {
					NamedNativeQueries namedNativeQueries = (NamedNativeQueries) a;
					convertNamedNativeQuery(namedNativeQueries);
				}
			}
		}
	}

	/**
	 * 引数で渡されたNamedQueriesから、各NamedQueryの情報をXML形式にする。 
	 */
	private static void convertNamedQuery(NamedQueries NamedQueries) {
		for (NamedQuery nQuery : NamedQueries.value()) {
			System.out.println("\t<NamedQuery name = " + nQuery.name() + ">");
			System.out.println("\t\t<![CDATA[");
			System.out.println("\t\t" + nQuery.query());
			System.out.println("\t\t]]>");
			System.out.println("\t</NmedQuery>");
			System.out.println("");
		}
	}

	/**
	 * 引数で渡されたNamedNativeQueriesから、各NamedNativeQueryの情報をXML形式にする。 
	 */
	private static void convertNamedNativeQuery(NamedNativeQueries namedNativeQueries) {
		for (NamedNativeQuery nNQuery : namedNativeQueries.value()) {
			System.out.println("\t<NamedNativeQuery name = " + nNQuery.name() + ", "
				+ "result-class = " + nNQuery.resultClass().getName() + ">");
			System.out.println("\t\t<![CDATA[");
			System.out.println("\t\t" + nNQuery.query());
			System.out.println("\t\t]]>");
			System.out.println("\t</NmedNativeQuery>");
			System.out.println("");
		}
	}
}
