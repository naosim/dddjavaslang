package com.naosim.dddjavaslang.lib.date;

import javaslang.control.Option;

/**
 * イメージ
 *  date0    date1    date2
 * ---+--------+--------+---------
 *      state0   state1   state2
 */
public class DateToStateUtil {
    public static int getSection(
            CurrentDateTime currentDateTime,
            DateValueObjectWithCompareCurrentDateTime firstDate,
            Option<? extends DateValueObjectWithCompareCurrentDateTime>... dateList

    ) {
        // 事前条件
        assert firstDate.isNotFuture(currentDateTime): "最初の日が未来日でないこと";
        Option<? extends DateValueObjectWithCompareCurrentDateTime> lastDate = Option.some(firstDate);
        for(Option<? extends DateValueObjectWithCompareCurrentDateTime> date : dateList) {
            if(lastDate.isEmpty()) {
                assert date.isEmpty(): "空以降はすべて空になること";
            } else if(date.isEmpty()) {
                lastDate = date;
            } else {
                assert !lastDate.get().getValue().isAfter(date.get().getValue()): "日付が昇順に並んでいる事";
            }
        }

        // 状態検索
        int index = 0;
        for(Option<? extends DateValueObjectWithCompareCurrentDateTime> date : dateList) {
            if(date.isEmpty() || date.get().isFuture(currentDateTime)) {
                return index;
            }
            index++;
        }
        return index - 1;
    }
}
