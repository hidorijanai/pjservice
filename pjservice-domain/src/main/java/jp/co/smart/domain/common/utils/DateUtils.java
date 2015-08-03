package jp.co.smart.domain.common.utils;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.terasoluna.gfw.common.date.jodatime.JodaTimeDateFactory;

public class DateUtils {

	@Inject
	JodaTimeDateFactory dateFactory;

	/**
	 * ミリ秒まで取得
	 * @return
	 */
	public DateTime getSysDate() {
		DateTime dateTime = dateFactory.newDateTime();
		return dateTime;
	}

	/**
	 * タイムゾーンを指定せず現在時刻を取得
	 * @return
	 */
	public DateTime getTimeZoneDateTime(String timeZone) {
		DateTime dateTime = dateFactory.newDateTime();
		DateTime timeZoneDateTime = dateTime.withZone(DateTimeZone.forID(timeZone));
		//DateTime timeZoneDateTime = dateTime.withZone(DateTimeZone.forID("Asia/Tokyo"));
		return timeZoneDateTime;
	}

	/**
	 * タイムゾーンを指定して現在時刻を取得
	 * @return
	 */
	public LocalDateTime getLocalDateTime() {
		LocalDateTime localDateTime = dateFactory.newDateTime().toLocalDateTime();
		return localDateTime;
	}

	/**
	 * TimeZoneと、時間を除いた日付だけ取得
	 * @return
	 */
	public LocalDate getLocalDate() {
		LocalDate localDate = dateFactory.newDateTime().toLocalDate();
		return localDate;
	}

	/**
	 * TimeZoneと、日付を除いた時間だけ取得
	 * @return
	 */
	public LocalTime getLocalTime() {
		LocalTime localTime = dateFactory.newDateTime().toLocalTime();
		return localTime;
	}
}
