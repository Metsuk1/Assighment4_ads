package entity;

public class Vertex<T> {
    private T data;



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Vertex {data=" + data + "}";
    }


}
