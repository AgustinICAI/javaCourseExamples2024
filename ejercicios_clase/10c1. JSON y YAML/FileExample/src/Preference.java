public class Preference {
    public String size;
    public String zoom;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getZoom() {
        return zoom;
    }

    public void setZoom(String zoom) {
        this.zoom = zoom;
    }

    public Preference()
    {

    }


    @Override
    public String toString() {
        return "Preference{" +
                "size='" + size + '\'' +
                ", zoom='" + zoom + '\'' +
                '}';
    }
}
