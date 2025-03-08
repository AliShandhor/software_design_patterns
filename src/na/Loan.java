package na;

import java.util.Date;
public class Loan {
        int loanId;
        Book book;
        Member member;
        Date loanDate;

    Loan(int loanId, Book book, Member member, Date loanDate){
        this.loanId = loanId;
        this.book = book;
        this.member = member;
        this.loanDate = loanDate;
    }
    public int getLoanId() {
        return loanId;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public Date getLoanDate() {
        return loanDate;
    }

}
