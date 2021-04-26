package ZPO.Command;

public class cw2
{

    public static class Bank
    {
        public void income(Account acc, long amount)
        {
            Income inc = new Income(acc, amount);
            inc.execute();
        }
        public void transfer(Account from, Account to, long amount)
        {
            Transfer inc = new Transfer(from, to, amount);
            inc.execute();
        }
        public void interestChange(Account acc, long amount)
        {
            interestChange inc = new interestChange(acc, amount);
            inc.execute();
        }
    }

    public static class Account
    {
        long balance = 0;
        long interest = 0;

        public void add(long amount)
        {
            this.balance += amount;
        }

        public void remove(long amount)
        {
            this.balance -= amount;
        }

        public long getBalance()
        {
            return balance;
        }

        public void setInterest(long interest)
        {
            this.interest = interest;
        }

        public void computeInterestA(int deadline, int payment, long amount)
        {
            InterestA interest = new InterestA(deadline, payment,amount);
            interest.compute();
        }

        public void computeInterestB(int deadline, int payment, long amount)
        {
            InterestB interest = new InterestB(deadline, payment,amount);
            interest.compute();
        }

        public void computeInterestC(int deadline, int payment, long amount)
        {
            InterestC interest = new InterestC(deadline, payment,amount);
            interest.compute();
        }
    }

    interface Operation
    {
        void execute();
    }

    public static class Income implements Operation
    {
        Account acc;
        long amount;

        Income(Account acc, long amount)
        {
            this.acc = acc;
            this.amount = amount;
        }
        public void execute()
        {
            acc.add(amount);
        }
    }

    public static class Transfer implements Operation
    {
        Account from;
        Account to;
        long amount;

        Transfer(Account from, Account to, long amount)
        {
            this.from = from;
            this.to = to;
            this.amount = amount;
        }
        public void execute()
        {
            from.remove(amount);
            to.add(amount);
        }
    }

    public static class interestChange implements Operation
    {
        Account acc;
        long amount;

        interestChange(Account acc, long amount)
        {
            this.acc = acc;
            this.amount = amount;
        }
        public void execute()
        {
            acc.setInterest(amount);
        }
    }

    interface Interest
    {
        void compute();
    }

    public static class InterestA implements Interest
    {
        long amount;
        int deadlineYear;
        int paymentYear;

        InterestA(int deadlineYear, int paymentYear, long amount)
        {
            this.amount = amount;
            this.deadlineYear = deadlineYear;
            this.paymentYear = paymentYear;
        }
        public void compute()
        {
            float interest = ((paymentYear - deadlineYear) * 0.2f) * amount;
            System.out.println(interest);
        }
    }

    public static class InterestB implements Interest
    {
        long amount;
        int deadlineYear;
        int paymentYear;

        InterestB(int deadlineYear, int paymentYear, long amount)
        {
            this.amount = amount;
            this.deadlineYear = deadlineYear;
            this.paymentYear = paymentYear;
        }
        public void compute()
        {
            float interest = ((paymentYear - deadlineYear) * 0.4f) * amount;
            System.out.println(interest);
        }
    }

    public static class InterestC implements Interest
    {
        long amount;
        int deadlineYear;
        int paymentYear;

        InterestC(int deadlineYear, int paymentYear, long amount)
        {
            this.amount = amount;
            this.deadlineYear = deadlineYear;
            this.paymentYear = paymentYear;
        }
        public void compute()
        {
            float interest = ((paymentYear - deadlineYear) * 0.8f) * amount;
            System.out.println(interest);
        }
    }

    public static void main(String[]args)
    {
        Bank Bank1 = new Bank();
        Account acc1 = new Account();
        Account acc2 = new Account();

        Bank1.income(acc1, 200);
        Bank1.transfer(acc1, acc2, 150);

        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
    }

}
