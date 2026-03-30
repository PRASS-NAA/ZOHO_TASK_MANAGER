public enum Priority {
    HIGH(5), MEDIUM(3), LOW(1);

    private int priorityVal;

    Priority(int priorityVal)
    {
        this.priorityVal = priorityVal;
    }

    public int getPriorityVal()
    {
        return this.priorityVal;
    }
} 