package jp.com.daybreak;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 営業日カレンダー
 */
public class DayBreakCalendar {

	/**
	 * 営業日カレンダーを作成する
	 * 
	 * @param yearMonth YYYYMM形式の半角数字
	 * @return 営業日カレンダー文字列
	 * @throws Exception Exception
	 */
	public String execution(final String yearMonth) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		// 月初日を取得する
		final Date firstDate = getFirstDate(yearMonth);

		// 月初日を元に月末日を取得する
		final Calendar calendar = Calendar.getInstance();
		final Date lastDate = getLastDate(calendar, firstDate);

		// ヘッダー情報を出力
		final String year = yearMonth.substring(0, 4);
		final String month = yearMonth.substring(4);
		final String[] calenderString = { year, "年", month, "月", System.lineSeparator(), "日 月 火 水 木 金 土",
				System.lineSeparator(), "--------------------", System.lineSeparator() };
		for(String tmp : calenderString) {
			stringBuffer.append(tmp);
		}

		// 月初日の曜日を取得する
		// 日曜日:1
		// 月曜日:2
		// 火曜日:3
		// 水曜日:4
		// 木曜日:5
		// 金曜日:6
		// 土曜日:7
		final int firstWeekDate = getDayOfWeek(calendar, firstDate);

		// 月初日の曜日に合わせてスペースを挿入
		for (int i = 1; i < firstWeekDate; i++) {
			stringBuffer.append("   ");
		}

		Date currentDate = firstDate;
		do {
			// 表示用の文字列を取得する
			stringBuffer.append(getDateString(calendar, currentDate));

			// 曜日を取得する
			final int weekDay = getDayOfWeek(calendar, currentDate);
			if(weekDay == 7) {
				stringBuffer.append(System.lineSeparator());
			} else {
				stringBuffer.append(" ");
			}

			// 1日加算する
			currentDate = addDate(calendar, currentDate);

		} while (currentDate.compareTo(lastDate) <= 0);

		return stringBuffer.toString();
	}
	
	/**
	 * 月初日の取得
	 * 
	 * @param yearMonth YYYYMM形式の半角数字
	 * @return 月初日
	 * @throws Exception Exception
	 */
	private Date getFirstDate(final String yearMonth) throws Exception {
		try {
			final DateFormat format = new SimpleDateFormat("yyyyMMdd");
			return format.parse(yearMonth + "01");
		} catch (final Throwable e) {
			throw new Exception("不正な文字列が入力されました。");
		}
	}
	
	/**
	 * 月末日の取得
	 * 
	 * @param calendar Calendarインスタンス
	 * @param date その日
	 * @return 月末日
	 */
	private Date getLastDate(final Calendar calendar, final Date date) {
		calendar.setTime(date);
		int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DATE, day);
		return calendar.getTime();
	}
	
	/**
	 * 曜日の取得
	 * 
	 * @param calendar Calendarインスタンス
	 * @param date 曜日のデータが欲しい日
	 * @return 曜日
	 */
	private int getDayOfWeek(final Calendar calendar, final Date date) {
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * 一日加算する（翌日の日付にする）
	 * 
	 * @param calendar Calendarインスタンス
	 * @param date 翌日にしたい日
	 * @return 翌日の日付
	 */
	private Date addDate(final Calendar calendar, final Date date) {
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	/**
	 * 表示用文字列取得
	 * 
	 * @param calendar Calendarインスタンス
	 * @param date 表示させたい日付
	 * @return 表示させたい日付の文字列
	 */
	private String getDateString(final Calendar calendar, final Date date) {
		calendar.setTime(date);
		final int day = calendar.get(Calendar.DATE);
		return String.format("%02d", day);
	}
}
