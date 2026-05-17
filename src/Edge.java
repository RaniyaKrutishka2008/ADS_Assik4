class Edge {
    private Vertex src;
    private Vertex dest;

    public Edge(Vertex src, Vertex dest) {
        this.src = src;
        this.dest = dest;
    }

    public Vertex getSrc() {
        return src;
    }

    public Vertex getDest() {
        return dest;
    }

    @Override
    public String toString() {
        return src + " -> " + dest;
    }
}