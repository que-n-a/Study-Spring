package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

    private int startPage;
    private int endPage;
    private boolean prev, next;

    private int total; // 전체 데이터 수
    private Criteria cri;

    public PageDTO(Criteria cri, int total) { // 생성자 정의

        this.cri = cri;
        this.total = total;

        this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10; // amount 10
        this.startPage = this.endPage - 9;

        int realEnd = (int) (Math.ceil(total * 1.0) / cri.getAmount()); // 전체 데이터 *

        if (realEnd < this.startPage) {
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;

        this.next = this.endPage < realEnd;
    }
}
