public interface Observable {
    public void register(Observer o);
    public void notifyObserver();
}
