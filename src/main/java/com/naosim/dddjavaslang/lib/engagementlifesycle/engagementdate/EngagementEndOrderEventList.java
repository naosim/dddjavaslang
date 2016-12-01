package com.naosim.dddjavaslang.lib.engagementlifesycle.engagementdate;

import javaslang.Tuple2;
import javaslang.collection.List;
import javaslang.control.Option;
import lombok.AllArgsConstructor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@AllArgsConstructor
public class EngagementEndOrderEventList<EOD extends EngagementEndOrderDate, ECOD extends EngagementEndCancelOrderDate> {
    private final List<Tuple2<EOD, Option<ECOD>>> engagementEndOrderList;

    /**
     * 最後の終了申込日を取得する
     * キャンセルが入ってるものは対象外
     * @return
     */
    public Option<EOD> getLastEngagementEndOrderDate() {
        throw new NotImplementedException();
    }
}
