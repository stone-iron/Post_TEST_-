package com.example.board.dto;

public class Page {

    private int page = 1;
    private int size = 10;
    private int blockSize = 10;
    private int totalCount;
    private int totalPages;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    public Page() {
    }

    public Page(int page, int size) {
        setPage(page);
        setSize(size);
    }

    private void calculate() {
        totalPages = (int) Math.ceil((double) totalCount / size);
        if (totalPages < 1) {
            totalPages = 1;
        }
        if (page > totalPages) {
            page = totalPages;
        }
        startPage = ((page - 1) / blockSize) * blockSize + 1;
        endPage = Math.min(startPage + blockSize - 1, totalPages);
        prev = startPage > 1;
        next = endPage < totalPages;
    }

    public int getOffset() {
        return (page - 1) * size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = Math.max(page, 1);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size < 1 ? 10 : size;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize < 1 ? 10 : blockSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calculate();
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", size=" + size +
                ", totalCount=" + totalCount +
                ", totalPages=" + totalPages +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
